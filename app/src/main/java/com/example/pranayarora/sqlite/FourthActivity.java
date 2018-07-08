package com.example.pranayarora.sqlite;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2,e3;
    Button b1,b2,b3;
    MySQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        db = new MySQLiteOpenHelper(getApplicationContext());
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        e1 = (EditText)findViewById(R.id.editText);
        e2  = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)

    {
        if(v.getId()==b1.getId())
        {
            String id = e1.getText().toString();
            String[] z;
            z = db.search(id);
            if(z == null)
            {
                Toast.makeText(getApplicationContext(),"No Record Found",Toast.LENGTH_LONG).show();

            }
            else
            {
                e2.setText(z[0]);
                e3.setText(z[1]);

            }

        }
        if(v.getId()==b2.getId())
        {
            String a = e1.getText().toString();
            String b = e2.getText().toString();
            String c = e3.getText().toString();
            Long y = db.update(a,b,c);
            if (y>0)
            {
                Toast.makeText(getApplicationContext(),"Record Update Successfull",Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");

            }
        }
        if(v.getId()==b3.getId())
        {
            String s = e1.getText().toString();
            int aa;
            aa = db.deleteRecord(s);
            if(aa >0)
            {
                Toast.makeText(getApplicationContext(), "Record is deleted", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Record not deleted", Toast.LENGTH_SHORT).show();
            }



        }

    }
}
