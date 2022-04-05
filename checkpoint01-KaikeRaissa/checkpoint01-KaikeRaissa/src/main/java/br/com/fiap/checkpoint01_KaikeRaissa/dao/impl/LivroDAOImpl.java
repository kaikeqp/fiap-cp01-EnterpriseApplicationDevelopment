package br.com.fiap.checkpoint01_KaikeRaissa.dao.impl;

import br.com.fiap.checkpoint01_KaikeRaissa.dao.HibernateGenericDAO;
import br.com.fiap.checkpoint01_KaikeRaissa.entity.Livro;

public class LivroDAOImpl extends HibernateGenericDAO<Livro, Long>{

	private static LivroDAOImpl instance = null;

	private LivroDAOImpl() {
		super(Livro.class);
	}

	public static LivroDAOImpl getInstance() {
		if (instance == null) {
			instance = new LivroDAOImpl();
		}
		return instance;
	}
}
