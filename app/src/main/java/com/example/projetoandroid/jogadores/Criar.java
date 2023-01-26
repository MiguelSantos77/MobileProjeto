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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Criar extends AppCompatActivity{


    String  nomeClube , idClube;
    TextView textView;
    EditText edtJogador, edtPAC,edtDRI,edtSHO,edtDEF,edtPAS,edtPHY;
    String id;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogadores_criar);

        Intent in = getIntent();

        idClube = in.getStringExtra("idClube");
        nomeClube = in.getStringExtra("nomeClube");
        textView = findViewById(R.id.txtJogadorCriar);
        textView.setText("Criar Jogador para "+ nomeClube);




    }




    public void CriarJogador(View v){



        edtJogador = findViewById(R.id.edtJogadores);

        edtPAC = findViewById(R.id.edtPAC);
        edtDRI = findViewById(R.id.edtDRI);
        edtSHO = findViewById(R.id.edtSHO);
        edtDEF = findViewById(R.id.edtDEF);
        edtPAS = findViewById(R.id.edtPAS);
        edtPHY = findViewById(R.id.edtPHY);



        String nomeDoJogador= edtJogador.getText().toString();

        String PAC= edtPAC.getText().toString();
        String DRI= edtDRI.getText().toString();
        String SHO= edtSHO.getText().toString();
        String DEF= edtDEF.getText().toString();
        String PAS= edtPAS.getText().toString();
        String PHY= edtPHY.getText().toString();

        if(minMax(PAC) && minMax(DRI) && minMax(SHO) && minMax(DEF) && minMax(PAS) && minMax(PHY)){


            JogadorHelper jogadorHelper = new JogadorHelper(nomeDoJogador,idClube,PAC,DRI,SHO,DEF,PAS,PHY);


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

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("/Jogadores/" + id);

            databaseReference.setValue(jogadorHelper);




            Intent i = new Intent(getApplicationContext(), Listar.class);
            startActivity(i);

        }


    }


    public Boolean minMax(String a){
        int b = Integer.parseInt(a);

        if (b>=0 && b<=100){
            return true;
        }else {
            return false;
        }

    }



}
