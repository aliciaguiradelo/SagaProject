package br.com.br.saga.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.br.saga.model.Filme;


public interface FilmeRepository extends JpaRepository<Filme, Long>{

    //@Query("SELECT f FROM Filme f ORDER BY f.id LIMIT ?2 OFFSET ?1")
    //List<Filme> findAll(int offset, int size);

    //@Query("SELECT f FROM Filme f WHERE f.descricao LIKE ?1")
    //Page<Filme> findByDescricaoLike(String descricao, Pageable pageRequest);
    Page<Filme> findByTituloContainingIgnoreCase(String titulo, Pageable pageRequest);

}