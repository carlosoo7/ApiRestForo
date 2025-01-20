package com.cfcm.ApiRestForo.Domain.Topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topicos, Long> {
    boolean existsByTituloOrMensaje(String titulo, String mensaje);

    boolean existsByTituloAndIdIsNot(String titulo, Long idTopico);

    boolean existsByMensajeAndIdIsNot(String mensaje, Long idTopico);
}
