package com.fdmgroup.theawesomeforum.forum.profanity;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;


public class ProfanityJPACRUD implements CRUD<Profanity> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public ProfanityJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("theawesomeforum");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public Profanity create(Profanity profanity) {
		beginTransaction();
		entityManager.persist(profanity);
		commitTransaction();
		return profanity;
	}

	public boolean update(Profanity profanity) {
		beginTransaction();
		entityManager.merge(profanity);
		commitTransaction();
		return true;
	}

	public void delete(long id) {
		beginTransaction();
		entityManager.remove(entityManager.getReference(Profanity.class, id));
		commitTransaction();
	}

	public Profanity readOneById(long id) {
		Profanity profanity = entityManager.find(Profanity.class, id);
		return profanity;
	}

	public List<Profanity> readAll() {

		TypedQuery<Profanity> typedQuery = entityManager.createQuery("SELECT p FROM PROFANITIES p", Profanity.class);
		List<Profanity> profanities = typedQuery.getResultList();
		return profanities;
	}

	public List<Profanity> readAllFromOneUser() {

		TypedQuery<Profanity> typedQuery = entityManager.createQuery("SELECT c FROM PROFANITIES c", Profanity.class);
		List<Profanity> profanities = typedQuery.getResultList();
		return profanities;

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
	

	public long count() {
		TypedQuery<Long> query = entityManager.createQuery("SELECT count(e) from PROFANITIES e", Long.class);
		return query.getSingleResult();
	}
	
	public List<Profanity> findByString(String string){
		@SuppressWarnings("unchecked")
		List<Profanity> profanities = entityManager.createNamedQuery("PROFANITIES.readByString")
		            .setParameter("searchString", string)
		            .getResultList();
		 return profanities;
	}

	

}
