package br.com.stefaninifood.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.stefaninifood.dao.DAO;
import br.com.stefaninifood.model.Empresa;
import br.com.stefaninifood.model.Fornecedor;

@ViewScoped
@ManagedBean
public class EmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Empresa empresa = new Empresa();
	private Integer fornecedorId;
	
	
	public void adicionar() {
		
		if(empresa.getFornecedores().isEmpty()) {
			throw new RuntimeException("A empresa deve ter pelo menos um fornecedor!");
		} if (this.empresa.getId() == null ) {
		new DAO<Empresa>(Empresa.class).adiciona(this.empresa);
		}else 
			new DAO<Empresa>(Empresa.class).atualiza(this.empresa);
	}

	
	
	
	public void atualizar(Empresa empresa) {
		this.empresa = empresa;
	}

	public void remover(Empresa empresa) {
	    new DAO<Empresa>(Empresa.class).remove(empresa);
	    
	}
	
	public List<Fornecedor> getFornecedores(){
		return new DAO<Fornecedor>(Fornecedor.class).listaTodos();
		
	}
	
	public List<Fornecedor> getFornecedoresDaEmpresa(){
		return this.empresa.getFornecedores();
	}
	
	public void gravarFornecedor() {
		
		
		if(this.fornecedorId == null) {
			throw new RuntimeException("Cadastre ou selecione um fornecedor!");
		}
		
		Fornecedor fornecedor = new DAO<Fornecedor>(Fornecedor.class).buscaPorId(this.fornecedorId);
		this.empresa.adicionaFornecedor(fornecedor);
		
	}
	
	public String formFornecedor() {
		return "fornecedor?faces-redirect=true";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		return new DAO<Empresa>(Empresa.class).listaTodos();
	}

	public Integer getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}


}
