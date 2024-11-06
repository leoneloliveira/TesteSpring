package com.exemplo.abrigosanimais.controller;


import com.exemplo.abrigosanimais.dto.LoginRequest;
import com.exemplo.abrigosanimais.model.Abrigo;
import com.exemplo.abrigosanimais.repository.AbrigoRepository;
import com.exemplo.abrigosanimais.service.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

  

    @Autowired
    private AbrigoService abrigoService;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @GetMapping
    public List<Abrigo> getAll() {
        return abrigoRepository.findAll();
    }

    @PostMapping
    public Abrigo create(@RequestBody Abrigo abrigo) {
        return abrigoRepository.save(abrigo);
    }

    @GetMapping("/{id}")
    public Abrigo getById(@PathVariable String id) {
        return abrigoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Abrigo update(@PathVariable String id, @RequestBody Abrigo abrigo) {
        abrigo.setId(id);
        return abrigoRepository.save(abrigo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        abrigoRepository.deleteById(id);
    }

  @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
    try {
        boolean isValid = abrigoService.validarLogin(loginRequest.getEmail(), loginRequest.getSenha());

        if (isValid) {
            return ResponseEntity.status(HttpStatus.OK).body("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha incorretos");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor");
    }
}


    
}
