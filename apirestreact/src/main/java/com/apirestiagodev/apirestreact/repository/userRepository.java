package com.apirestiagodev.apirestreact.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.apirestiagodev.apirestreact.classFolder.user;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

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

    /** 
        {@getUserRepository} 
        {Busca um  usuario por seu id} 
    */ 
    public user getUserRepository() throws InterruptedException, ExecutionException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = 
            dbFirestore.collection("users").document("Fm0zFozrDpBHxWnPsbQl"); // only 1 document

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        System.out.println(document.getData());
        user USER = null;

        if(document.exists()) {
            USER = document.toObject(user.class);

            return USER;
        }else {
            return null;
        }

    }


    /** 
        {@allUsers} 
        {buscar toda a lista de usuarios} 
    */  
    public List allUsers() throws InterruptedException, ExecutionException {

        List allUsers = new ArrayList<>();

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("users").get();
        
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();


        for (QueryDocumentSnapshot document : documents) {
            allUsers.add(document.toObject(user.class));
          }

        return allUsers;

    }

    /** 
        {@addUser} 
        {Adiciona um novo usuario com id de documento aleatorio} 
    */  
    public Object addUser(String name, String trainningType) throws InterruptedException, ExecutionException{
            Map<String, Object> docData = new HashMap<>();

            System.out.println(name + " " + trainningType );
        try {

            docData.put("name", name);
            docData.put("trainningType", trainningType);
    
            Firestore dbFirestore = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> future = dbFirestore.collection("users").document().set(docData);
    
            System.out.println("Update time : " + future.get().getUpdateTime());
            
        } catch (Exception e) {
            System.out.println(e);
        }
       return docData;
    }
}
