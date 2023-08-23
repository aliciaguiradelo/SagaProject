package br.com.br.saga.model;

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
    public String toString() {
        return "Favorito{" +
                "idFilme=" + idFilme +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
