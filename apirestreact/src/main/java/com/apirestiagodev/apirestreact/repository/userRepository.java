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

    /** 
        {@AlterUser} 
        {Altera os dados do usuariro com base no id da coleção referenciando o ponto especifico} 
    */  
    public user alterUser() throws InterruptedException, ExecutionException{

        Firestore dbFirestore = FirestoreClient.getFirestore();

        // referencia o documento pelo nome da coleção
        // coloca a forma de identificacao
        // altera pelo docref.upate, (nomeItem, alteraçãoNecessaria)
            
        DocumentReference docRef = dbFirestore.collection("users").document("XhHcTiMNzI9IXevylrPC");

        // (async) Update one field
        ApiFuture<WriteResult> future = docRef.update("trainningType", "teste alaateracao");

        // ...
        WriteResult result = future.get();
        System.out.println("Write result: " + result);    

        return null;
    }

    /** 
        {@deleteUser} 
        {deleta o usuario pelo id da coleção} 
    */  
    public String deleteUser(String id)throws InterruptedException, ExecutionException {

        try {

            Firestore dbFirestore = FirestoreClient.getFirestore();

            ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(id).delete(); 
            // ...
            System.out.println("Update time : " + writeResult.get().getUpdateTime());

            return "Dados excluidos de users , com id = " + id;

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return null;
        
    }

}
