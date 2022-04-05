package br.com.fiap.checkpoint01_KaikeRaissa;

import java.time.LocalDate;

import br.com.fiap.checkpoint01_KaikeRaissa.entity.Livro;
import br.com.fiap.checkpoint01_KaikeRaissa.service.Impl.LivroServiceImpl;

public class App {
	public static void main(String[] args) {
		LivroServiceImpl livroService = LivroServiceImpl.getInstance();

		System.out.println("================INSERIR====================");

		Livro l1 = new Livro("A hora da estrela","Clarice Lispector","978-0-7334-2609-4",LocalDate.of(1977, 01, 20));
		Livro l2 = new Livro("Sei lá: pra lá","Rassilan","123-0-6753-5317-3",LocalDate.of(2020, 3, 19));
		Livro l3 = new Livro("Portal do Aluno, o manual definitivo", "Kaike", "741-0-7898-1111-7",LocalDate.of(2007, 12, 23));

		livroService.cadastrar(l1);
		livroService.cadastrar(l2);
		livroService.cadastrar(l3);

		System.out.println("===============LISTAR=====================");

		livroService.listar().forEach(System.out::println);

		System.out.println("===============REMOVER 1º LIVRO=================");

		livroService.remover(1l);

		System.out.println("===============ATUALIZAR=====================");

		l3.setDataPublicacao(LocalDate.of(2022, 3, 10));
		livroService.atualizarDataPublicacao(3l, LocalDate.of(2022, 3, 10));
	}
}
