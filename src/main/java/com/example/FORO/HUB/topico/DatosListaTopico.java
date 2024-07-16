package com.example.FORO.HUB.topico;

public record DatosListaTopico(String titulo, String mensaje, String fechaCreacion, Boolean status,
                               String autor, Curso curso) {

    public DatosListaTopico(Topico topico){
        this(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),
                topico.getStatus(),topico.getAutor(),topico.getCurso());
    }
}
