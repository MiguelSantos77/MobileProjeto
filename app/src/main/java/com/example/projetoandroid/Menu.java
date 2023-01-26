package com.example.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projetoandroid.paises.Listar;
import com.example.projetoandroid.paises.ListarUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu extends AppCompatActivity {

    String username= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Intent in = getIntent();

        username = in.getStringExtra("username");






    }

    public void trocarParaPaisesListar(View v){

        Intent i = new Intent(getApplicationContext(), ListarUser.class);
        i.putExtra("username" ,username);
        startActivity(i);


    }




}