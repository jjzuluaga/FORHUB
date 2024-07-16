package com.example.FORO.HUB.controller;

import com.example.FORO.HUB.topico.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void registrar (@RequestBody DatosRegistroTopico datosRegistroTopico){
        repository.save(new Topico(datosRegistroTopico));
    }
    @GetMapping
    public Page<DatosListaTopico> listar(@PageableDefault(page = 0, size = 10 )Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListaTopico::new);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id){
        Topico topico = repository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),
                topico.getMensaje(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Optional<Topico> topicoExistente = repository.findById(id);
        if (topicoExistente.isPresent()){
            var topico = repository.getReferenceById(topicoExistente.get().getId());
            topico.desactivarTopico();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico (@PathVariable Long id, @RequestBody  DatosActualizacionTopico datos){
        Optional<Topico> topicoExistente = repository.findById(id);
        if (topicoExistente.isPresent()){
            var topico = repository.getReferenceById(topicoExistente.get().getId());
            topico.actualizarInformacion(datos);
            return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),
                    topico.getMensaje(),topico.getAutor(),topico.getCurso()));
        }
        return ResponseEntity.notFound().build();
    }


}
