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

import com.fdmgroup.theawesomeforum.forum.subcategory.Subcategory;
import com.fdmgroup.theawesomeforum.forum.subcategory.SubcategoryService;

@Path("/subcategories")
public class SubcategoriesEndpoint {
	SubcategoryService subcategoryService = new SubcategoryService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createSubcategory(Subcategory subcategory, @Context UriInfo uriInfo) {
		subcategoryService.create(subcategory);
		URI createdURI = uriInfo.getBaseUriBuilder().path(Long.toString(subcategory.getId())).build();
		return Response.created(createdURI).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteSubcategory(long id) {
		subcategoryService.delete(id);
	}

	@GET
	@Path("/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findSubcategory(@PathParam("id") long id) {
		Subcategory subcategory = subcategoryService.readById(id);
		if (subcategory != null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(subcategory).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSubcategories() {
		List<Subcategory> entries = subcategoryService.readAll();
		if (entries.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(entries).build();
	}

	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public Response countSubcategories() {
		return Response.ok(subcategoryService.count()).build();
	}
}
