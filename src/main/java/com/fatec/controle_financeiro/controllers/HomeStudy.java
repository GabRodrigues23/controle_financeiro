package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/study")
public class HomeStudy {

    @GetMapping("/ping")
    public String getPong() {
        return "pong . . .";
    }   
    
    @GetMapping("/exercise1/{doubleNumber}")
    public String calculateDouble(@PathVariable double doubleNumber) {
        return "The double of " + doubleNumber + " is: " + doubleNumber * 2;
    }
    
    @GetMapping("/exercise2/{fat}")
    public String getFat(@PathVariable double fat) {
        double num = fat;
        for(double i = 1; i < num; ++i){
            fat*= i;
        }
        return "The fatorial of " + num + " is: " + fat;
    }
}