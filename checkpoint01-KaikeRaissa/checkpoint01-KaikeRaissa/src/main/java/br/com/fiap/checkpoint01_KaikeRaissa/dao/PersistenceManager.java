package br.com.fiap.checkpoint01_KaikeRaissa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private static PersistenceManager instance = null;
	
	private EntityManagerFactory entityManagerFactory;
	
	private PersistenceManager () {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("FIAP_PU");
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static PersistenceManager getInstance() {		
		if(instance == null) {
			instance = new PersistenceManager();
		}
		
		return instance;
	}
}
