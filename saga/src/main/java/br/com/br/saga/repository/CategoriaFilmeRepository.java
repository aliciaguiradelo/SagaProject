package br.com.br.saga.repository;

import br.com.br.saga.model.CategoriaFilme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaFilmeRepository extends JpaRepository<CategoriaFilme, Long> {
}
