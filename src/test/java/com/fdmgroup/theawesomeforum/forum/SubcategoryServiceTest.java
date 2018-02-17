package com.fdmgroup.theawesomeforum.forum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.forum.subcategory.Subcategory;
import com.fdmgroup.theawesomeforum.forum.subcategory.SubcategoryJPACRUD;
import com.fdmgroup.theawesomeforum.forum.subcategory.SubcategoryService;

@RunWith(MockitoJUnitRunner.class)
public class SubcategoryServiceTest {

	@Mock
	SubcategoryJPACRUD subcategoryJPACRUD;
	Subcategory subcategory;

	SubcategoryService subcategoryService;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		subcategoryService = new SubcategoryService(subcategoryJPACRUD);
		subcategory = new Subcategory();
	}

	@Test
	public void test_addSubcategory() {
		subcategoryService.create(subcategory);
		Mockito.verify(subcategoryJPACRUD).create(subcategory);
	}

	@Test
	public void test_removeSubcategory() {
		subcategoryService.delete(subcategory.getId());
		Mockito.verify(subcategoryJPACRUD).delete(subcategory.getId());
	}

	@Test
	public void test_updateSubcategory() {
		subcategoryService.update(subcategory);
		Mockito.verify(subcategoryJPACRUD).update(subcategory);
	}

	@Test
	public void test_findAllCategories() {
		subcategoryService.readAll();
		Mockito.verify(subcategoryJPACRUD).readAll();
	}

	@Test
	public void test_findSubcategoryById() {
		subcategoryService.readById(1);
		Mockito.verify(subcategoryJPACRUD).readOneById(1);
	}
	
	@Test
	public void test_countSubcategories() {
		subcategoryService.count();
		Mockito.verify(subcategoryJPACRUD).count();
	}
	
}
