package com.unidesk.estagio.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.unidesk.estagio.Informacaodialog.InformacaoDialog;
import com.unidesk.estagio.model.OrdemServico;

import java.util.ArrayList;

public class Lista extends AppCompatActivity implements View.OnClickListener{

    private AlertDialog alert;
    InformacaoDialog info;
    private Context context;

    FirebaseFirestore db=FirebaseFirestore.getInstance();


    private ListView lista_Listview;
    private ArrayList<OrdemServico> listaordem = new ArrayList<OrdemServico>();
    private OrdemServico item;
    private ArrayAdapter<OrdemServico> adapterOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.unidesk.estagio.R.layout.activity_lista);

        db.collection("servicos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document : task.getResult()){
                        Log.i("alooo", document.getId()+" -> "+document.getData());
                        item = new OrdemServico();
                        item.setNome(document.getString("nome"));
                        item.setData(document.getString("data"));
                        item.setNposte(document.getString("nposte"));
                        item.setRua(document.getString("rua"));
                        item.setBairro(document.getString("bairro"));
                        item.setNumerocasa(document.getString("numerocasa"));
                        item.setStatus(document.getString("status"));
                        item.setSolucao(document.getString("solucao"));
                        item.setDataFechamento(document.getString("dataFechamento"));
                        item.setOutro(document.getString("outro"));
                        item.setCheck1(document.getBoolean("check1"));
                        item.setCheck2(document.getBoolean("check2"));
                        item.setCheck3(document.getBoolean("check3"));
                        item.setCheck4(document.getBoolean("check4"));
                        item.setCheck5(document.getBoolean("check5"));
                        listaordem.add(item);
                    }
                    atualizarLista();
                }else{
                    Log.w("erro", "erro recuperado", task.getException());
                }
            }
        });



    }

    public void atualizarLista(){
        lista_Listview = (ListView) findViewById(com.unidesk.estagio.R.id.lista_Listview);
        adapterOS = new ArrayAdapter<OrdemServico>(this, android.R.layout.simple_list_item_1, listaordem);
        lista_Listview.setAdapter(adapterOS);
        lista_Listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              OrdemServico valorSelecionado = (OrdemServico) lista_Listview.getItemAtPosition(position);
                if (valorSelecionado.getStatus().toString().equals("Fechada") ){
                 Toast.makeText(getApplicationContext(), "Ordem de servico ja esta fechada!!", Toast.LENGTH_LONG) .show();
             }
                else{

                    chamarAlert(valorSelecionado.getRua(), valorSelecionado.getNposte());
                    adapterOS.notifyDataSetChanged();

                }
            }
         });

        adapterOS.notifyDataSetChanged();
    }

    public void chamarAlert(String rua, String poste){
        info = new InformacaoDialog(this, rua , poste);
        info.show();
    }

    public void sair(android.view.View view){
        Intent i = new Intent( Lista.this, MainActivity.class);
        startActivity( i );
    }

    public void adicionar(android.view.View view){
        Intent i = new Intent( Lista.this, Adicionaros.class);
        startActivity( i );
    }

    @Override
    public void onClick(View v) {

    }

}