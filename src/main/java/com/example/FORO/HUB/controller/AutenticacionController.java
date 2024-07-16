package com.example.FORO.HUB.controller;


import com.example.FORO.HUB.security.DatosAutenticacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody DatosAutenticacion datos) {
        var token = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var authenticaon = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
