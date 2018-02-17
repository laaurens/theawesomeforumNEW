package com.fdmgroup.theawesomeforum.forum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.forum.category.Category;
import com.fdmgroup.theawesomeforum.forum.category.CategoryJPACRUD;
import com.fdmgroup.theawesomeforum.forum.category.CategoryService;
import com.fdmgroup.theawesomeforum.user.User;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	@Mock
	CategoryJPACRUD categoryJPACRUD;
	Category category;
	User user;
	
	CategoryService categoryService;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		categoryService = new CategoryService(categoryJPACRUD);
		category = new Category();
		user = new User();
	}

	@Test
	public void test_addCategory() {
		categoryService.create(category);
		Mockito.verify(categoryJPACRUD).create(category);
	}

	@Test
	public void test_removeCategory() {
		categoryService.delete(category.getId());
		Mockito.verify(categoryJPACRUD).delete(category.getId());
	}

	@Test
	public void test_updateCategory() {
		categoryService.update(category);
		Mockito.verify(categoryJPACRUD).update(category);
	}

	@Test
	public void test_findAllCategories() {
		categoryService.readAll();
		Mockito.verify(categoryJPACRUD).readAll();
	}

	@Test
	public void test_findCategoryById() {
		categoryService.readById(1);
		Mockito.verify(categoryJPACRUD).readOneById(1);
	}
	
	@Test
	public void test_countCategories() {
		categoryService.count();
		Mockito.verify(categoryJPACRUD).count();
	}
	
	@Test
	public void test_findCategoryByString() {
		categoryService.findByString("TestString");
		Mockito.verify(categoryJPACRUD).findByString("TestString");
	}
}
