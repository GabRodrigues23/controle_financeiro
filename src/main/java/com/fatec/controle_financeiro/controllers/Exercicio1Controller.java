package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Exercicio1Controller")
public class Exercicio1Controller{

    //1 - @GetMapping("/contar-letras/{texto}")
    @GetMapping("/contar-letras/{texto}")
    String contarLetras(@PathVariable String texto){
        int contador = texto.length();
        return "O texto tem " + contador + " letras";
    }
        

    //2 - @GetMapping("/idade-com-parametro-tipo-integer/{paramIdade}")
    //Idade < 12 => retorna "CRIANCA"
    //Idade <= 18 => retorna "ADOLESCENTE"
    //Idade <= 60 => retorna "ADULTO"
    //Acima 60 => retorna "IDOSO"
    //Idade invalida => retorna "idade invalida"
    @GetMapping("/idade-com-parametro-tipo-integer/{paramIdade}")
    String getIdadeComParametroTipoIntegeString(@PathVariable Integer paramIdade){
        try {
            int idade = paramIdade;
            
            if(idade < 0){
                throw new NumberFormatException();
            }

            if(idade < 12){
                return "Criança";
            } else if(idade <= 18){
                return "Adolescente";
            } else if(idade <= 60){
                return "Adulto";
            } else {
                return "Idoso";
            } 
 
        } catch(NumberFormatException e) {
            return "Idade inválida";
        }   
    }
}