package com.example.projetoandroid.jogadores;

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

public class Listar extends AppCompatActivity {

    DatabaseReference databaseReference;

    List<String> listaIdJogadores;

    Map<String,String> listaJogadores = new HashMap<String, String>();

    String ultimoId = null ;
    String idClube = null;
    String nomeClube = null;
    Button butaocriar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem);


        Intent in = getIntent();

        idClube = in.getStringExtra("IdClube");
        nomeClube = in.getStringExtra("nomeClube");
        listaIdJogadores = new ArrayList<>();

        butaocriar = findViewById(butaoCriar);

        butaocriar.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                trocarParaJogadoresCriar();



            }
        });





        ListarJogadores();
    }



    TextView textView;
    LinearLayout llLista;


    public void ListarJogadores(){
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Jogadores");

        textView = findViewById(R.id.textViewPaises);

        llLista = findViewById(llContainer);




        textView.setText(nomeClube+ ": Jogadores" + idClube);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                if (snapshot.hasChildren()){

                    for (DataSnapshot snapshot1 : snapshot.getChildren()){

                        if (idClube.equals(snapshot1.child("idClube").getValue()))
                        {

                            listaIdJogadores.add(snapshot1.getKey());
                            listaJogadores.put(snapshot1.getKey(), snapshot1.child("nome").getValue().toString());
                            ultimoId=snapshot1.getKey();

                        }







                    }

                    criarButoesJogadores();


                }
                else
                    textView.setText(nomeClube+": Sem jogadores adicionados");




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                textView.setText(nomeClube +": Sem jogadores adicionados");
            }
        });


    }


    private void criarButoesJogadores()
    {

        for(String id: listaIdJogadores)
        {

            Button butaoJogador = new Button(getApplicationContext());
            Button eliminarJogador = new Button(getApplicationContext());




            llLista.addView(butaoJogador);
            llLista.addView(eliminarJogador);
            butaoJogador.setText(listaJogadores.get(id));
            eliminarJogador.setText("Eliminar " + listaJogadores.get(id));

            butaoJogador.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                }
            });

            eliminarJogador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  databaseReference.child(id).removeValue();

                    Intent intent = new Intent(getApplicationContext(), com.example.projetoandroid.paises.Listar.class);

                    startActivity(intent);
                }
            });


        }




    }


















    public void trocarParaJogadoresCriar(){



        Intent i = new Intent(getApplicationContext(), Criar.class);
        i.putExtra("ultimoId", ultimoId );
        i.putExtra("nomeClube", nomeClube);
        i.putExtra("idClube", idClube);
        startActivity(i);


    }







}
