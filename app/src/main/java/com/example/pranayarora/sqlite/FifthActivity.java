package com.example.pranayarora.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {
TextView tv;
MySQLiteOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        tv = (TextView)findViewById(R.id.textView5);
        db  = new MySQLiteOpenHelper(this);
        String s = db.showall();
        tv.setText(s);

    }
}
