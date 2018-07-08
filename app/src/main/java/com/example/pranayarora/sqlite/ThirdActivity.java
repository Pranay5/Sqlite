package com.example.pranayarora.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2;
    Button b1;
    MySQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        db = new MySQLiteOpenHelper(getApplicationContext());
        b1 = (Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.edittext);
        e2  = (EditText)findViewById(R.id.edittext);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == b1.getId())
        {
        String name = e1.getText().toString();
            String phone_number = e2.getText().toString();
            Long y  = db.addEmployee(name,phone_number);
            if(y>0)
            {
                Toast.makeText(getApplicationContext(),"Record inserted successfully",Toast.LENGTH_LONG).show();
                Intent A = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(A);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Record Inserted Not Successfully", Toast.LENGTH_LONG).show();

            }

        }
    }
}
