package com.example.projetoandroid.jogadores;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projetoandroid.Login;
import com.example.projetoandroid.R;
import com.example.projetoandroid.Register;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JogadorDetalhe extends AppCompatActivity {

    String idJogador= null;
    String username= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogador_detalhe);



        Intent in = getIntent();

        idJogador = in.getStringExtra("IdJogador");
        username = in.getStringExtra("username");

    }









    public void trocarParaCriarAvalaicao(View v){


        Intent i = new Intent(getApplicationContext(), CriarAvaliacao.class);

        i.putExtra("IdJogador", idJogador );
        i.putExtra("username" ,username);
        startActivity(i);


    }
}

