package com.exemplo.abrigosanimais.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adocoes")
public class Adocao {
    @Id
    private String id;
    private String nomeAdotante; // Nome do Adotante
    private String telefoneAdotante; // Telefone do Adotante
    private String emailAdotante; // Email do Adotante
    private String observacoes; // Observações adicionais

    // Getters e Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomeAdotante() {
        return nomeAdotante;
    }
    public void setNomeAdotante(String nomeAdotante) {
        this.nomeAdotante = nomeAdotante;
    }
    public String getTelefoneAdotante() {
        return telefoneAdotante;
    }
    public void setTelefoneAdotante(String telefoneAdotante) {
        this.telefoneAdotante = telefoneAdotante;
    }
    public String getEmailAdotante() {
        return emailAdotante;
    }
    public void setEmailAdotante(String emailAdotante) {
        this.emailAdotante = emailAdotante;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
