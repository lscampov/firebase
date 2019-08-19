package com.lscampov.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void agregarBtn(View view) {
        Intent i = new Intent(this, AgregarActivity.class );
        startActivity(i);
    }

    public void consultaBtn(View view) {
        Intent i = new Intent(this, ConsultaActivity.class );
        startActivity(i);
    }

    /*public void asignacionBtn(View view) {
        Intent i = new Intent(this, AsignacionActivity.class );
        startActivity(i);
    }*/
}
