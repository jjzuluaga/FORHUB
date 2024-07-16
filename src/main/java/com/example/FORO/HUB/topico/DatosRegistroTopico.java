package com.example.FORO.HUB.topico;

public record DatosRegistroTopico(
                                  String titulo,
                                  String mensaje,
                                  String fechaCreacion,
                                  Boolean status,
                                  String autor,
                                  Curso curso) {

}
