package com.example.pranayarora.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Employement";
    public static final String TABLE_NAME = "Employee";
    public static final String EMP_ID = "_id";
    public static final String EMP_NAME = "Name";
    public static final String EMP_NO = "Nmber";
    SQLiteDatabase db;

    //"create table " +TABLE_NAME+"("+EMP_ID+"integer , "+ EMP_NAME+" varchar(30));"
    @Override
    public void onCreate(SQLiteDatabase db) {
        String st  = "CREATE TABLE " + TABLE_NAME
                     + " ( "
                     + EMP_ID + " integer primary key , "
                     + EMP_NAME + " varchar(30) , "
                     + EMP_NO + " varchar(30) "
                     +");";
        db.execSQL(st);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE" + TABLE_NAME + "IF EXIST" );
        onCreate(db);
    }


    public MySQLiteOpenHelper(Context Context)
    {
       super(Context, DATABASE_NAME,null,DATABASE_VERSION);
        db = this.getWritableDatabase();
    }




    public Long addEmployee(String name, String phone_number)
    {
        ContentValues VAL = new ContentValues();
        VAL.put(EMP_NAME,name);
        VAL.put(EMP_NO,phone_number);
        Long y = db.insert(TABLE_NAME, null, VAL);
        return y;

    }
    public String[] search(String id)
    {
        String cols[] = {EMP_ID, EMP_NAME , EMP_NO};
        Cursor c = db.query(TABLE_NAME,cols,EMP_ID + "=?",new String[] {id}, null ,null ,null);
        if(c.getCount()>0)
        {
            c.moveToFirst();
            String[] x = new String[2];
            x[0] = c.getString(1);
            x[1] = c.getString(2);
            return x;

        }
        else
        {
            return null;

        }
    }
    public long update(String id , String Name,String phone_number)
    {
        ContentValues val  = new ContentValues();
        val.put(EMP_NAME,Name);
        val.put(EMP_NO,phone_number);
        long li = db.update(TABLE_NAME , val , EMP_ID + "=?" , new String[]{id});
        return  li;
    }
    public int deleteRecord(String id )
    {
        int l = db.delete(TABLE_NAME,EMP_NO + "=?" , new String[]{id});
        return l;

    }
    public String showall()
    {
        String s[] = {EMP_ID,EMP_NAME,EMP_NO};
        String ST = "" ;
        Cursor c = db.query(TABLE_NAME,s,null,null,null,null,null);
        if(c!=null)
        {
            ST = ST+"id\t name \t phonenumber \t \n ";
            for(c.moveToFirst();!c.isAfterLast();c.moveToNext());
            {
                ST = ST+c.getString(0);
                ST = ST + c.getString(1);
                ST = ST + c.getString(2);

            }
            return ST;

        }
        else
        {
         return ST;
        }
    }
}
