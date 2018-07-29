package com.example.vaibh.sqlitedb;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Email, PassWord;
    Button SignUp, SignIn;
    String email, password;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.email);
        PassWord = (EditText) findViewById(R.id.password);
        SignUp = (Button) findViewById(R.id.signUp);
        SignIn = (Button) findViewById(R.id.signIn);

        databaseHelper = new DatabaseHelper(this);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = Email.getText().toString();
                password = PassWord.getText().toString();
                boolean isinserted = databaseHelper.insertUser(email, password); //this method returns boolean value

                if (isinserted == true) {
                    Toast.makeText(getApplicationContext(), "User Registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "User Registration Unsuccessful", Toast.LENGTH_LONG).show();
                }
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = Email.getText().toString();
                password = PassWord.getText().toString();
                Cursor cursor = databaseHelper.checkUserCredentials(email,password);
                if(cursor.getCount()==0)  //if cursor's count is 0 means it has not returned any value/records from checkUserCredentials() method
                {
                    Toast.makeText(getApplicationContext(), "Wrong Email or Password ", Toast.LENGTH_LONG).show();
                    return;
                }

                else   //if cursor returns some value means provided email and password in edit text were present in database table
                {
                    Intent intent = new Intent(MainActivity.this , HomeActivity.class);
                    //we can also send data from intent. use putExtra to send data from intent.
                    //putExtra method has 2 arguments. key and value.
                    //we will get the value on basis of key in next activity.
                    intent.putExtra("user", "User is Logged In");
                    startActivity(intent);
                }

            }
        });
    }
}
