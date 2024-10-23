package com.exemplo.abrigosanimais.controller;

import com.exemplo.abrigosanimais.model.Abrigo;
import com.exemplo.abrigosanimais.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    // Endpoint para login
    @PostMapping
    public ResponseEntity<String> login(@RequestBody AbrigoLoginRequest loginRequest) {
        // Buscar o abrigo no banco de dados pelo email
        Optional<Abrigo> optionalAbrigo = abrigoRepository.findByEmail(loginRequest.getEmail());

        if (optionalAbrigo.isPresent()) {
            Abrigo abrigo = optionalAbrigo.get();

            // Verifica se a senha está correta
            if (abrigo.getSenha().equals(loginRequest.getSenha())) {
                return ResponseEntity.ok("Login realizado com sucesso!");
            } else {
                return ResponseEntity.status(401).body("Senha incorreta.");
            }
        } else {
            return ResponseEntity.status(404).body("Abrigo não encontrado.");
        }
    }
}
