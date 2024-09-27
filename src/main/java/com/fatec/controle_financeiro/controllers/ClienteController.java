package com.fatec.controle_financeiro.controllers;
import com.fatec.controle_financeiro.entities.Cliente;
import com.fatec.controle_financeiro.domain.cliente.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping; 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController{
    @Autowired
    private ClienteRepository clienteRepository;
    
    private List<Cliente> clientes = new ArrayList<>();
    private int nextID = 1;

    // CREATE
    @PostMapping("/register")
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente cliente){
        /*for(Cliente cliente : clientes){
            if(cliente.getNome().equals(user.getNome())){
                throw new IllegalArgumentException("Já existe um usuário com esse nome.");
            }
        }

        user.setId();
        clientes.add(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);*/

        Cliente clienteCreated = clienteRepository.save(cliente);
        return new ResponseEntity<>(clienteCreated, HttpStatus.CREATED);
    }


    // SELECT (READ)
    @GetMapping("/select_all")
    public ResponseEntity<List<Cliente> > getAllUser(){
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable int id){
        for(Cliente cliente : clientes){
            if(cliente.getId() == id){
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

 
    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateUser(@PathVariable int id, @RequestBody Cliente entity){
        for(Cliente cliente : clientes){
            if(cliente.getId() == id){
                cliente.setNome();
                
                return new ResponseEntity<>(cliente, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        for (Cliente cliente : clientes){
            if(cliente.getId() == id){
                clientes.remove(cliente);

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}