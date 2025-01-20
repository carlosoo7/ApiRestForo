package com.cfcm.ApiRestForo.Domain.Topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostTopico(
        @NotBlank @NotNull @Valid String titulo,
        @NotBlank @NotNull @Valid String mensaje,
        @NotBlank String autor,
        @NotBlank String curso) {
    public PostTopico(Topicos topicos) {
        this(topicos.getTitulo(), topicos.getMensaje(), topicos.getAutor(), topicos.getCurso());
    }
}


