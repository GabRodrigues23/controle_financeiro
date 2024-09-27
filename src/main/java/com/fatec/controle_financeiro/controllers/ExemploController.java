package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exemplo")
public class ExemploController{
    
    @GetMapping()
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello")
    public String HelloWorld1(){
        return "Hello";
    }

    @GetMapping("/reverter-nome/{nome}")
    String reverterNome(@PathVariable String nome){
        return new StringBuilder(nome).reverse().toString();
    }

    @GetMapping("/par-ou-impar/{numero}")
    String verificarParOuImpar(@PathVariable Integer numero){
        if(numero % 2 == 0){
            return "Par";
        } else{
            return "impar";
        }
    }    
}

/* 
@RestController : identifica para o framework que a classe vai receber uma requisição http
@RequestMapping : requer que seja informado a url para que a api seja chamada
@GetMapping : mapeia a url (localhost:8090/mapeamento) -- uma api não pode ter dois getMapping para um mesmo caminho
@PathVariable : Anotação para definir uma váriavel que será recebida pelo parâmetro
    ex: no exemplo, a url indica uma variavel nome e o PathVariable define que será o parâmetro
*/




//@PathVariable = anotacao para definir que a variavel nome que é do tipo String será recebida pelo
//parametro {nome}

//@RequestBody = anotacao defini que irei passar parametro no corpo da requisicao
//Só consigo passar no corpo da requisição se utilizar verbo POST (@PostMapping)