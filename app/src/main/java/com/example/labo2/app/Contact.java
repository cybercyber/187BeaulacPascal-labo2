/*
 * Copyright (c) 2014. Travail fait par 199364921 : Pascal Beaulac
 */

package com.example.labo2.app;

import android.database.sqlite.SQLiteDatabase;

public class Contact {
    private long _id;
    private String nom;
    private String numTelephone;

    public Contact(){

    };

    public Contact(long id, String nom, String numTelephone) {
        this._id = id;
        this.nom = nom;
        this.numTelephone = numTelephone;
    }

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }
}
