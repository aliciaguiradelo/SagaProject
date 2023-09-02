package br.com.br.saga.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(email, usuario.email) && Objects.equals(nome, usuario.nome) && Objects.equals(senha, usuario.senha) && Objects.equals(dataNascimento, usuario.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nome, senha, dataNascimento);
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
