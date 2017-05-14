package com.example.quiz_app;

import android.content.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        Intent intent = new Intent(MainActivity.this,questions.class);
        EditText et1 = (EditText) findViewById(R.id.name);
        EditText et2 = (EditText) findViewById(R.id.email);
        intent.putExtra("name",et1.getText().toString());
        intent.putExtra("email",et2.getText().toString());
        startActivity(intent);
    }


}
