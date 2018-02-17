package com.fdmgroup.theawesomeforum.forum.discussion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fdmgroup.theawesomeforum.forum.category.Category;
import com.fdmgroup.theawesomeforum.user.User;
import com.fdmgroup.theawesomeforum.utility.CRUD;
import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;

public class DiscussionJPACRUD implements CRUD<Discussion> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public DiscussionJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("theawesomeforum");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public Discussion create(Discussion discussion) {
		beginTransaction();
		entityManager.persist(discussion);
		commitTransaction();
		return discussion;
	}

	public boolean update(Discussion discussion) {
		beginTransaction();
		entityManager.merge(discussion);
		commitTransaction();
		return true;
	}

	public void delete(long id) {
		beginTransaction();
		entityManager.remove(entityManager.getReference(Discussion.class, id));
		commitTransaction();
	}

	public Discussion readOneById(long id) {
		Discussion discussion = entityManager.find(Discussion.class, id);
		return discussion;
	}
	
	public Category findParentCategory(Discussion discussion) {
		TypedQuery<Category> typedQuery = entityManager.createQuery("SELECT c FROM CATEGORIES c "
				+ "INNER JOIN categories_discussions cd "
				+ "ON cd.id = c.id "
				+ "INNER JOIN discussions d "
				+ "ON d.id = cd.id "
				+ "WHERE d.id = X", Category.class);
		Category category= typedQuery.getSingleResult();
		return category;
	}

	public List<Discussion> readAll() {
		TypedQuery<Discussion> typedQuery = entityManager.createQuery("SELECT c FROM DISCUSSIONS c", Discussion.class);
		List<Discussion> discussions = typedQuery.getResultList();
		return discussions;
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
	public List<Discussion> readAllFromOneUser(User user){
		TypedQuery<Discussion> typedQuery =entityManager.createQuery("SELECT d FROM Discussions d WHERE id=" + user.getId(), Discussion.class);
		List<Discussion> discussions = typedQuery.getResultList();
		return discussions;
		
	};
	
	@Override
	public long count() {
		TypedQuery<Long> query = entityManager.createQuery("SELECT count(d) from DISCUSSION d", Long.class);
		return query.getSingleResult();
	}
	
	public List<Discussion> findByString(String string){
		@SuppressWarnings("unchecked")
		List<Discussion> discussions = entityManager.createNamedQuery("DISCUSSIONS.readByString")
		            .setParameter("searchString", string)
		            .getResultList();
		 return discussions;
	}
	
//	public Discussion findByEntryId(long entryId){
//		TypedQuery<Discussion> query = (TypedQuery<Discussion>) entityManager.createQuery("SELECT d FROM DISCUSSIONS_ENTRIES d WHERE d.ENTRIES_ID= :entryId", Discussion.class);
//		query.setParameter("entryId", entryId);
//		return query.getResultList().get(0);
//	}

}
