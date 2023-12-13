package com.generation.clickverde.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	@Size(min = 5, max = 60, message = "O atributo título deve conter no mínimo 05 e no máximo 60 caracteres")
	private String nome;
	
	@Size(max = 150, message = "O atributo título deve conter no máximo 150 caracteres")
	private String descricao;
	
	@NotBlank(message = "O atributo foto é obrigatório")
	private String foto;
	
//	Lista de produtos atrelados a categoria (a tabela produtos ainda vai ser criada)
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
//	@JsonIgnoreProperties("categoria")
//	private List<Produtos> produtos;

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
	
	

	
	
	
	
	
}
