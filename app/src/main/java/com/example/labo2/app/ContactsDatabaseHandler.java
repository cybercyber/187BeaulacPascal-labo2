/*
 * Copyright (c) 2014. Travail fait par 199364921 : Pascal Beaulac
 */

package com.example.labo2.app;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 199364921 on 2014-06-13.
 */

public class ContactsDatabaseHandler extends SQLiteOpenHelper {
    private static final int VERSION_BD = 1;
    private static final String NOM_BD = "gestionContacts";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String CHAMP_ID = "id";
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_TELEPHONE = "telephone";
    
    public ContactsDatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public ContactsDatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
