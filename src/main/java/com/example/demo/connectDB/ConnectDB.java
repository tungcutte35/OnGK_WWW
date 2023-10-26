package com.example.demo.connectDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB instance;
    private EntityManager em;

    public ConnectDB() {
        em = Persistence.createEntityManagerFactory("demo").createEntityManager();
    }
    public static ConnectDB getInstance(){
        if(instance == null){
            instance = new ConnectDB();
        }
        return instance;
    }
    public EntityManager getEntityManager() {
        return em;
    }

    public static void main(String[] args) {
        ConnectDB.getInstance().getEntityManager();

    }
}
