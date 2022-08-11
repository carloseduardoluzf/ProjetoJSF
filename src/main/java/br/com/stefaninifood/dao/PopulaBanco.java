package br.com.stefaninifood.dao;

import javax.persistence.EntityManager;

import br.com.stefaninifood.model.Empresa;
import br.com.stefaninifood.model.Fornecedor;



public class PopulaBanco {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();


		Fornecedor Loggi = geraFornecedor("Loggi Software");
		em.persist(Loggi);
		Fornecedor Stefanini = geraFornecedor("Stefanini Group");
		em.persist(Stefanini);
		Fornecedor Spezi = geraFornecedor("Spezi");
		em.persist(Spezi);
		
		
		
		
		
		Empresa rootsBurguer = geraEmpresa("Roots Burguer", "41.222.333/1000-90",
				"EI", "dudupaque@gmail.com", "(61) 956569934");
		Empresa salzBurguer = geraEmpresa("Salz Burguer", "20.220.112/2201-90",
				"MEI", "thiagous@gmail.com", "(61) 972560000");
		Empresa lezBurguer = geraEmpresa("Lez Burguer", "41.560.512/0001-90",
				"EIRELI", "capitao@gmail.com", "(61) 922569934");

		em.persist(rootsBurguer);
		em.persist(salzBurguer);
		em.persist(lezBurguer);

		em.getTransaction().commit();
		em.close();

	}

	

	private static Empresa geraEmpresa(String nomeEmpresa, String cnpj, String tipoEmpresa,
			String email, String telefone) {
		Empresa empresa = new Empresa();
		empresa.setNomeEmpresa(nomeEmpresa);
		empresa.setCnpj(cnpj);
		empresa.setTipoEmpresa(tipoEmpresa);
		empresa.setTelefone(telefone);
		empresa.setEmail(email);
		return empresa;
	}
	
	private static Fornecedor geraFornecedor(String nomeFornecedor) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNomeFornecedor(nomeFornecedor);
		return fornecedor;
		
	}
}