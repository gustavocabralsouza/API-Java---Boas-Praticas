package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetDTO(@NotNull Abrigo abrigo, @NotNull Boolean adotado, @NotNull Pet pet) {
    public void abrigo(Abrigo abrigo) {
    }

    public void adotado(boolean b) {
    }
}
