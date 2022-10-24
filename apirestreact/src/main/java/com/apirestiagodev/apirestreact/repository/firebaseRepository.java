package com.apirestiagodev.apirestreact.repository;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.InputStream;
import java.io.StringWriter;

import javax.annotation.PostConstruct;


@Service
public class firebaseRepository {
    @PostConstruct
    public void initialize() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("../addons/key.json");
            StringWriter writer = new StringWriter();
            System.out.println(writer.toString());
            ServiceAccountCredentials serviceAccountCredentials = ServiceAccountCredentials.fromStream(inputStream);
      
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(serviceAccountCredentials).build();
            FirebaseApp.initializeApp(options);


        } catch (Exception e) {
            System.out.println(e);
        }
    }

}