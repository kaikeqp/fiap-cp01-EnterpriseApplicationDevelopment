package br.com.fiap.checkpoint01_KaikeRaissa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_livro")
@SequenceGenerator(name = "livro", sequenceName = "sq_tb_livro", allocationSize = 1)
public class Livro implements Serializable {

	private static final long serialVersionUID = 1645563614030215102L;

	public Livro() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}

	public Livro(String titulo, String autor, String isbn, LocalDate dataPublicacao) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
	}

	@Id
	@GeneratedValue(generator = "livro", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nm_livro", length = 80, nullable = false)
	private String titulo;

	@Column(name = "nm_autor", length = 60, nullable = true)
	private String autor;

	@Column(name = "nm_isbn", length = 21, nullable = false, unique = true)
	private String isbn;

	@Column(name = "dt_publicacao")
	private LocalDate dataPublicacao;

	@Column(name = "st_ativo", nullable = false)
	private Boolean ativo;

	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;

	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Livro \ngetTitulo(): " + this.getTitulo() + "\ngetAutor(): " + this.getAutor() + "\ngetIsbn(): "
				+ this.getIsbn() + "\ngetDataPublicacao(): " + this.getDataPublicacao();
	}

}
