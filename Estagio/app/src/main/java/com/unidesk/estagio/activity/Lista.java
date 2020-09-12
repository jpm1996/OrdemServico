package com.unidesk.estagio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.unidesk.estagio.R;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }

    public void sair(android.view.View view){
        Intent i = new Intent( Lista.this, MainActivity.class);
        startActivity( i );
    }

    public void adicionar(android.view.View view){
        Intent i = new Intent( Lista.this, Adicionaros.class);
        startActivity( i );
    }
}