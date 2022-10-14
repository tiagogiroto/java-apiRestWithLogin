package com.apirestiagodev.apirestreact.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
    

}
