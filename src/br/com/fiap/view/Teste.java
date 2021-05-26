package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoCompraDao;
import br.com.fiap.dao.ItemProdutoDao;
import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.dao.impl.CarrinhoCompraDaoImpl;
import br.com.fiap.dao.impl.ItemProdutoDaoImpl;
import br.com.fiap.dao.impl.ProdutoDaoImpl;
import br.com.fiap.entity.CarrinhoCompra;
import br.com.fiap.entity.ItemProduto;
import br.com.fiap.entity.ItemProdutoPK;
import br.com.fiap.entity.Produto;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar um produto, carrinho de compra e item
		
		//Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um ProdutoDao e CarrinhoCompraDao
		ProdutoDao produtoDao = new ProdutoDaoImpl(em);
		CarrinhoCompraDao carrinhoCompraDao = new CarrinhoCompraDaoImpl(em);
		
		//Instanciar um produto
		Produto produto = new Produto("Lápis");
		
		//Instanciar um ItemProduto (tirar o carrinho de compras do construtor)
		ItemProduto itemProduto = new ItemProduto(produto, null, 2.22, 1);
		
		//Instanciar um Carrinho de compras
		CarrinhoCompra carrinhoCompra = new CarrinhoCompra(new GregorianCalendar(2020, Calendar.APRIL, 22));
		
		//Adicionar o item no carrinho de compra
		carrinhoCompra.addItem(itemProduto);
		
		try {
			//Cadastrar um produto
			produtoDao.create(produto);
			//Cadastrar o carrinho de compras (O item produto vai em cascata)
			carrinhoCompraDao.create(carrinhoCompra);
			produtoDao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e){
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar um item pela PK
			ItemProdutoDao itemProdutoDao = new ItemProdutoDaoImpl(em);
			ItemProdutoPK pk = new ItemProdutoPK(1, 1, 1);
			ItemProduto item = itemProdutoDao.read(pk);
			System.out.println(item.getProduto().getNome() + " " + item.getValor());
		} catch ( EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}	
}