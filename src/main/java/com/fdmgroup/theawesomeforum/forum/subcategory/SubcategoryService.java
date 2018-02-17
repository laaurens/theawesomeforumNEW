package com.fdmgroup.theawesomeforum.forum.subcategory;

import java.util.List;

import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

public class SubcategoryService implements ForumServiceInterface<Subcategory> {

	private CRUD<Subcategory> subcategoryJPACRUD;

	public SubcategoryService() {
		subcategoryJPACRUD = new SubcategoryJPACRUD();
	}

	public SubcategoryService(SubcategoryJPACRUD subcategoryJPACRUD) {
		this.subcategoryJPACRUD = subcategoryJPACRUD;
	}

	public void create(Subcategory subcategory) {
		subcategoryJPACRUD.create(subcategory);
	}

	public void delete(long id) {
		subcategoryJPACRUD.delete(id);
	}

	public void update(Subcategory subcategory) {
		subcategoryJPACRUD.update(subcategory);
	}

	public List<Subcategory> readAll() {
		return subcategoryJPACRUD.readAll();
	}

	public Subcategory readById(long id) {
		return subcategoryJPACRUD.readOneById(id);
	}

	public long count() {
		return subcategoryJPACRUD.count();

	}
}
