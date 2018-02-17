package com.fdmgroup.theawesomeforum.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnectionManager {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private static JPAConnectionManager instance;

	public static JPAConnectionManager getJPAConnectionManager(String persistenceUnit){
		if(instance == null){
			instance = new JPAConnectionManager(persistenceUnit);
		}
		return instance;
	}
	private JPAConnectionManager(String persistenceUnit) {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void closeEntityManagerFactory() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
