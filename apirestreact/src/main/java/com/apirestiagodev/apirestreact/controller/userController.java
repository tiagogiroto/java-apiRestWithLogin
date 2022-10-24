package com.apirestiagodev.apirestreact.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestiagodev.apirestreact.classFolder.user;
import com.apirestiagodev.apirestreact.repository.userRepository;

@RestController
public class userController {

    userRepository usuario = new userRepository();

    @GetMapping(value="/userAll", produces = "application/json")
    public List<user> exibirUsuarios(){
        return usuario.getUsers();

    }
    
    @GetMapping(value = "/getUser", produces="application/json") 
    public user getUser() throws InterruptedException, ExecutionException{

        return usuario.getUserRepository();
    }

    @GetMapping(value = "/allUsers", produces = "application/json")
    public Object getAllUsers() throws InterruptedException, ExecutionException{

        return usuario.allUsers();

    }

    @PostMapping(value = "/addUser", produces = "application/json")
    public Object addUser(String name, String trainningType) throws InterruptedException, ExecutionException{
        
        return usuario.addUser(name, trainningType);
    }

    // criar metodo de alterar dados

    // criar metodo de exclusao

    

}
