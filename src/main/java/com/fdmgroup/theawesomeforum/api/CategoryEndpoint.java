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

import com.fdmgroup.theawesomeforum.forum.category.Category;
import com.fdmgroup.theawesomeforum.forum.category.CategoryService;

@Path("/categories")
public class CategoryEndpoint {
	CategoryService categoryService = new CategoryService();
    private static final Logger LOG = LogManager.getLogger("CategoryEndpoint");

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategory(Category category, @Context UriInfo uriInfo) {
		categoryService.create(category);
		URI createdURI = uriInfo.getBaseUriBuilder().path(Long.toString(category.getId())).build();
		LOG.info("Category with id " + category.getId() + " created.");
		return Response.created(createdURI).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCategory(long id) {
		categoryService.delete(id);
		LOG.info("Category with id " + id + " deleted.");
	}

	@GET
	@Path("/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCategory(@PathParam("id") long id) {
		LOG.debug("findCategory was called with "+ id);
		Category category = categoryService.readById(id);
		if (category != null) {
			LOG.debug("Category with id " + id + " not found");
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		LOG.info("Category with id " + id + " found and returned.");
		return Response.ok(category).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategories() {
		List<Category> categories = categoryService.readAll();
		if (categories.size() == 0) {
			LOG.info("No categories found");
			return Response.noContent().build();
		}
		Response response = Response.ok(categories).build(); 
		LOG.info("Categories found - " + response.toString());
		return response;
	}

	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public Response countCategories() {
		System.out.println("LALALALALA");
		LOG.info("Categories counted");
		return Response.ok(categoryService.count()).build();
	}
}
