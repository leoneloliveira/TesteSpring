package com.exemplo.abrigosanimais.service;

import com.exemplo.abrigosanimais.model.Abrigo;
import com.exemplo.abrigosanimais.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    /**
     * Método para validar o login do abrigo.
     * @param email Email do abrigo.
     * @param senha Senha do abrigo.
     * @return true se o login for válido, false caso contrário.
     */
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

    /**
     * Método para buscar o nome do abrigo pelo email.
     * @param email Email do abrigo.
     * @return O nome do abrigo ou null se não encontrado.
     */
    public String buscarNomeAbrigoPorEmail(String email) {
        try {
            // Buscar o abrigo pelo email
            Abrigo abrigo = abrigoRepository.findByEmail(email);

            // Retornar o nome do abrigo se encontrado
            return abrigo != null ? abrigo.getNome() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null se ocorrer algum erro
        }
    }
}
