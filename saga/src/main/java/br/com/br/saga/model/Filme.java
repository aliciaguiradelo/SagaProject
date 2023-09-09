package br.com.br.saga.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String sinopse;
    private String diretor;
    private String duracao;
    private LocalDate dataEstreia;
    private String caminhoBanner;
    private int faixaEtaria;
    private Long idCategoria;

    public Filme() {
    }

    public Filme(Long id, String titulo, String sinopse, String diretor, String duracao, LocalDate dataEstreia, String caminhoBanner, int faixaEtaria, Long idCategoria) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.duracao = duracao;
        this.dataEstreia = dataEstreia;
        this.caminhoBanner = caminhoBanner;
        this.faixaEtaria = faixaEtaria;
        this.idCategoria = idCategoria;
    }

    public Long getId() {
        return id;
    }

    public Filme setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Filme setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Filme setSinopse(String sinopse) {
        this.sinopse = sinopse;
        return this;
    }

    public String getDiretor() {
        return diretor;
    }

    public Filme setDiretor(String diretor) {
        this.diretor = diretor;
        return this;
    }

    public String getDuracao() {
        return duracao;
    }

    public Filme setDuracao(String duracao) {
        this.duracao = duracao;
        return this;
    }

    public LocalDate getDataEstreia() {
        return dataEstreia;
    }

    public Filme setDataEstreia(LocalDate dataEstreia) {
        this.dataEstreia = dataEstreia;
        return this;
    }

    public String getCaminhoBanner() {
        return caminhoBanner;
    }

    public Filme setCaminhoBanner(String caminhoBanner) {
        this.caminhoBanner = caminhoBanner;
        return this;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public Filme setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
        return this;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Filme setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return faixaEtaria == filme.faixaEtaria && Objects.equals(id, filme.id) && Objects.equals(titulo, filme.titulo) && Objects.equals(sinopse, filme.sinopse) && Objects.equals(diretor, filme.diretor) && Objects.equals(duracao, filme.duracao) && Objects.equals(dataEstreia, filme.dataEstreia) && Objects.equals(caminhoBanner, filme.caminhoBanner) && Objects.equals(idCategoria, filme.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, sinopse, diretor, duracao, dataEstreia, caminhoBanner, faixaEtaria, idCategoria);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", diretor='" + diretor + '\'' +
                ", duracao='" + duracao + '\'' +
                ", dataEstreia=" + dataEstreia +
                ", caminhoBanner='" + caminhoBanner + '\'' +
                ", faixaEtaria=" + faixaEtaria +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
