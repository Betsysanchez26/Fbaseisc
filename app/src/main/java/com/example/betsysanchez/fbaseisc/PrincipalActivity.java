package com.example.betsysanchez.fbaseisc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.betsysanchez.fbaseisc.Objetos.Alumno;
import com.example.betsysanchez.fbaseisc.Objetos.FirebaseReferences;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by BetsySanchez on 15/04/2018.
 */

public class PrincipalActivity extends AppCompatActivity {
    EditText nombre,nocontrol;
    Button btnGuardar,btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nombre=findViewById(R.id.etNombre);
        nocontrol=findViewById(R.id.etNoControl);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnCerrar=findViewById(R.id.btnCerrar);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FirebaseReferences.TUTORIAL_PREFERENCE);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nuevoNombre=nombre.getText().toString();
                String nuevoNoControl=nocontrol.getText().toString();
                Alumno alumno =new Alumno(Long.parseLong(nuevoNoControl),nuevoNombre);
                myRef.child(FirebaseReferences.USER_PREFERENCE).push().setValue(alumno).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.i("Datos","Dato Guardado");
                            nombre.setText("");
                            nocontrol.setText("");
                        }else{
                            Log.e("Datos",task.getException().getMessage()+"");
                        }
                    }
                });
            }
        });
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
            }
        });
    }
}
