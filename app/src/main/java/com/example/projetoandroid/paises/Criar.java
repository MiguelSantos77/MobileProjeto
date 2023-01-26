package com.example.projetoandroid.paises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Criar extends AppCompatActivity {


    DatabaseReference databaseReference;



    EditText editText;

    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paises_criar);







    }










    public void CriarPais(View v){



        editText = findViewById(R.id.edtPais);
        String nomeDoPais= editText.getText().toString();


        //descobrir ultimo ID


        Intent in = getIntent();
        id = in.getStringExtra("ultimoId");

        if (id==null){
            id="1";
        }else
        {
            int idInt = Integer.parseInt(id);
            idInt++;
            id= Integer.toString(idInt);
        }

        //criar

        databaseReference = FirebaseDatabase.getInstance().getReference("/Paises/"+ id +"/nome/");


        databaseReference.setValue(nomeDoPais.toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

                editText.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                editText.setText("");

            }
        }).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                editText.setText("");

            }
        });





        Intent i = new Intent(getApplicationContext(), Listar.class);
        startActivity(i);



    }



}
