/*
 * Copyright (c) 2014. Travail fait par 199364921 : Pascal Beaulac
 */

package com.example.labo2.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactsDatabaseHelper extends SQLiteOpenHelper {
    public static final int VERSION_BD = 1;
    public static final String NOM_BD = "gestionContacts";
    public static final String TABLE_CONTACTS = "contacts";
    public static final String CHAMP_ID = "id";
    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_TELEPHONE = "telephone";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_CONTACTS+"("+ CHAMP_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CHAMP_NOM + " VARCHAR(50) NOT NULL, "
            + CHAMP_TELEPHONE +" VARCHAR(20))";


    public ContactsDatabaseHelper(Context context) {
        super(context, NOM_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ContactsDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data"
        );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }
}
