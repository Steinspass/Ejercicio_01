package com.example.ndpsh.ejercicio_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Elementos UI
    private EditText EditText;
    private Button btnnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Forzar y cargar icono en el action bar
        getSupportActionBar().setIcon(R.mipmap.ic_mylauncher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

       EditText = (EditText) findViewById(R.id.editText);
       btnnext = (Button) findViewById(R.id.button);

       btnnext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = EditText.getText().toString();
               if (name != null && !name.isEmpty()){
                   Intent intent =new Intent(MainActivity.this, SecondActivity.class);
                   intent.putExtra("name",name);
                   startActivity(intent);
               }else{
                   Toast.makeText(MainActivity.this, "Name it is empty", Toast.LENGTH_LONG).show();
               }
           }
       });


           }
       }







