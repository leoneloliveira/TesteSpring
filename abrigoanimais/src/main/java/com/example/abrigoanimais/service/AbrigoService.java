package com.exemplo.abrigosanimais.service;

import com.exemplo.abrigosanimais.model.Abrigo;
import com.exemplo.abrigosanimais.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public boolean validarLogin(String email, String senha) {
        try {
            // Buscar o abrigo pelo email
            Abrigo abrigo = abrigoRepository.findByEmail(email);

            // Se o abrigo existir e a senha for válida
            if (abrigo != null && abrigo.getSenha().equals(senha)) {
                return true; // Login bem-sucedido
            } else {
                return false; // Senha incorreta ou abrigo não encontrado
            }
        } catch (Exception e) {
            // Log de erro e retorno falso
            e.printStackTrace();
            return false;
        }
    }
}
