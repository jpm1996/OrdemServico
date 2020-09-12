package com.unidesk.estagio.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.unidesk.estagio.R;
import com.unidesk.estagio.model.OrdemServico;


public class Adicionaros extends AppCompatActivity {

    private EditText campoNome, campoData, campoNposte, campoRua, campoBairro, campoNumerocasa, campoOutro;
    private Button botaoAdicionar, botaoCancelar;
    private CheckBox campoCheck1, campoCheck2, campoCheck3, campoCheck4, campoCheck5;

    private OrdemServico ordemservico;

    private String status;

    FirebaseFirestore db=FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionaros);

        InicializarComponentes();

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("salve", "clicou");

                String textoNome = campoNome.getText().toString();
                String textoData = campoData.getText().toString();
                String textoNposte = campoNposte.getText().toString();
                String textoRua = campoRua.getText().toString();
                String textoBairro = campoBairro.getText().toString();
                String textoOutro = campoOutro.getText().toString();
                String textoNumerocasa = campoNumerocasa.getText().toString();
                Boolean marcaCheck1 = campoCheck1.isChecked();
                Boolean marcaCheck2 = campoCheck2.isChecked();
                Boolean marcaCheck3 = campoCheck3.isChecked();
                Boolean marcaCheck4 = campoCheck4.isChecked();
                Boolean marcaCheck5 = campoCheck5.isChecked();

                if( !textoNome.trim().isEmpty()){
                    if( !textoData.trim().isEmpty()){
                        if( !textoNposte.trim().isEmpty()){
                            if( !textoRua.trim().isEmpty()){
                                if( !textoBairro.trim().isEmpty()){
                                    if( !textoNumerocasa.trim().isEmpty() ){
                                        if( marcaCheck1 || marcaCheck2 || marcaCheck3 || marcaCheck4 || marcaCheck5){

                                            ordemservico = new OrdemServico();
                                            ordemservico.setNome(textoNome);
                                            ordemservico.setData(textoData);
                                            ordemservico.setNposte(textoNposte);
                                            ordemservico.setRua(textoRua);
                                            ordemservico.setBairro(textoBairro);
                                            ordemservico.setNumerocasa(textoNumerocasa);
                                            ordemservico.setCheck1(marcaCheck1);
                                            ordemservico.setCheck2(marcaCheck2);
                                            ordemservico.setCheck3(marcaCheck3);
                                            ordemservico.setCheck4(marcaCheck4);
                                            ordemservico.setCheck5(marcaCheck5);
                                            ordemservico.setOutro(textoOutro);
                                            ordemservico.setStatus("Aberta");
                                            adicionar(ordemservico);
                                            Intent i = new Intent( Adicionaros.this, Lista.class);
                                            startActivity( i );
                                        }else{
                                            Toast.makeText(Adicionaros.this,"Preencha ao menos um problema!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else{
                                        Toast.makeText(Adicionaros.this,"Preencha o numero da casa!", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                   Toast.makeText(Adicionaros.this,"Preencha o bairro!", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(Adicionaros.this,"Preencha a rua!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Adicionaros.this,"Preencha o numero do poste!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Adicionaros.this,"Preencha a data!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Adicionaros.this,"Preencha o nome!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void adicionar ( OrdemServico ordemservico){

        db.collection("servicos").document().set(ordemservico);

    }

    public void InicializarComponentes(){

        campoNome = findViewById(R.id.adicionaros_nome);
        campoData = findViewById(R.id.adicionaros_data);
        campoNposte = findViewById(R.id.adicionaros_nposte);
        campoRua = findViewById(R.id.adicionaros_rua);
        campoBairro = findViewById(R.id.adicionaros_bairro);
        campoNumerocasa = findViewById(R.id.adicionaros_numerocasa);
        botaoAdicionar = findViewById(R.id.adicionaros_adicionar);
        botaoCancelar = findViewById(R.id.adicionaros_cancelar);
        campoCheck1 = findViewById(R.id.adicionaros_checkBox1);
        campoCheck2 = findViewById(R.id.adicionaros_checkBox2);
        campoCheck3 = findViewById(R.id.adicionaros_checkBox3);
        campoCheck4 = findViewById(R.id.adicionaros_checkBox4);
        campoCheck5 = findViewById(R.id.adicionaros_checkBox5);
        campoOutro = findViewById(R.id.adicionaros_outro);

    }



    public void cancelar(android.view.View view){
        Intent i = new Intent( Adicionaros.this, Lista.class);
        startActivity( i );
    }

    //public void adicionarview(android.view.View view){
      //  Intent i = new Intent( Adicionaros.this, Lista.class);
     //   startActivity( i );
    //}
}