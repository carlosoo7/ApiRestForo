package com.cfcm.ApiRestForo.Domain.Topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean status;
    private String autor;
    private String curso;

    public Topicos(PostTopico topico) {
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.autor = topico.autor();
        this.curso = topico.curso();
        this.fecha = LocalDateTime.now();
        this.status = true;
    }

}
