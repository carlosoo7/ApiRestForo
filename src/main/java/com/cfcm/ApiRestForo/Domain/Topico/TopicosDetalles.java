package com.cfcm.ApiRestForo.Domain.Topico;

import java.time.LocalDateTime;

public record TopicosDetalles(String titulo,
                              String mensaje,
                              LocalDateTime fecha,
                              boolean estado,
                              String autor,
                              String curso) {
    //título, mensaje, fecha de creación, estado, autor y curso
    public TopicosDetalles(Topicos topicos) {
        this(topicos.getTitulo(), topicos.getMensaje(), topicos.getFecha(), topicos.isStatus(), topicos.getAutor(), topicos.getCurso());
    }
}
