package com.fdmgroup.theawesomeforum.forum.entry;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;

public class EntryJPACRUD implements CRUD<Entry> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public EntryJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("theawesomeforum");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public Entry create(Entry entry) {
		beginTransaction();
		entityManager.persist(entry);
		commitTransaction();
		return entry;
	}

	public boolean update(Entry entry) {
		beginTransaction();
		entityManager.merge(entry);
		commitTransaction();
		return true;
	}

	public void delete(long id) {
		beginTransaction();
		entityManager.remove(entityManager.getReference(Entry.class, id));
		commitTransaction();
	}

	public Entry readOneById(long id) {
		Entry entry = entityManager.find(Entry.class, id);
		return entry;
	}

	public List<Entry> readAll() {
		TypedQuery<Entry> typedQuery = entityManager.createQuery("SELECT c FROM ENTRIES c", Entry.class);
		List<Entry> entries = typedQuery.getResultList();
		return entries;
	}

	public List<Entry> readAllFromOneUser(User user) {
		Query query = entityManager.createQuery("SELECT u from USERS u WHERE "
				+ "ENTRIES.ID = :ENTRIES_ID "
				+ "AND u.ID = :USERS_ID");
		@SuppressWarnings("unchecked")
		List<Entry> entries = query.getResultList();
		return entries; 

	}

	private void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	private void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	public JPAConnectionManager getJPAConnectionManager() {
		return jpaConnectionManager;
	}
	
	@Override
	public long count() {
		TypedQuery<Long> query = entityManager.createQuery("SELECT count(e) from ENTRIES e", Long.class);
		return query.getSingleResult();
	}
	
	public List<Entry> findByString(String string){
		@SuppressWarnings("unchecked")
		List<Entry> entries = entityManager.createNamedQuery("ENTRIES.readByString")
		            .setParameter("searchString", string)
		            .getResultList();
		 return entries;
	}
	
	public List<Entry> findByDate(LocalDateTime dateOfEntry){
		@SuppressWarnings("unchecked")
		List<Entry> entries = entityManager.createNamedQuery("ENTRIES.searchByDate")
		            .setParameter("searchDate", dateOfEntry)
		            .getResultList();
		 return entries;
	}

}
