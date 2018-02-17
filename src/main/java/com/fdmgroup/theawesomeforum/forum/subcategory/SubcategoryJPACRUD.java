package com.fdmgroup.theawesomeforum.forum.subcategory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;

public class SubcategoryJPACRUD implements CRUD<Subcategory> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public SubcategoryJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("theawesomeforum");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public Subcategory create(Subcategory subcategory) {
		beginTransaction();
		entityManager.persist(subcategory);
		commitTransaction();
		return subcategory;
	}

	public boolean update(Subcategory subcategory) {
		beginTransaction();
		entityManager.merge(subcategory);
		commitTransaction();
		return true;
	}

	public void delete(long id) {
		beginTransaction();
		entityManager.remove(entityManager.getReference(Subcategory.class, id));
		commitTransaction();
	}

	public Subcategory readOneById(long id) {
		Subcategory subcategory = entityManager.find(Subcategory.class, id);
		return subcategory;
	}

	public List<Subcategory> readAll() {
		TypedQuery<Subcategory> typedQuery = entityManager.createQuery("SELECT c FROM SUBCATEGORIES c", Subcategory.class);
		List<Subcategory> subcategories = typedQuery.getResultList();
		return subcategories;
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
	public List<Subcategory> readAllFromOneUser(User user){
		TypedQuery<Subcategory> typedQuery =entityManager.createQuery("SELECT s FROM SUBCATEGORIES s WHERE id=" + user.getId(), Subcategory.class);
		List<Subcategory> subcategories = typedQuery.getResultList();
		return subcategories;
		
	}
	
	@Override
	public long count() {
		TypedQuery<Long> query = entityManager.createQuery("SELECT count(s) from SUBCATEGORIES s", Long.class);
		return query.getSingleResult();
	}
	
	public List<Subcategory> findByString(String string){
		@SuppressWarnings("unchecked")
		List<Subcategory> subcategories = entityManager.createNamedQuery("SUBCATEGORIES.readByString")
		            .setParameter("searchString", string)
		            .getResultList();
		 return subcategories;
	}

}
