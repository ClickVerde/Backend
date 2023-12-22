package com.generation.clickverde.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do produto é obrigatório.")
	@Size(min = 5, max = 100, message = "O nome deve ter entre 5 e 100 caracteres.")
	@Column(length = 100)
	private String nome;
	
	@NotNull(message = "O preço do produto é obrigatório.")
	@Column(precision = 8, scale = 2) //= DECIMAL(8,2)
	private BigDecimal preco;

	@PositiveOrZero(message = "O valor quantidade precisa ser positivo")
	private Long quantidade = 0L;
	
	@NotBlank(message = "A descrição do produto é obrigatória.")
	@Size(max = 10000, message = "A descrição pode ter no máximo 10000 caracteres.")
	@Column(length = 10000)
	private String descricao;

	@NotNull(message = "A foto do produto é obrigatória.")
	@Size(max = 300, message = "A URL da foto deve ter no máximo 300 caracteres")
	@Column(length = 300)
	private String foto;
	
	@PositiveOrZero(message = "O valor vendas precisa ser positivo")
	private Long vendas = 0L;

	@PositiveOrZero(message = "O valor likes precisa ser positivo")
	private Long likes = 0L;

	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getVendas() {
		return vendas;
	}

	public void setVendas(Long vendas) {
		this.vendas = vendas;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
