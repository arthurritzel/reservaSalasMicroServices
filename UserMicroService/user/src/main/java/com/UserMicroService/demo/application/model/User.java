package com.UserMicroService.demo.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String rua;
    private String numero;
    private String cidade;
    private String cep;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;


    public void setNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("O nome deve ter pelo menos 3 caracteres.");
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (!isValidCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf;
    }

    private boolean isValidCpf(String cpf) {
        String regex = "\\d{11}";
        return Pattern.matches(regex, cpf);
    }
}
