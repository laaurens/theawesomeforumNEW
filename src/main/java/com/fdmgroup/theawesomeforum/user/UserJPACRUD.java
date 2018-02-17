package com.fdmgroup.theawesomeforum.user;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.theawesomeforum.forum.entry.Entry;
import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;

public class UserJPACRUD implements CRUD<User> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public UserJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("theawesomeforum");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public User create(User user) {
		beginTransaction();
		entityManager.persist(user);
		commitTransaction();
		return user;
	}

	public boolean update(User user) {
		beginTransaction();
		entityManager.merge(user);
		commitTransaction();
		return true;
	}

	public void delete(long id) {
		beginTransaction();
		entityManager.remove(entityManager.getReference(User.class, id));
		commitTransaction();
	}

	public User readOneById(long id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	public User readOneByName(String userName) {
		TypedQuery<User> typedQuery = entityManager
				.createQuery("SELECT c FROM USERS c WHERE USERNAME='" + userName + "'", User.class);
		User user = null;
		List<User> results = typedQuery.getResultList();
		if (!results.isEmpty()) {
			user = (User) results.get(0);

		}
		return user;
	}

	public List<User> readAll() {
		TypedQuery<User> typedQuery = entityManager.createQuery("SELECT c FROM USERS c", User.class);
		List<User> users = typedQuery.getResultList();
		return users;
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

	public List<User> readAllFromOneUser(User user) {
		TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM USERS u WHERE id=" + user.getId(),
				User.class);
		List<User> users = typedQuery.getResultList();
		return users;

	}

	@Override
	public long count() {
		TypedQuery<Long> query = entityManager.createQuery("SELECT count(u) from USERS u", Long.class);
		return query.getSingleResult();
	}

	public List<User> findByString(String string) {
		@SuppressWarnings("unchecked")
		List<User> users = entityManager.createNamedQuery("USERS.readByString").setParameter("searchString", string)
				.getResultList();
		return users;
	}

	public List<Entry> findAllEntriesFromOneUserSortedByDate(User user) {
		TypedQuery<Entry> typedQuery = entityManager.createQuery(
				"SELECT e FROM ENTRIES e WHERE USER_ID=" + user.getId() + "ORDER BY DATE_OF_ENTRY DESC", Entry.class);
		List<Entry> entries = typedQuery.getResultList();
		return entries;

	}

	public List<User> readByEmail(String string) {
		@SuppressWarnings("unchecked")
		List<User> users = entityManager.createNamedQuery("USERS.readByEmail").setParameter("searchString", string)
				.getResultList();
		return users;
	}

	public List<User> readByBirthday(String string) {
		LocalDate date = LocalDate.now();
		@SuppressWarnings("unchecked")
		List<User> users = entityManager.createNamedQuery("USERS.readByBirthday").setParameter("searchString", date)
				.getResultList();
		return users;
	}

}
