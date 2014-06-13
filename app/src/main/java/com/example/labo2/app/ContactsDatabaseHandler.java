/*
 * Copyright (c) 2014. Travail fait par 199364921 : Pascal Beaulac
 */

package com.example.labo2.app;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.List;

public class ContactsDatabaseHandler extends SQLiteOpenHelper {
    private static final int VERSION_BD = 1;
    private static final String NOM_BD = "gestionContacts";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String CHAMP_ID = "id";
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_TELEPHONE = "telephone";


    public ContactsDatabaseHandler(Context context) {
        super(context, NOM_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CONTACTS+"(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(50) NOT NULL, telephone VARCHAR(20) NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

    public List<Contact> getAllContacts(){

        return null;
    }
}
