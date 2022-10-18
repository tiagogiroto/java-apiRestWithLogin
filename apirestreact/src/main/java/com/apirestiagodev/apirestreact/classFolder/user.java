package com.apirestiagodev.apirestreact.classFolder;

public class user {
    private String name;
    private String trainningType;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getTrainningType() {
        return trainningType;
    }
    public void setTrainningType(String trainningType) {
        this.trainningType = trainningType;
    }


    public String toString(){
        return "Usuario = "+ name + ", Tipo de treino =" + trainningType ;
    }
}
