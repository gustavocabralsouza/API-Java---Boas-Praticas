package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TutorDTO(@NotBlank String nome, @NotBlank String telefone, @NotBlank String email, @NotNull Long id) {
}
