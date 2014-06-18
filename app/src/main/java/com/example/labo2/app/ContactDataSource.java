/*
 * Copyright (c) 2014. Travail fait par 199364921 : Pascal Beaulac
 */

package com.example.labo2.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pascalebeaulac on 2014-06-17.
 */
public class ContactDataSource {
    private SQLiteDatabase database;
    private ContactsDatabaseHelper dbHelper;
    private String[] allColumns = {ContactsDatabaseHelper.CHAMP_ID,
            ContactsDatabaseHelper.CHAMP_NOM,
            ContactsDatabaseHelper.CHAMP_TELEPHONE};

    public ContactDataSource(Context context) {
        dbHelper = new ContactsDatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Contact createContact(String nom, String telephone) {
        ContentValues values = new ContentValues(2);
        values.put(ContactsDatabaseHelper.CHAMP_NOM, nom);
        values.put(ContactsDatabaseHelper.CHAMP_TELEPHONE, telephone);
        long insertId = database.insert(ContactsDatabaseHelper.TABLE_CONTACTS, null,
                values);
        Cursor cursor = database.query(ContactsDatabaseHelper.TABLE_CONTACTS,
                allColumns, ContactsDatabaseHelper.CHAMP_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Contact newComment = cursorToContact(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteContact(Contact contact) {
        long id = contact.getId();
        System.out.println("Contact deleted with id: " + id);
        database.delete(ContactsDatabaseHelper.TABLE_CONTACTS, ContactsDatabaseHelper.CHAMP_ID
                + " = " + id, null);
    }

    public  int updateContact(Contact contact){
        ContentValues cv = new ContentValues(2);
        cv.put(ContactsDatabaseHelper.CHAMP_NOM, contact.getNom());
        cv.put(ContactsDatabaseHelper.CHAMP_TELEPHONE, contact.getNumTelephone());
        return database.update(ContactsDatabaseHelper.TABLE_CONTACTS,cv,"id = "+contact.getId(),null);

    }

    public List<Contact> getAllContacts() {
        List<Contact> comments = new ArrayList<Contact>();

        Cursor cursor = database.query(ContactsDatabaseHelper.TABLE_CONTACTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact = cursorToContact(cursor);
            comments.add(contact);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return comments;
    }

    private Contact cursorToContact(Cursor cursor) {
        Contact contact = new Contact();
        contact.setId(cursor.getLong(0));
        contact.setNom(cursor.getString(1));
        contact.setNumTelephone(cursor.getString(2));
        return contact;
    }
}
