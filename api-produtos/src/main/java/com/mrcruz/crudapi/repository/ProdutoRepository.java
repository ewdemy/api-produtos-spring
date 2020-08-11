package com.mrcruz.crudapi.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrcruz.crudapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public Produto findById(long id);
}
