package com.example.projetoandroid.jogadores;




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
import com.example.projetoandroid.paises.ListarUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CriarAvaliacao extends AppCompatActivity{


    String idJogador, username;
    EditText  edtPAC,edtDRI,edtSHO,edtDEF,edtPAS,edtPHY;
    String id;
    TextView tvNomeDoJogador;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avaliacao_criar);



        Intent in = getIntent();

        idJogador = in.getStringExtra("IdJogador");
        username = in.getStringExtra("username");




    }




    public void CriarAvaliacao(View v){



        tvNomeDoJogador = findViewById(R.id.tvNomeDoJogador);

        edtPAC = findViewById(R.id.edtPAC);
        edtDRI = findViewById(R.id.edtDRI);
        edtSHO = findViewById(R.id.edtSHO);
        edtDEF = findViewById(R.id.edtDEF);
        edtPAS = findViewById(R.id.edtPAS);
        edtPHY = findViewById(R.id.edtPHY);




        String PAC= edtPAC.getText().toString();
        String DRI= edtDRI.getText().toString();
        String SHO= edtSHO.getText().toString();
        String DEF= edtDEF.getText().toString();
        String PAS= edtPAS.getText().toString();
        String PHY= edtPHY.getText().toString();

        //descobrir ultimo ID

        AvaliacaoHelper avaliacaoHelper = new AvaliacaoHelper(username,idJogador,PAC,DRI,SHO,DEF,PAS,PHY);


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

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("/Avaliacao/" + id);

        databaseReference.setValue(avaliacaoHelper);


        Intent i = new Intent(getApplicationContext(), ListarUser.class);
        startActivity(i);

    }




}
