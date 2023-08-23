package br.com.br.saga.model;

import java.util.Objects;

public class CategoriaFilme {
    private Long id;
    private String nomeCategoria;

    public CategoriaFilme() {
    }

    public CategoriaFilme(Long id, String nomeCategoria) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
    }

    public Long getId() {
        return id;
    }

    public CategoriaFilme setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public CategoriaFilme setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaFilme that = (CategoriaFilme) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeCategoria, that.nomeCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCategoria);
    }

    @Override
    public String toString() {
        return "CategoriaFilme{" +
                "id=" + id +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                '}';
    }
}
