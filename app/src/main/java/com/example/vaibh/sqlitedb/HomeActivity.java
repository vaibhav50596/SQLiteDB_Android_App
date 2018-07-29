package com.example.vaibh.sqlitedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView loginText;
    private String intentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loginText = (TextView) findViewById(R.id.textLogin);

        //Use getIntent().getStringExtra() method and specify key "user" to get the value from intent which we sent from previous activity
        intentData = getIntent().getStringExtra("user");

        //This is how we set the text inside TextView
        loginText.setText(intentData);
    }
}
