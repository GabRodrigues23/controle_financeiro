package com.fatec.controle_financeiro.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.entities.User;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    //http://localhost:<port>/api/usuario/register
    //POST
    //Parametro: @RequestBody => enviar no corpo da requisicao (body)

    //@PostMapping => POST - CRIACAO / CONSULTAS COM PARAMETROS NO CORPO DA REQUISICAO
    //@GetMapping => GET - CONSULTAS
    //@PutMapping -> PUT - ALTERACAO
    //@DeleteMapping -> DELETE - DELETAR
    //@PatchMapping -> PATCH - ANEXAR/ALTERAR


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User usuario) {
        if (usuario.getName() == null || usuario.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario inválido") ;
        }

        if (usuario.getAge() <= 0) {
            return ResponseEntity.badRequest().body("idade inválida") ;
        }

        return ResponseEntity.ok("Bem-vindo, " + usuario.getName() + "! Você tem " + usuario.getAge() + " anos.");
    }

    @PostMapping("/register2")
    public ResponseEntity<String> registerUserComIsValid(@Valid @RequestBody User usuario) {

        return ResponseEntity.ok("Bem-vindo, " + usuario.getName() + "! Você tem " + usuario.getAge() + " anos.");
    }
    
    @PostMapping("/register/{name}/{age}")
    public String registerUser2(@PathVariable String name, @PathVariable int age) {

        User usuario = new User();
        usuario.setName(name);
        usuario.setAge(age);

        return "Bem-vindo, " + usuario.getName() + "! Você tem " + usuario.getAge() + " anos.";
    }
}
