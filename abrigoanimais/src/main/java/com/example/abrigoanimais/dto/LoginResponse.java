package com.exemplo.abrigosanimais.dto;

public class LoginResponse {
    private String nomeAbrigo;

    // Construtor
    public LoginResponse(String nomeAbrigo) {
        this.nomeAbrigo = nomeAbrigo;
    }

    // Getter e Setter
    public String getNomeAbrigo() {
        return nomeAbrigo;
    }

    public void setNomeAbrigo(String nomeAbrigo) {
        this.nomeAbrigo = nomeAbrigo;
    }
}
