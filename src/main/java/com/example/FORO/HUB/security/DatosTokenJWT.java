package com.example.FORO.HUB.security;

import com.example.FORO.HUB.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public record DatosTokenJWT(String token) {
    @RestController
    @RequestMapping("/login")
    public class AutenticacionController {

        @Autowired
        private AuthenticationManager manager;

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity realizarLogin(@RequestBody DatosAutenticacion datos) {
            var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.generarToken((Usuario) authentication.getPrincipal());
            System.out.println(tokenJWT);
            return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
        }
    }
}
