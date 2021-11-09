package com.example.databasepersistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table  Useraccount(username Text primary key, password TEXT,email TEXT,NamaLengkap TEXT,Asalsekolah TEXT,AlamatTinggal TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Useraccount");
    }
    public boolean insertUserData(String username, String password, String email, String fullName,String school,String address){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
        contentValues.put("namalengkap",fullName);
        contentValues.put("Asalsekolah", school);
        contentValues.put("Alamat",address);
        long result = sqLiteDatabase.insert("Useraccount",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;    
        }
    }
}
