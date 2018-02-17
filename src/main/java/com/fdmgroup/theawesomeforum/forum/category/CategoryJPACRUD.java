package com.fdmgroup.theawesomeforum.forum.category;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;

public class CategoryJPACRUD implements CRUD<Category> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;
 
	public CategoryJPACRUD() {
		jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("theawesomeforum");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public Category create(Category category) {
		beginTransaction();
		entityManager.persist(category);
		commitTransaction();
		return category;
	}

	public boolean update(Category category) {
		beginTransaction();
		entityManager.merge(category);
		commitTransaction();
		return true;
	}

	public void delete(long id) {
		beginTransaction();
		entityManager.remove(entityManager.getReference(Category.class, id));
		commitTransaction();
	}

	public Category readOneById(long id) {
		Category category = entityManager.find(Category.class, id);
		return category;
	}

	public List<Category> readAll() {
		TypedQuery<Category> typedQuery = entityManager.createQuery("SELECT c FROM CATEGORIES c", Category.class);
		List<Category> categories = typedQuery.getResultList();
		return categories;
	}

	private void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	private void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	public JPAConnectionManager getJPAConnectionManager(){
		return jpaConnectionManager;
	}
	public List<Category> readAllFromOneUser(User user){
		TypedQuery<Category> typedQuery =entityManager.createQuery("SELECT c FROM CATEGORIES c WHERE id=" + user.getId(), Category.class);
		List<Category> categories = typedQuery.getResultList();
		return categories;
		
	}
	
	@Override
	public long count() {
		TypedQuery<Long> query = entityManager.createQuery("SELECT count(c) from CATEGORIES c", Long.class);
		return query.getSingleResult();
	}
	
	public List<Category> findByString(String string){
		@SuppressWarnings("unchecked")
		List<Category> categories = entityManager.createNamedQuery("CATEGORIES.readByString")
		            .setParameter("searchString", string)
		            .getResultList();
		 return categories;
	}

}
