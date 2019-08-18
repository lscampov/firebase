package com.lscampov.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2,txt3,txt4;
    Button btn;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Conexion Establecida",Toast.LENGTH_LONG).show();

        txt1= (EditText)findViewById(R.id.editText3);
        txt2= (EditText)findViewById(R.id.editText4);
        txt3= (EditText)findViewById(R.id.editText5);
        txt4= (EditText)findViewById(R.id.editText6);
        btn= (Button)findViewById(R.id.button);
        member= new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int edad= Integer.parseInt(txt2.getText().toString().trim());
                Float peso= Float.parseFloat(txt4.getText().toString().trim());
                Long telf= Long.parseLong(txt3.getText().toString().trim());

                member.setName(txt1.getText().toString().trim());
                member.setAge(edad);
                member.setHt(peso);
                member.setPhone(telf);
                reff.child("member1").setValue(member);
                Toast.makeText(MainActivity.this,"data success",Toast.LENGTH_LONG).show();
            }
        });


    }
}
