/*
 * Copyright (c) 2014. Travail fait par 199364921 : Pascal Beaulac
 */

package com.example.labo2.app;

/**
 * Created by 199364921 on 2014-06-13.
 */
public class Contact {
    private int _id;
    private String nom;
    private String numTelephone;

    public Contact(int _id, String nom, String numTelephone) {
        this._id = _id;
        this.nom = nom;
        this.numTelephone = numTelephone;
    }

    public int get_id() {
        return _id;
    }

    private void set_id(int _id) {
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
