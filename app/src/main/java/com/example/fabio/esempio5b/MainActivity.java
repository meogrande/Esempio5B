package com.example.fabio.esempio5b;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button;
    int x = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("configurazione", MODE_PRIVATE);
        System.out.println("L'ultimo valore salvato è: " + sp.getInt("x", 0));
        System.out.println("Nella data: " + sp.getString("data",""));


        if(savedInstanceState!=null) {
            x = savedInstanceState.getInt("numero");
        }

        // Recupero il puntatore all'elemento grafico
        button = findViewById(R.id.grecoButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Boh",getString(R.string.saluto_toast));
                x++;
                Toast t=  Toast.makeText(getApplicationContext(),""+x,Toast.LENGTH_SHORT);
                t.show();
            }
        });

        Button b = findViewById(R.id.buttonVaiA);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondaActivity.class);
                i.putExtra("x",x);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo di vita", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo di vita", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences("configurazione", MODE_PRIVATE).edit();
        editor.putInt("x",x);
        editor.putString("data", Calendar.getInstance().getTime().toString());
        editor.apply();

        Log.i("ciclo di vita", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo di vita", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo di vita", "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo di vita", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("numero", x);
        super.onSaveInstanceState(outState);
    }


}
