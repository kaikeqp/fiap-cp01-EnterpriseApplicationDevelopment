package br.com.fiap.checkpoint01_KaikeRaissa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class HibernateGenericDAO<T extends Serializable, PK extends Serializable> implements GenericDAO<T, PK>{

	private Class<T> type;
	
	public HibernateGenericDAO(Class<T> type) {
		this.type =  type;
	}
	
	@Override
	public void salvar(T entidade, EntityManager entityManager) {
		entityManager.persist(entidade);
	}

	@Override
	public void atualizar(T entidade, EntityManager entityManager) {
		entityManager.merge(entidade);
	}

	@Override
	public void remover(PK id, EntityManager entityManager) {
		T entidade = obterPorId(id, entityManager);
		entityManager.remove(entidade);
	}

	@Override
	public T obterPorId(PK id, EntityManager entityManager) {
		return entityManager.find(type, id);
	}

	@Override
	public List<T> listar(EntityManager entityManager) {
		Query consulta = entityManager.createQuery("SELECT o FROM "+type.getName()+ " o");
		return consulta.getResultList();
	}
}
