package com.example.vaibh.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserData.db";
    public static final String col_1 = "email";
    public static final String col_2 = "password";
    public static final String TABLE_USER = "registeruser";

    private static final String SQL_REGISTER_USER =" Create TABLE " + TABLE_USER + "(" + col_1 + " TEXT, " + col_2 + " TEXT )" ;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_REGISTER_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE  IF EXISTS " + SQL_REGISTER_USER);

    }

    //This method will insert email and password in database on click of sign up button
    //We use content values to insert data in sqlite database
    public boolean insertUser(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_1, email);
        cv.put(col_2, password);

        long result = db.insert(TABLE_USER, null, cv);
        if (result == -1)  // if result is -1 then we could not insert value in database table so we are returning false boolean
            return false;
        else
            return true;   // else we will return true boolean because result is not -1 so data is inserted successfully
    }

    //This method will retrieve email and password from database on basis of email(where clause).
    //We use Cursor to retrieve data from sqlite database
    public Cursor checkUserCredentials(String email, String password) {
        String columns[] = {col_1, col_2};   //passing col_1(email) and col_2(password) which we have to fetch from table
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("registeruser", columns, "email=? and password=?", new String[]{email, password}, null, null, null);
        // inside db.query() is nothing but : SELECT email, password FROM registeruser WHERE email=? and password=?
        //we pass first argument as table name, second as columns which we have to fetch, third is selection means what we have select and fourth as email and password which are entered in edit text
        return cursor;              //This method will return cursor object from where it is called which will have email and password
    }
}
