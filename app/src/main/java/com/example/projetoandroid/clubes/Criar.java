package com.example.projetoandroid.clubes;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoandroid.R;
import com.example.projetoandroid.paises.Listar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Criar extends AppCompatActivity{


    String  nomePais , idPais;
    TextView textView;
    EditText editText;
    String id;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clubes_criar);

        Intent in = getIntent();

        idPais = in.getStringExtra("idPais");
        nomePais = in.getStringExtra("nomePais");
        textView = findViewById(R.id.textViewClubesCriar);
        textView.setText("Cria clube para "+ nomePais);




    }




     public void CriarClube(View v){







         editText = findViewById(R.id.edtClubes);

         String nomeDoClube= editText.getText().toString();


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

         //criar nome

         DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("/Clubes/" + id + "/nome/");

         databaseReference.setValue(nomeDoClube.toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
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


        //criar idPais

            databaseReference = FirebaseDatabase.getInstance().getReference("/Clubes/" + id + "/idPais/");

         databaseReference.setValue(idPais.toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
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
