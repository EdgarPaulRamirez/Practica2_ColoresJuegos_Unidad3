package mx.edu.ittepic.dadm_ejercicio4_u3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button inicio, juego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio = findViewById(R.id.inicio);
        juego = findViewById(R.id.juego);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraventana = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(otraventana);
            }
        });

        juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraventana = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(otraventana);
            }
        });
    }
}
