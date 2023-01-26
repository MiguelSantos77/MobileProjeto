package com.example.projetoandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {



    FirebaseDatabase database;
    DatabaseReference reference;


    EditText edtnome, edtemail, edtpassword, edtconfimacaopassword;
    CheckBox checkBox;
    String  nome,email,password, passwordconf;
    String admin;

    Button btnRegistar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);



        edtemail = findViewById(R.id.editTextTextEmailAddress);
        edtnome = findViewById(R.id.edtNomeRegistar);


        edtpassword = findViewById(R.id.editTextTextPassword);
        edtconfimacaopassword = findViewById(R.id.editTextTextPassword2);
        btnRegistar = findViewById(R.id.btnRegistar);
        checkBox= findViewById(R.id.checkBox);
        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String email = edtemail.getText().toString();
                String username = edtnome.getText().toString();

                String password = edtpassword.getText().toString();
                String passwordconf = edtconfimacaopassword.getText().toString();
                if (edtpassword.getText().toString().equals(edtconfimacaopassword.getText().toString()));



                if (checkBox.isChecked()){
                    admin="1";
                }else {
                    admin="0";
                }


                if (password.equals(passwordconf)){

                    RegisterHelper registerHelper = new RegisterHelper( username,email, password, admin);

                    reference.child(username).setValue(registerHelper);
                  Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(Register.this, "ERRO", Toast.LENGTH_SHORT).show();

            }
        });
    }


}

