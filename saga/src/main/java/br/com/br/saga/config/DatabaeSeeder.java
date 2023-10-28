package br.com.br.saga.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.br.saga.model.CategoriaFilme;
import br.com.br.saga.model.Filme;
import br.com.br.saga.repository.CategoriaFilmeRepository;
import br.com.br.saga.repository.FilmeRepository;

@Configuration
public class DatabaeSeeder implements CommandLineRunner {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    CategoriaFilmeRepository categoriaFilmeRepository;

    private CategoriaFilme suspense = new CategoriaFilme(null, "Suspense");
    private CategoriaFilme romance = new CategoriaFilme(null, "Romance");
    private CategoriaFilme documentario = new CategoriaFilme(null, "Documentário");
    private CategoriaFilme aventura = new CategoriaFilme(null, "Aventura");
    private CategoriaFilme comedia = new CategoriaFilme(null, "Comédia");

    @Override
    public void run(String... args) throws Exception {
        categoriaFilmeRepository.saveAll(
                List.of(suspense, romance, documentario, aventura, comedia));

        filmeRepository.saveAll(
            List.of(
                new Filme()
                    .withTitulo("Black Mirror")
                    .withSinopse("Não sei sobre o que é")
                    .withDiretor("Arthur Foschiani")
                    .withDuracao("1h13m")
                    .withDataEstreia(LocalDate.of(2023, 7, 12))
                    .withCaminhoBanner("BlackMirror")
                    .withFaixaEtaria(18)
                    .withCategoria(suspense),
                new Filme()
                    .withTitulo("Bill Gates")
                    .withSinopse("Biografia do homem que já teve o posto de mais rico do mundo")
                    .withDiretor("Arthur Foschiani")
                    .withDuracao("1h50m")
                    .withDataEstreia(LocalDate.of(2022, 6, 2))
                    .withCaminhoBanner("BillGates")
                    .withFaixaEtaria(12)
                    .withCategoria(documentario),
                new Filme()
                    .withTitulo("Harry Potter")
                    .withSinopse("Aventura do bruxinho mais amado do mundo")
                    .withDiretor("Esqueci o nome")
                    .withDuracao("1h50m")
                    .withDataEstreia(LocalDate.of(2009, 8, 9))
                    .withCaminhoBanner("harrypotter")
                    .withFaixaEtaria(12)
                    .withCategoria(aventura),
                new Filme()
                    .withTitulo("Crepusculo")
                    .withSinopse("Meu filme favorito")
                    .withDiretor("Stephenie Meyer")
                    .withDuracao("2h20m")
                    .withDataEstreia(LocalDate.of(2011, 12, 8))
                    .withCaminhoBanner("edwardcullen")
                    .withFaixaEtaria(12)
                    .withCategoria(romance),
                new Filme()
                    .withTitulo("Debi e Loide")
                    .withSinopse("Besteirol")
                    .withDiretor("Não lembro")
                    .withDuracao("2h00m")
                    .withDataEstreia(LocalDate.of(1998, 02, 18))
                    .withCaminhoBanner("fotoFilmeDebiLoide")
                    .withFaixaEtaria(10)
                    .withCategoria(comedia)
            )
        );
    }
}
