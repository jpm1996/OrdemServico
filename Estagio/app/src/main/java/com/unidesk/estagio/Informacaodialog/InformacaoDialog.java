package com.unidesk.estagio.Informacaodialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.unidesk.estagio.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class InformacaoDialog extends Dialog {

    private EditText editTextSolucao;
    private EditText editTextSenha;
    private String status, senha, rua, poste, id;
    public Activity c;


    FirebaseFirestore db=FirebaseFirestore.getInstance();

    public InformacaoDialog(Activity activity, String rua, String poste) {
            super(activity);
            this.c = activity;
            this.rua = rua;
            this.poste = poste;
    }

 public void load() {
     db.collection("servicos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
         @Override
         public void onComplete(@NonNull Task<QuerySnapshot> task) {
             if(task.isSuccessful()){
                 for(QueryDocumentSnapshot document : task.getResult()){
                     if(document.getString("rua").equals(rua) && document.getString("nposte").equals(poste))
                     {
                         id = document.getId();
                     }
                 }
             }else{
                 Log.w("erro", "erro recuperado", task.getException());
             }
         }
     });
 }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_informacao);
        editTextSolucao = findViewById(R.id.editTextSolucao);
        editTextSenha = findViewById(R.id.editTextSenha);

        Button buttonAdicionar = findViewById(R.id.buttonAdicionar);
        Button buttonCancelar = findViewById(R.id.buttonCancelar);
        load();


        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        // btn adicionar
        buttonAdicionar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                status = editTextSolucao.getText().toString();
                senha = editTextSenha.getText().toString();


                if(!senha.equals("1234")){
                    dismiss();
                    Toast.makeText(getContext(), "Senha Invalida!!", Toast.LENGTH_LONG) .show();
                }else {
                    Date dataHoraAtual = new Date();
                    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);

                    DocumentReference washingtonRef = db.collection("servicos").document(id.toString());
                    washingtonRef
                            .update("status", "Fechada", "solucao", status.toString(), "dataFechamento", data)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "DocumentSnapshot successfully updated!");

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error updating document", e);
                                }
                            });
                    c.recreate();
                    dismiss();
                    Toast.makeText(getContext(), "Ordem de serviço finalizada!!", Toast.LENGTH_LONG) .show();
                }


            }
        });

        }


}