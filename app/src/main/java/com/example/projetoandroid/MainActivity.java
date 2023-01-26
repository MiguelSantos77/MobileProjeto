package com.example.projetoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projetoandroid.paises.Listar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        */








    }







    public void trocarParaRegister(View v){


        Intent i = new Intent(getApplicationContext(), Register.class);
        startActivity(i);


    }
    public void trocarParaLogin(View v){


        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);


    }
}