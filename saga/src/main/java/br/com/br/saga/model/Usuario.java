package br.com.br.saga.model;

import br.com.br.saga.validation.IdadeMinima;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.List;
import java.util.Collection;

@Entity
@Data
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo email não pode estar em branco.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "O campo nome não pode estar em branco.")
    @Size(min = 2, max = 50, message = "O nome deve conter entre 2 e 50 caracteres.")
    private String nome;

    @NotBlank(message = "O campo senha não pode estar em branco.")
    @Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres.")
    private String senha;

    @Past(message = "A data de nascimento deve estar no passado.")
    @IdadeMinima(message = "O usuário deve ter no mínimo 12 anos de idade.")
    LocalDate dataNascimento;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}