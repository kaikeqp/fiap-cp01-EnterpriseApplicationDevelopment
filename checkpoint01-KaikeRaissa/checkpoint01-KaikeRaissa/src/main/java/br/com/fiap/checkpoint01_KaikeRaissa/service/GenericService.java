package br.com.fiap.checkpoint01_KaikeRaissa.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.checkpoint01_KaikeRaissa.dao.PersistenceManager;

public abstract class GenericService<T extends Serializable, PK extends Serializable> {

	private EntityManager entityManager;

	public abstract void cadastrar(T entidade);

	public abstract void atualizar(T entidade);

	public abstract void remover(PK id);

	public abstract T obter(PK id);

	public abstract List<T> listar();

	public EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();
		}

		return entityManager;
	}

	public void closeEntityManager() {
		if (entityManager != null || entityManager.isOpen()) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().commit();
			}
			entityManager.close();
		}
	}
}
