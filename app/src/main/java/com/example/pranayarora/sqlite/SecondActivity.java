package com.example.pranayarora.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3;
    MySQLiteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        db = new MySQLiteOpenHelper(getApplicationContext());
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == b1.getId()) {
            Intent  A = new Intent(getApplicationContext(),ThirdActivity.class);
            startActivity(A);
        }
        if (v.getId() == b2.getId()) {
        Intent A = new Intent(getApplicationContext(),FourthActivity.class);
            startActivity(A);
        }
        if (v.getId() == b3.getId()) {
            Intent A = new Intent(getApplicationContext(),FifthActivity.class);
            startActivity(A);
        }

    }
}
