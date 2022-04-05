package br.com.fiap.checkpoint01_KaikeRaissa.service.Impl;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.checkpoint01_KaikeRaissa.dao.impl.LivroDAOImpl;
import br.com.fiap.checkpoint01_KaikeRaissa.entity.Livro;
import br.com.fiap.checkpoint01_KaikeRaissa.service.GenericService;

public class LivroServiceImpl extends GenericService<Livro, Long>{

	private static LivroServiceImpl instance = null;

	private LivroDAOImpl LivroDAO;

	private LivroServiceImpl() {
		this.LivroDAO = LivroDAOImpl.getInstance();
	}

	public static LivroServiceImpl getInstance() {
		if (instance == null) {
			instance = new LivroServiceImpl();
		}
		return instance;

	}

	@Override
	public void cadastrar(Livro entidade) {
		try {
			LivroDAO.salvar(entidade, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Livro entidade) {
		try {
			LivroDAO.atualizar(entidade, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}
	
	public void atualizarDataPublicacao(Long id, LocalDate dataPublicacao) {
		try {
			Livro livro = LivroDAO.obterPorId(id, getEntityManager());
			livro.setDataPublicacao(dataPublicacao);
			LivroDAO.atualizar(livro, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			LivroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Livro obter(Long id) {
		Livro livro = null;
		try {
			livro = LivroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return livro;
	}

	@Override
	public List<Livro> listar() {
		List<Livro> livros = null;
		try {
			livros = LivroDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return livros;
	}
	
}
