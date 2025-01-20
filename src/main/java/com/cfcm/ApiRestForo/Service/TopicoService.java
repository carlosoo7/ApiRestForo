package com.cfcm.ApiRestForo.Service;

import com.cfcm.ApiRestForo.Domain.Topico.PostTopico;
import com.cfcm.ApiRestForo.Domain.Topico.TopicoRepository;
import com.cfcm.ApiRestForo.Domain.Topico.Topicos;
import com.cfcm.ApiRestForo.Domain.Topico.TopicosDetalles;
import com.cfcm.ApiRestForo.Domain.Topico.Validaciones.ValidarDuplicados;
import com.cfcm.ApiRestForo.Domain.ValidacionExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private ValidarDuplicados validarDuplicados;

    public ResponseEntity postTopico(PostTopico topico, UriComponentsBuilder uriComponentsBuilder) {
        validarDuplicados.validar(topico);
        Topicos nuevoTopico = topicoRepository.save(new Topicos(topico));
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(nuevoTopico.getId()).toUri();
        return ResponseEntity.created(url).body(topico);
    }

    public ResponseEntity findTopicoById(Long id) {
        Optional<TopicosDetalles> topicoEncontrado = topicoRepository.findById(id).map(TopicosDetalles::new);

        if (topicoEncontrado.isPresent()) {
            return ResponseEntity.ok(topicoEncontrado.get());
        } else {
            throw new ValidacionExcepcion("El id seleccionado no existe o es invalido");
        }
    }

    public ResponseEntity<Page<TopicosDetalles>> findAll(Pageable paginacion) {

        Page<TopicosDetalles> topicos = topicoRepository.findAll(paginacion).map(TopicosDetalles::new);
        return ResponseEntity.ok(topicos);
    }

    public ResponseEntity modificarTopicoById(Long id, PostTopico topico) {
        Optional<Topicos> topicoEncontrado = topicoRepository.findById(id);
        if (topicoEncontrado.isPresent()) {
            var topicoModificado = new Topicos(id, topico.titulo(), topico.mensaje()
                    , LocalDateTime.now(), true, topico.autor(), topico.curso());
            TopicosDetalles topicosDetalles = new TopicosDetalles(topicoModificado);
            validarDuplicados.validarExcluyente(topico, id);
            topicoRepository.save(topicoModificado);
            return ResponseEntity.ok(topicosDetalles);
        } else {
            throw new ValidacionExcepcion("El id seleccionado no existe o es invalido");
        }
    }

    public ResponseEntity borrarTopicoById(Long id) {
        Optional<Topicos> topicoEncontrado = topicoRepository.findById(id);
        if (topicoEncontrado.isPresent()) {
            topicoRepository.deleteById(id);
        } else {
            throw new ValidacionExcepcion("El id no existe, es invalido o ya fue eliminado");
        }
        return ResponseEntity.noContent().build();
    }
}

