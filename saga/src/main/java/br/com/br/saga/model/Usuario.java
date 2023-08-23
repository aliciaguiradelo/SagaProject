package br.com.br.saga.model;

import java.time.LocalDate;

public class Usuario {
    private Long id;
    private String email;
    private String nome;
    private String senha;
    LocalDate dataNascimento;

    public Usuario() {
    }

    public Usuario(Long id, String email, String nome, String senha, LocalDate dataNascimento) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Usuario setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
