package com.apirestiagodev.apirestreact.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.apirestiagodev.apirestreact.classFolder.user;
import com.apirestiagodev.apirestreact.repository.userRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class userService {

    userRepository usuario = new userRepository();
    List<user> user;

    public static user getUserService(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(id); // only 1 document

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        System.out.println(document.getData());
        user USER = null;

        if (document.exists()) {
            USER = document.toObject(user.class);

            return USER;
        } else {
            return null;
        }

    }

    public static List allUserService() throws InterruptedException, ExecutionException {

        List allUsers = new ArrayList();

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("users").get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        for (QueryDocumentSnapshot document : documents) {
            allUsers.add(document.toObject(user.class));
        }

        return allUsers;
    }

    public static Object addUser(String name, String trainningType) throws InterruptedException, ExecutionException {

        Map<String, Object> docData = new HashMap<>();

        System.out.println(name + " " + trainningType);
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

    public static user AlterUser() throws InterruptedException, ExecutionException{

        Firestore dbFirestore = FirestoreClient.getFirestore();

        // referencia o documento pelo nome da coleção
        // coloca a forma de identificacao
        // altera pelo docref.upate, (nomeItem, alteraçãoNecessaria)
            
        DocumentReference docRef = dbFirestore.collection("users").document("l4dV3ObfLBReWgHdUj2W");

        // (async) Update one field
        ApiFuture<WriteResult> future = docRef.update("name", "irmaozada");

        // ...
        WriteResult result = future.get();
        System.out.println("Write result: " + result);    

        return null;

    }

    public static String deleteUserService(String id) throws InterruptedException, ExecutionException {
        try {

            Firestore dbFirestore = FirestoreClient.getFirestore();

            ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(id).delete(); 
            // ...
            System.out.println("Update time : " + writeResult.get().getUpdateTime());

            return "Dados excluidos de users , com id = " + id;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
