package com.exemplo.abrigosanimais.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "abrigos")
public class Abrigo {
    @Id
    private String id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email; // Novo campo para email
    private String senha; // Novo campo para senha

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }  // Getter para email
    public void setEmail(String email) { this.email = email; }  // Setter para email
    public String getSenha() { return senha; }  // Getter para senha
    public void setSenha(String senha) { this.senha = senha; }  // Setter para senha
}
