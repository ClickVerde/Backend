package com.generation.clickverde.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório")
	@Size(min = 5, max = 60, message = "O atributo título deve conter no mínimo 05 e no máximo 60 caracteres")
	@Column(length = 60)
	private String nome;
	
	@NotBlank(message = "O atributo email é obrigatório")
	@Size(max = 255, message = "O atributo email deve conter no máximo 255 caracteres")
	@Column(length = 255)
	private String email;
	
	@NotBlank(message = "O atributo senha é obrigatório")
	@Size(max = 60, message = "O atributo senha deve conter no máximo 60 caracteres")
	@Column(length = 60)
	private String senha;
	
	@NotBlank(message = "O atributo cpf_cnpj é obrigatório")
	@Size(max = 40, message = "O atributo cpf-cnpj deve conter no máximo 40 caracteres")
	@Column(length = 40)
	private String cpf_cnpj;
	
	@NotBlank(message = "O atributo tipo é obrigatório")
	@Size(max = 15, message = "O atributo tipo deve conter no máximo 15 caracteres")
	@Column(length = 15)
	@Pattern(regexp = "^(Cliente|Loja)$", message = "O tipo deve ser 'Cliente' ou 'Loja'")
	private String tipo;
	
	
	private String foto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produtos;

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
		return email;
	}

	public void setDescricao(String descricao) {
		this.email = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}