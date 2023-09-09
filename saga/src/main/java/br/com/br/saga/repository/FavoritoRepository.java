package br.com.br.saga.repository;

import br.com.br.saga.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
}
