package com.example.FORO.HUB.topico;

public enum Curso {
    JAVA("Java"),
    PYTHON("Python"),
    SPRING("Spring Boot"),
    HTML("html");

    private final String nombre;

    Curso(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
