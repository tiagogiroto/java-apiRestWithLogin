package com.apirestiagodev.apirestreact.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestiagodev.apirestreact.classFolder.user;
import com.apirestiagodev.apirestreact.repository.userRepository;

@RestController
public class userController {

    userRepository usuario = new userRepository();

    @GetMapping(value = "/getUser", produces="application/json") 
    public user getUser(String id) throws InterruptedException, ExecutionException{

        return usuario.getUserRepository(id);
    }

    @GetMapping(value = "/allUsers", produces = "application/json")
    public Object getAllUsers() throws InterruptedException, ExecutionException{
        return usuario.allUsers();

    }

    @PostMapping(value = "/addUser", produces = "application/json")
    public Object addUser(String name, String trainningType) throws InterruptedException, ExecutionException{

        return usuario.addUser(name, trainningType);
    }

    @PutMapping(value = "/alterUser", produces = "application/json")
    public user alterUser()throws InterruptedException, ExecutionException{
        return usuario.alterUser();
    }

    // criar metodo de exclusao
    @DeleteMapping(value = "/deleteUser", produces="application/json")
    public String deleteUser(String id) throws InterruptedException, ExecutionException{

        return usuario.deleteUser(id);
    }

    

}
