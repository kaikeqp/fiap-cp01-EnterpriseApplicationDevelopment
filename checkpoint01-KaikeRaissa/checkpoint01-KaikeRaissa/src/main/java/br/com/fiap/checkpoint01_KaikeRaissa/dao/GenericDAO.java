package br.com.fiap.checkpoint01_KaikeRaissa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDAO<T extends Serializable, PK extends Serializable>{

	void salvar(T entidade, EntityManager entityManager);
	void atualizar(T entidade, EntityManager entityManager);
	void remover(PK id, EntityManager entityManager);
	T obterPorId(PK id, EntityManager entityManager);
	List<T> listar(EntityManager entityManager);

}

