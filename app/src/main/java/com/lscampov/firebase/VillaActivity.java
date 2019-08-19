package com.lscampov.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VillaActivity extends AppCompatActivity {

    EditText txt1,txt2,txt3,txt4;
    Button btnCrear;
    DatabaseReference dataBase;
    Villa villa;
    long maxId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villa);

        txt1 = (EditText)findViewById(R.id.editText14);
        txt2 = (EditText)findViewById(R.id.editText15);
        txt3 = (EditText)findViewById(R.id.editText16);
        txt4 = (EditText)findViewById(R.id.editText17);
        btnCrear = (Button)findViewById(R.id.button10);
        dataBase = FirebaseDatabase.getInstance().getReference();
        villa = new Villa();
        dataBase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxId = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int manzana = Integer.parseInt(txt1.getText().toString().trim());
                int vil = Integer.parseInt(txt2.getText().toString().trim());
                double lat = Double.parseDouble(txt3.getText().toString().trim());
                double lon = Double.parseDouble(txt4.getText().toString().trim());

                villa.setMz(manzana);
                villa.setVilla(vil);
                villa.setLatitud(lat);
                villa.setLongitud(lon);

                dataBase.child("Villa").child(String.valueOf(maxId+1)).setValue(villa);
                Toast.makeText(VillaActivity.this, "Villa agregada exitosamente", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
