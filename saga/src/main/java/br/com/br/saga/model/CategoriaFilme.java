package br.com.br.saga.model;

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
    public String toString() {
        return "CategoriaFilme{" +
                "id=" + id +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                '}';
    }
}
