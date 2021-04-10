
package com.example.listapersonagens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listapersonagens.R;
import com.example.listapersonagens.dao.PersonagemDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListaPersonagemActivity extends AppCompatActivity {
    //criação da classe Main
@Override
  protected void onCreate(Bundle savedInstancesState){
  super.onCreate(savedInstancesState);
  setContentView(R.layout.activity_lista_personagem);
  setTitle("Lista de Personagens"); //título ao entrar na lista de personagens

  PersonagemDAO dao = new PersonagemDAO();

  //List<String> personagem = new ArrayList<>(Arrays.asList("Alex","Ken", "Ryu","Guile")); //criação de uma lista com o nome dos personagens

  FloatingActionButton botaoNovoPersonagem = findViewById(R.id.fab_add);//botão que leva da lista para o formulário
  botaoNovoPersonagem.setOnClickListener(new View.OnClickListener() {//chamar ação do botão
    @Override
    public void onClick(View v) { //toda vez que apertar o fab irá direto para o formulário
       startActivity(new Intent(ListaPersonagemActivity.this, FormularioPersonagemActivity.class));
    }
  });

  ListView listaDePersonagens = findViewById(R.id.activity_main_lista_personagem); //pega a lista através do id
  listaDePersonagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));

       /* TextView primeiroPersonagem = findViewById(R.id.textView); //
        TextView segundoPersonagem = findViewById(R.id.textView2);
        TextView terceiroPersonagem = findViewById(R.id.textView3);

        primeiroPersonagem.setText(personagem.get(0));
        segundoPersonagem.setText(personagem.get(1));
        terceiroPersonagem.setText(personagem.get(2));*/
}
  }