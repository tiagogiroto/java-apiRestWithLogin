package com.apirestiagodev.apirestreact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Inicio {
  
    @GetMapping(value="/")
    public String teste() {
        return "ola, mmundo";
    }
    



}

