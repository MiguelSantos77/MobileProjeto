package com.example.projetoandroid.clubes;

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

    List<String> listaIdClubes;

    Map<String,String> listaDeClubes = new HashMap<String, String>();

    String ultimoId = null;
    String idPais = null;
    String nomePais = null;
    Button butaocriar;
    String username = null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_user);





        Intent in = getIntent();

        idPais = in.getStringExtra("IdPais");
        nomePais = in.getStringExtra("nomePais");
        username = in.getStringExtra("username");
        listaIdClubes = new ArrayList<>();



        ListarClubes();
    }



    TextView textView;
    LinearLayout llLista;

    public void ListarClubes(){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Clubes");

        textView = findViewById(R.id.textViewPaises);

        llLista = findViewById(llContainer);


        textView.setText(nomePais+ ": Clubes");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                if (snapshot.hasChildren()){



                    for (DataSnapshot snapshot1 : snapshot.getChildren()){



                        if (idPais.equals(snapshot1.child("idPais").getValue()))
                        {

                            listaIdClubes.add(snapshot1.getKey());
                            listaDeClubes.put(snapshot1.getKey(), snapshot1.child("nome").getValue().toString());
                            ultimoId=snapshot1.getKey();

                        }



                    }

                    criarButoesClubes();


                }
                else
                    textView.setText(nomePais+": Sem clubes adicionados");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                textView.setText(nomePais +": Sem clubes adicionados");
            }
        });


    }


    private void criarButoesClubes()
    {

        for(String id: listaIdClubes)
        {

            Button butaoClube = new Button(getApplicationContext());

            llLista.addView(butaoClube);
            butaoClube.setText(listaDeClubes.get(id));


            butaoClube.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {


                    Intent i = new Intent(getApplicationContext(), com.example.projetoandroid.jogadores.ListarUser.class);
                    i.putExtra("IdClube", id );
                    i.putExtra("nomeClube" ,listaDeClubes.get(id));
                    i.putExtra("username" ,username);
                    startActivity(i);


                }
            });


        }




    }










}
