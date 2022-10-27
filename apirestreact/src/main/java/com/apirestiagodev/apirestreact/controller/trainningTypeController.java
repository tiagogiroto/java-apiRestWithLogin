package com.apirestiagodev.apirestreact.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestiagodev.apirestreact.classFolder.trainningType;

@RestController
public class trainningTypeController {
    
    

    @GetMapping(value = "/getAllTrainningType", produces = "application/json")
    public trainningType getAllTrainningType(){
        
        return null;
    }

    @PostMapping(value="/createTrainningType", produces = "application/json")
    public trainningType createTrainningType(){
        
        return null;
    } 

    @DeleteMapping(value = "/deleteTrainningType", produces = "application/json")
    public String deleteTrainningType(){

        return null;
    }

    @PutMapping(value = "/alterTrainningType", produces = "application/json")
    public trainningType alterTrainningType(){

        return null;
    }

}
