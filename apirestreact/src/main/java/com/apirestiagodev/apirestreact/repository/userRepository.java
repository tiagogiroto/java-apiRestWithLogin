package com.apirestiagodev.apirestreact.repository;

import java.util.ArrayList;
import java.util.List;

import com.apirestiagodev.apirestreact.classFolder.user;

public class userRepository {
    
    List<user> user;

    // exibe tudo inserido dentro dos setters  de usuarios
    public List<user> getUsers(){

        List<user> users = new ArrayList<>();

        try {
            user usuario = new user();
            usuario.setName("tiago");
            usuario.setTrainningType("dsaedasdasda");

            users.add(usuario);


        } catch (Exception e) {
            System.out.println(e);
        }

        return users;
    }
}
