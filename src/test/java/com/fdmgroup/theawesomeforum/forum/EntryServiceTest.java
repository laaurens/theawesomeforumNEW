package com.fdmgroup.theawesomeforum.forum;


import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.forum.entry.EntryJPACRUD;
import com.fdmgroup.theawesomeforum.forum.entry.EntryService;
import com.fdmgroup.theawesomeforum.user.User;

@RunWith(MockitoJUnitRunner.class)
public class EntryServiceTest {

	@Mock
	EntryJPACRUD entryJPACRUD;
	Entry entry;
	User user;

	EntryService entryService;

	@Before
	public void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		entryService = new EntryService(entryJPACRUD);
		entry = new Entry();
		user = new User();
	}

	@Test
	public void test_addEntry() {
		entryService.create(entry);
		Mockito.verify(entryJPACRUD).create(entry);
	}

	@Test
	public void test_removeEntry() {
		entryService.delete(entry.getId());
		Mockito.verify(entryJPACRUD).delete(entry.getId());
	}

	@Test
	public void test_updateEntry() {
		entryService.update(entry);
		Mockito.verify(entryJPACRUD).update(entry);
	}

	@Test
	public void test_findAllCategories() {
		entryService.readAll();
		Mockito.verify(entryJPACRUD).readAll();
	}

	@Test
	public void test_findEntryById() {
		entryService.readById(1);
		Mockito.verify(entryJPACRUD).readOneById(1);
	}
	
	@Test
	public void test_countEntries() {
		entryService.count();
		Mockito.verify(entryJPACRUD).count();
	}
	
	@Test
	public void test_countEntriesForOneUser() {
		entryService.countForOneUser(user);
		Mockito.verify(entryJPACRUD).readAllFromOneUser(user);
	}
	
	@Test
	public void test_searchByDate() {
		LocalDateTime date = LocalDateTime.of(2018, 1, 30,0,0,0);
		entryService.findByDate(date);
		Mockito.verify(entryJPACRUD).findByDate(date);
	}
	
	@Test
	public void test_findByString() {
		entryService.findByString("TestString");
		Mockito.verify(entryJPACRUD).findByString("TestString");
	}
	
	
}
