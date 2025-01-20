package com.cfcm.ApiRestForo.Controller;

import com.cfcm.ApiRestForo.Domain.Topico.PostTopico;
import com.cfcm.ApiRestForo.Domain.Topico.TopicosDetalles;
import com.cfcm.ApiRestForo.Service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping()
    public ResponseEntity addTopico(@RequestBody @Valid PostTopico topico, UriComponentsBuilder uriBuilder) {
        return topicoService.postTopico(topico, uriBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTopico(@PathVariable Long id) {
        return topicoService.findTopicoById(id);
    }

    @GetMapping
    public ResponseEntity<Page<TopicosDetalles>> getAllTopicos(@PageableDefault(sort = "fecha") Pageable paginacion) {
        return topicoService.findAll(paginacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity modififyTopico(@PathVariable @Valid Long id, @RequestBody @Valid PostTopico topico) {

        return topicoService.modificarTopicoById(id, topico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopico(@PathVariable @Valid Long id) {
        return topicoService.borrarTopicoById(id);
    }
}
