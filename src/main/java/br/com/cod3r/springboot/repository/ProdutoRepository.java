package br.com.cod3r.springboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.cod3r.springboot.model.entity.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

	public Iterable<Produto> findByNomeContaining(String parteNome);
}

