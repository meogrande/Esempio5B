package com.example.fabio.esempio5b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    int x = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
