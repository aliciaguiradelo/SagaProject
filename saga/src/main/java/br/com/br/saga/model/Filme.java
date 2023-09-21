package br.com.br.saga.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar em branco.")
    @Size(min = 2, max = 100, message = "O título deve conter entre 2 e 100 caracteres.")
    private String titulo;

    @NotBlank(message = "A sinopse não pode estar em branco.")
    @Size(min = 10, message = "A sinopse deve conter no mínimo 10 caracteres.")
    private String sinopse;

    @NotBlank(message = "O diretor não pode estar em branco.")
    @Size(min = 2, max = 50, message = "O diretor deve conter entre 2 e 50 caracteres.")
    private String diretor;

    @NotBlank(message = "A duração não pode estar em branco.")
    private String duracao;
    
    @Past(message = "A data de estreia deve estar no passado.")
    @NotNull
    private LocalDate dataEstreia;
    
    @NotBlank(message = "A caminho do banner não pode estar em branco.")
    private String caminhoBanner;

    @Min(value = 0, message = "O valor deve ser positivo.")
    @Max(value = 18, message = "A faixa etária máxima permitida é 18 anos.")
    private int faixaEtaria;

    @NotNull(message = "O ID da categoria não pode ser nulo.")
    private Long idCategoria;
}
