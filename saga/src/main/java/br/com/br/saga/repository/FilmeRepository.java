package br.com.br.saga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.br.saga.model.Filme;


public interface FilmeRepository extends JpaRepository<Filme, Long>{

}