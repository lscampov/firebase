package com.lscampov.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    Spinner sp2;
    Button btn;
    DatabaseReference reff;
    Administrador admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Conexion Establecida",Toast.LENGTH_LONG).show();

        txt1= (EditText)findViewById(R.id.editText);
        txt2= (EditText)findViewById(R.id.editText2);
        txt3= (EditText)findViewById(R.id.editText5);
        txt4= (EditText)findViewById(R.id.editText6);
        txt5= (EditText)findViewById(R.id.editText3);
        txt6= (EditText)findViewById(R.id.editText4);
        txt7= (EditText)findViewById(R.id.editText7);
        txt8= (EditText)findViewById(R.id.editText8);
        sp2= (Spinner)findViewById(R.id.spinner2);

        String [] perfiles= {"Administrador","Residente"};
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, perfiles);
        sp2.setAdapter(adapter1);

        btn= (Button)findViewById(R.id.button);
        admin= new Administrador();
        reff= FirebaseDatabase.getInstance().getReference().child("Perfil");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seleccion= sp2.getSelectedItem().toString();
                if (seleccion.equals("Administrador")){
                    admin.setNombre1(txt1.getText().toString().trim());
                    admin.setNombre2(txt2.getText().toString().trim());
                    admin.setApellido1(txt3.getText().toString().trim());
                    admin.setApellido2(txt4.getText().toString().trim());
                    admin.setCedula(txt5.getText().toString().trim());
                    admin.setUser(txt6.getText().toString().trim());
                    admin.setPassword(txt7.getText().toString().trim());
                    admin.setEmail(txt8.getText().toString().trim());

                    reff.child("Administrador").child(admin.getCedula()).setValue(admin);
                    Toast.makeText(MainActivity.this,"data success",Toast.LENGTH_LONG).show();
            }
            }
        });


    }
}
