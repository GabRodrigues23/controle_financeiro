package com.fatec.controle_financeiro.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.entities.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private List<User> usuarios = new ArrayList<>();
    private int proximoId = 1;

    //CRUD = CREATE, READ, UPDATE E DELETE
    
    //CREATE    
    @PostMapping()
    public ResponseEntity<User> createUse(@RequestBody User usuario) {

        for (User user : usuarios) {
            if (user.getName().equals(usuario.getName())) {
                throw new IllegalArgumentException("ja existe nome");
            }
        }

        usuario.setId(proximoId++);
        usuarios.add(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }


    //READ
    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (User user : usuarios) {
            if (user.getId() == id) {
                // Se o usuário for encontrado, retorna-o com status 200 OK
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User entity) {
         // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
         for (User user : usuarios) {
            if (user.getId() == id) {
                // Se o usuário for encontrado, atualiza suas informações
                user.setName(entity.getName());
                user.setAge(entity.getAge());
                // Retorna o usuário atualizado com status 200 OK
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (User user : usuarios) {
            if (user.getId() == id) {
                // Se o usuário for encontrado, remove-o da lista
                usuarios.remove(user);
                // Retorna status 204 No Content
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        //Forma otimizada do codigo acima
       /*Optional<User> user = usuarios.stream().filter(u -> u.getId() == id).findFirst();
       if (user.isPresent()) {
            usuarios.remove(user.get());
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }*/
        
    }
}
