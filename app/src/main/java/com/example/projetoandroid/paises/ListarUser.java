package com.example.projetoandroid.paises;

import static com.example.projetoandroid.R.id.butaoCriar;
import static com.example.projetoandroid.R.id.llContainer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoandroid.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListarUser extends AppCompatActivity {

    DatabaseReference databaseReference;

    List<String> listaIdPaises;

    Map<String,String> listaDePaises = new HashMap<String, String>();

    String ultimoId = null;
    Button butaocriar;
    String username= null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_user);



        listaIdPaises = new ArrayList<>();

        ListarPaises();



        Intent in = getIntent();

        username = in.getStringExtra("username");


    }



    TextView textView;
    LinearLayout llLista;



    public void ListarPaises(){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Paises");

        textView = findViewById(R.id.textViewPaises);

        llLista = findViewById(llContainer);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                if (snapshot.hasChildren()){




                    for (DataSnapshot snapshot1 : snapshot.getChildren()){

                        listaIdPaises.add(snapshot1.getKey());

                        listaDePaises.put(snapshot1.getKey(), snapshot1.child("nome").getValue().toString());

                        ultimoId=snapshot1.getKey();


                    }

                    criarButoesPais();


                }
                else
                    textView.setText("Sem paises adicionados");




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                textView.setText("Sem paises adicionados");
            }
        });


    }


    private void criarButoesPais()
    {
        for(String id: listaIdPaises)
        {



            Button butaoPais = new Button(getApplicationContext());

            llLista.addView(butaoPais);

            butaoPais.setText(listaDePaises.get(id));


            butaoPais.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {



                    Intent i = new Intent(getApplicationContext(), com.example.projetoandroid.clubes.ListarUser.class);
                    i.putExtra("IdPais", id );
                    i.putExtra("nomePais" ,listaDePaises.get(id));
                    i.putExtra("username" ,username);
                    startActivity(i);


                }
            });
        }



    }



}
