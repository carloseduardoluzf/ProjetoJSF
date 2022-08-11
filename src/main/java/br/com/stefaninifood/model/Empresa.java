package br.com.stefaninifood.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "nomeEmpresa")
	@NotNull
	@NotEmpty
	private String nomeEmpresa;

	@Column(name = "CNPJ")
	@NotNull
	@NotEmpty
	private String cnpj;

	@Column(name = "tipoEmpresa")
	@NotNull
	@NotEmpty
	private String tipoEmpresa;

	@Column(name = "email")
	@NotNull
	@NotEmpty
	private String email;

	@Column(name = "telefone")
	@NotNull
	@NotEmpty
	private String telefone;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "empresas_fornecedor", joinColumns = @JoinColumn(name = "empresa_fk"), inverseJoinColumns = @JoinColumn(name = "fornecedor_fk"))
	private List<Fornecedor> fornecedores = new ArrayList<>();

	public void adicionaFornecedor(Fornecedor fornecedor) {
		this.fornecedores.add(fornecedor);

	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public Empresa() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, email, id, nomeEmpresa, telefone, tipoEmpresa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Empresa)) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nomeEmpresa, other.nomeEmpresa) && Objects.equals(telefone, other.telefone)
				&& Objects.equals(tipoEmpresa, other.tipoEmpresa);
	}

}
