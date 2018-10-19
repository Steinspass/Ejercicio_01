package com.example.ndpsh.ejercicio_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.ndpsh.ejercicio_01.SecondActivity.GREETER_OPTION;

public class ThirdActivity extends AppCompatActivity {

    // Elementos UI
    private ImageButton btnImage;
    private Button btnShare;

    // Otros valores
    private String name;
    private int Age;
    private int TypeOfMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //activar flecha para volver al MainActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recogemos el nombre del activity anterior
        Bundle bundle =getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            Age = bundle.getInt("Age");
            TypeOfMessage = bundle.getInt("Option");
        }


        // Instanciamos los elementos de la UI con sus referencias
        btnImage = (ImageButton) findViewById(R.id.btnImage);
        btnShare = (Button) findViewById(R.id.btnShare);

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, createMessage(name, Age, TypeOfMessage), Toast.LENGTH_LONG).show();
                btnShare.setVisibility(View.VISIBLE);
                btnImage.setVisibility(View.INVISIBLE);
            }
        });



        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, createMessage(name, Age, TypeOfMessage));
                startActivity(i);
            }
        });
    }

    private String createMessage(String name,int Age, int TypeOfMessage){
        if (TypeOfMessage == SecondActivity.GREETER_OPTION) {
            return "Hola "+ name +",Como llevas esos " + Age +"años? #MyForm";
        }else {
            return "Espero verte pronto "+ name + ", antes que cumplas "+ (Age + 1) + "#MyForm";
        }
    }






}
