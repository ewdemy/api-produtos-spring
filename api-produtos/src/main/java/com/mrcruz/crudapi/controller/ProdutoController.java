package com.mrcruz.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mrcruz.crudapi.model.Produto;
import com.mrcruz.crudapi.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/produtos")
@Api(value="API Rest de Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository repository;
	
	@ApiOperation(value="Retorna lista de produtos")
	@GetMapping
	public List<Produto> getProdutos(){
		return this.repository.findAll();
	}
	
	@ApiOperation(value="Retorna um produto pelo ID")
	@GetMapping("/{id}")
	public Produto getProdutoById(@PathVariable(value="id")long id) {
		return this.repository.findById(id);
	}
	
	@ApiOperation(value="Cria um produto e retorna o mesmo")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto createProduto(@RequestBody Produto produto) {
		return this.repository.save(produto);
	}
	
	@ApiOperation(value="Atualiza um produto pelo ID e retorna o mesmo")
	@PutMapping("/{id}")
	public Produto updateProduto(@RequestBody Produto produto) {
		return this.repository.save(produto);
	}
	
	@ApiOperation(value="Deleta um produto pelo ID")
	@DeleteMapping("/{id}")
	public void deleteProduto(@RequestBody Produto produto) {
		this.repository.delete(produto);
	}

}
