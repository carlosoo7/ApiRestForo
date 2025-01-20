package com.cfcm.ApiRestForo.Domain.Topico.Validaciones;

import com.cfcm.ApiRestForo.Domain.Topico.PostTopico;
import com.cfcm.ApiRestForo.Domain.Topico.TopicoRepository;
import com.cfcm.ApiRestForo.Domain.ValidacionExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidarDuplicados {

    @Autowired
    private TopicoRepository repository;

    public void validar(PostTopico post) {
        boolean duplicados = repository.existsByTituloOrMensaje(post.titulo(), post.mensaje());
        if (duplicados) {
            throw new ValidacionExcepcion("No se permiten topicos con mismos titulos o mensaje ya existentes");
        }

    }

    public void validarExcluyente(PostTopico post, Long idTopico) {
        boolean duplicados = repository.existsByTituloAndIdIsNot(post.titulo(), idTopico);
        if (duplicados) {
            throw new ValidacionExcepcion("No se permiten topicos con mismos titulos o mensaje ya existentes");
        }
        boolean duplicados2 = repository.existsByMensajeAndIdIsNot(post.mensaje(), idTopico);
        if (duplicados2) {
            throw new ValidacionExcepcion("No se permiten topicos con mismos titulos o mensaje ya existentes");
        }
    }
}

