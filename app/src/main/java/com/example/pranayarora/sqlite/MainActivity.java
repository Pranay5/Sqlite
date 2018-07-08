package com.example.pranayarora.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    MySQLiteOpenHelper db1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView);
        db1 = new MySQLiteOpenHelper(getApplicationContext());

        Thread t = new Thread()
        {
            public void run() {
                try
                {
                    Thread.sleep(5000);
                }
                catch (Exception e)
                {

                }
                finally
                {
                    Intent A = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(A);
                }

            }
        };
        t.start();
    }
}
