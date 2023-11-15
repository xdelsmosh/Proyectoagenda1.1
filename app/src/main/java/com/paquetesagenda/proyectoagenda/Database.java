package com.paquetesagenda.proyectoagenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database  extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(usuario text,email,password text)";
        sqLiteDatabase.execSQL(qry1);


        ContentValues cv = new ContentValues();
        cv.put("usuario", "toño");
        cv.put("email", "toño1@ejemplo.com");
        cv.put("password", "toño1234@");

        sqLiteDatabase.insert("users", null, cv);
        String qry2 = "create table cart(usuario text,product text,price float,otype text)";
        sqLiteDatabase.execSQL(qry2);
        String qry3 = "create table orderplace(usuario text,product text,price float,otype text)";
        sqLiteDatabase.execSQL(qry3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void registro(String usuario,String email,String password){
        ContentValues cv = new ContentValues();
        cv.put("usuario",usuario);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }

    public int login(String usuario ,String password){
        int result = 0;
        String str[] = new  String[2];
        str[0] = usuario;
        str[1] = password;
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from users where usuario=? and password=?",str);
        if (c.moveToFirst()){
            result  = 1;
        }
        return result;
    }



    public void addCart(String usuario ,String product,float price,String otype){
            ContentValues cv =new ContentValues();
            cv.put("usuario",usuario);
            cv.put("product",product);
            cv.put("price",price);
            cv.put("otype",otype);
            SQLiteDatabase db = getWritableDatabase();
            db.insert("cart",null,cv);
            db.close();
        }


    public int chekCart(String usuario ,String product){
        int result = 0;
        String str[] = new  String[2];
        str[0] = usuario;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart where usuario=? and product=?",str);
        if (c.moveToFirst()){
            result  = 1;
        }
        db.close();
        return result;
    }


    public void removeCart(String usuario,String otype){
        String str[]=new String[2];
        str[0] = usuario;
        str[1] = otype;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart","usuario=? and otype=?",str);
        db.close();

    }

    public ArrayList getCartData (String usuario,String otype){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[]= new String[2];
        str[0] = usuario;
        str[1]=otype;
        Cursor c = db.rawQuery("select * from cart where usuario=? and otype=?",str);
        if(c.moveToFirst()){

            do {
                String product = c.getString(1);
                String price = c.getString(2);
                arr.add(product+"S"+price);
            }while (c.moveToNext());
        }
            db.close();
            return arr;
    }

    public ArrayList getOrderData(String usuario){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = usuario;
        Cursor c = db.rawQuery("select * from orderplace where usuario=?",str);
        if (c.moveToFirst()){
            do {
                arr.add(c.getString(1)+"$"+c.getString(2));
            }while (c.moveToNext());
        }
        db.close();
        return arr;
    }

}
