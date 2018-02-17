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

import com.fdmgroup.theawesomeforum.forum.discussion.Discussion;
import com.fdmgroup.theawesomeforum.forum.discussion.DiscussionService;

@Path("/discussions")
public class DiscussionEndpoint {
	DiscussionService discussionService = new DiscussionService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDiscussion(Discussion discussion, @Context UriInfo uriInfo) {
		discussionService.create(discussion);
		URI createdURI = uriInfo.getBaseUriBuilder().path(Long.toString(discussion.getId())).build();
		return Response.created(createdURI).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteDiscussion(long id) {
		discussionService.delete(id);
	}

	@GET
	@Path("/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findDiscussion(@PathParam("id") long id) {
		Discussion discussion = discussionService.readById(id);
		if (discussion != null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(discussion).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDiscussions() {
		List<Discussion> entries = discussionService.readAll();
		if (entries.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(entries).build();
	}

	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public Response count() {
		return Response.ok(discussionService.count()).build();
	}
}
