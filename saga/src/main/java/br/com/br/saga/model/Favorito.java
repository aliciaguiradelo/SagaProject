package br.com.br.saga.model;

import java.util.Objects;

public class Favorito {
    private Long idFilme;
    private Long idUsuario;

    public Favorito( Long idFilme, Long idUsuario){
        this.idFilme=idFilme;
        this.idUsuario=idUsuario;
    }

    public Favorito(){

    }

    public Long getIdFilme() {
        return idFilme;
    }

    public Favorito setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
        return this;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Favorito setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorito favorito = (Favorito) o;
        return Objects.equals(idFilme, favorito.idFilme) && Objects.equals(idUsuario, favorito.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilme, idUsuario);
    }

    @Override
    public String toString() {
        return "Favorito{" +
                "idFilme=" + idFilme +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
