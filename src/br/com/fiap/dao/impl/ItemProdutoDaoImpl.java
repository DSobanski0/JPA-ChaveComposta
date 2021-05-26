package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemProdutoDao;
import br.com.fiap.entity.ItemProduto;
import br.com.fiap.entity.ItemProdutoPK;

public class ItemProdutoDaoImpl extends GenericDaoImpl<ItemProduto, ItemProdutoPK> implements ItemProdutoDao {

	public ItemProdutoDaoImpl(EntityManager em) {
		super(em);
	}

}
