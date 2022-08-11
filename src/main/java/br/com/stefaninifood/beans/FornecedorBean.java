package br.com.stefaninifood.beans;

import javax.faces.bean.ManagedBean;

import br.com.stefaninifood.dao.DAO;
import br.com.stefaninifood.model.Fornecedor;

@ManagedBean
public class FornecedorBean {
	
	private Fornecedor fornecedor = new Fornecedor();
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void cadastrarFornecedor() {
		new DAO<Fornecedor>(Fornecedor.class).adiciona(this.fornecedor);
		this.fornecedor = new Fornecedor();
		
	
		
	}


}
