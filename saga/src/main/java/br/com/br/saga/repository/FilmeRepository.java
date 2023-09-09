package br.com.br.saga.repository;

import br.com.br.saga.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    //A interface Jpa recebe o tipo q vai retornar e a chave primária desse tipo
    //public List<Filme> findAll();
    //public insert(Filme);
    //public findById(Long id);
    //public update(Filme, Long id);
    //public delete(Long id);
}
