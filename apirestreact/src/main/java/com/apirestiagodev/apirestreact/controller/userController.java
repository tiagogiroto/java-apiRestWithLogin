package com.apirestiagodev.apirestreact.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public user getUser(@RequestParam String name ) throws InterruptedException, ExecutionException{

        return usuario.getUserRepository(name);
    }

}
