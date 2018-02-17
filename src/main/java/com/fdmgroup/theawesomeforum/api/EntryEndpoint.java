package com.fdmgroup.theawesomeforum.api;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.entry.EntryService;

@Path("/entries")
public class EntryEndpoint {
	EntryService entryService = new EntryService();
    private static final Logger LOG = LogManager.getLogger("CategoryEndpoint");

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEntry(Entry entry, @Context UriInfo uriInfo) {
		entryService.create(entry);
		LOG.info("Category with id " + entry.getId() + " created.");
		URI createdURI = uriInfo.getBaseUriBuilder().path(Long.toString(entry.getId())).build();
		return Response.created(createdURI).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEntry(long id) {
		entryService.delete(id);
	}

	@GET
	@Path("/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findEntry(@PathParam("id") long id) {
		Entry entry = entryService.readById(id);
		if (entry != null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(entry).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEntries() {
		List<Entry> entries = entryService.readAll();
		if (entries.size() == 0) {
			return Response.noContent().build();
		}
		Response response = Response.ok(entries).build();
		LOG.info("Categories found - " + response.toString());
		return response;
	}

	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public Response countEntries() {
		return Response.ok(entryService.count()).build();
	}
}
