package com.fatec.controle_financeiro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import javax.validation.constraints.Email;

@Entity
@Table(name = "cliente")
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 60)
    private String nome;
    

    // Getters e Setters
        // id
    public int getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }

        // name
    public String getNome(){
        return nome;
    }
    public void setNome(){
        this.nome = nome;
    }
}