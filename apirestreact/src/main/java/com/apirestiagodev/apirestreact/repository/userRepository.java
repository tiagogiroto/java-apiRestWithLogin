package com.apirestiagodev.apirestreact.repository;

import java.util.List;

import java.util.concurrent.ExecutionException;

import com.apirestiagodev.apirestreact.classFolder.user;
import com.apirestiagodev.apirestreact.service.userService;


public class userRepository {
    
    List<user> user;
    /** 
        {@getUserRepository} 
        {Busca um  usuario por seu id} 
    */ 
    public user getUserRepository(String id) throws InterruptedException, ExecutionException {
        return userService.getUserService(id);
    }

    /** 
        {@allUsers} 
        {buscar toda a lista de usuarios} 
    */  
    public List allUsers() throws InterruptedException, ExecutionException {
        return userService.allUserService();

    }

    /** 
        {@addUser} 
        {Adiciona um novo usuario com id de documento aleatorio} 
    */  
    public Object addUser(String name, String trainningType) throws InterruptedException, ExecutionException{
        return userService.addUser(name, trainningType);
        
    }

    /** 
        {@AlterUser} 
        {Altera os dados do usuariro com base no id da coleção referenciando o ponto especifico #editar} 
    */  
    public user alterUser() throws InterruptedException, ExecutionException{

        return userService.AlterUser();
    }

    /** 
        {@deleteUser} 
        {deleta o usuario pelo id da coleção} 
    */  
    public String deleteUser(String id)throws InterruptedException, ExecutionException {
        return userService.deleteUserService(id);
        
    }

}
