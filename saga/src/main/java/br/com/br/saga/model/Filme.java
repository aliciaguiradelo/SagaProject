package br.com.br.saga.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    private String titulo;
    @NotBlank
    @Size(min = 10, message = "A sinópse deve conter no mínimo 10 caracteres.")
    private String sinopse;
    private String diretor;
    private String duracao;
    @Past
    private LocalDate dataEstreia;
    private String caminhoBanner;
    @Min(value = 0, message = "O valor deve ser positivo.")
    private int faixaEtaria;
    private Long idCategoria;
}
