package com.example.ndpsh.ejercicio_01;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;

public class SecondActivity extends AppCompatActivity {

    //Elementos UI
    private RadioButton btnGreeder;
    private RadioButton btnFarewell;
    private SeekBar seekAge;
    private TextView TextAge;
    private Button btnNext2;

    // Otro valores
    private  String name ="";
    private int Age = 18;
    private final int MinAge = 16;
    private final int MaxAge = 60;

    // Valores de las  2 opciones a compartir
    public static final int GREETER_OPTION = 1;
    public static final int FAREWELL_OPTION =2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //activar flecha para volver al MainActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Trae el nombre puesto en el Main Activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            name = bundle.getString("name");
        }

        // Istanciamos los elementos UI
        btnGreeder = (RadioButton) findViewById(R.id.btnGreeter);
        btnFarewell = (RadioButton) findViewById(R.id.btnFarewell);
        seekAge = (SeekBar) findViewById(R.id.seekAge);
        TextAge = (TextView) findViewById(R.id.TextAge);
        btnNext2 = (Button) findViewById(R.id.btnNext2);

        seekAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekAge, int currentAge, boolean b) {
              Age = currentAge;
              TextAge.setText(Age + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //no nesesito esta funcion
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Age = seekAge.getProgress();
                TextAge.setText(Age + "");

                if (Age > MaxAge){
                    btnNext2.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "Eres mayor de la edad permitida: "+MaxAge+" edad.",Toast.LENGTH_LONG).show();
                }else if (Age< MinAge){
                    btnNext2.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this, "Eres menor de la edad permitida: "+MinAge+" edad.",Toast.LENGTH_LONG).show();
                }else {
                    btnNext2.setVisibility(View.VISIBLE);
                }

            }
        });

            btnNext2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                   i.putExtra("name",name);
                   i.putExtra("Age",Age);

                   int Option = (btnGreeder.isChecked()) ?  GREETER_OPTION : FAREWELL_OPTION;
                   i.putExtra("Option",Option);
                   startActivity(i);
                   Toast.makeText(SecondActivity.this, seekAge.getProgress()+"",Toast.LENGTH_LONG).show();

                }
            });


    }
}
