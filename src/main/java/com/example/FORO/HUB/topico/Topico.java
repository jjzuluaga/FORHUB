package com.example.FORO.HUB.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    @Entity(name = "Topico")
    @Table(name = "Topicos")
    public class Topico {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;
        private String mensaje;
        private String fechaCreacion;
        private Boolean status;
        private String autor;
        @Enumerated(EnumType.STRING)
        private Curso curso;

        public Topico(DatosRegistroTopico datosRegistroTopico){
            this.titulo = datosRegistroTopico.titulo();
            this.mensaje = datosRegistroTopico.mensaje();
            this.fechaCreacion = datosRegistroTopico.fechaCreacion();
            this.status = datosRegistroTopico.status();
            this.autor = datosRegistroTopico.autor();
            this.curso = datosRegistroTopico.curso();

        }

        public void desactivarTopico() {
            this.status = false;
        }

        public void actualizarInformacion(DatosActualizacionTopico datos){
                if(titulo != null){
                    this.titulo = datos.titulo();
                }
                if(mensaje != null){
                    this.mensaje = datos.mensaje();
                }
        }

    }
