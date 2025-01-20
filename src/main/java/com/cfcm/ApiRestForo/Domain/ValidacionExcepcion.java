package com.cfcm.ApiRestForo.Domain;

public class ValidacionExcepcion extends RuntimeException {
    public ValidacionExcepcion(String elTopicoEstaDublicado) {
        super(elTopicoEstaDublicado);
    }
}
