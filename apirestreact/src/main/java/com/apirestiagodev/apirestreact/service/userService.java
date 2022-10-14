package com.apirestiagodev.apirestreact.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestiagodev.apirestreact.classFolder.user;
import com.apirestiagodev.apirestreact.repository.userRepository;

@RestController
public class userService {
    
    userRepository usuario = new userRepository();

    @RequestMapping
    @GetMapping(value="/userAll")
    public List<user> exibirUsuarios(){

        return usuario.getUsers();

    }

}
