package com.fdmgroup.theawesomeforum.forum.category;

import java.util.List;

import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.ForumServiceInterface;

public class CategoryService implements ForumServiceInterface<Category>{

	private CRUD<Category> categoryJPACRUD;

	public CategoryService() {
		categoryJPACRUD = new CategoryJPACRUD();
	}

	public CategoryService(CategoryJPACRUD categoryJPACRUD) {
		this.categoryJPACRUD = categoryJPACRUD;
	}

	public void create(Category category) {
		categoryJPACRUD.create(category);
	}

	public void delete(long id) {
		categoryJPACRUD.delete(id);
	}

	public void update(Category category) {
		categoryJPACRUD.update(category);
	}

	public List<Category> readAll() {
		return categoryJPACRUD.readAll();
	} 

	public Category readById(long id) {
		return categoryJPACRUD.readOneById(id);
	}

	public long count() {
		return categoryJPACRUD.count();
	}
	
	public List<Category> findByString(String string){
		 return this.categoryJPACRUD.findByString(string);
	}
	
}
