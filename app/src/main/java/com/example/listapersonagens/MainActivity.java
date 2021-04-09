
package com.example.listapersonagens;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //criação da classe Main
@Override
  protected void onCreate(Bundle savedInstancesState){
  super.onCreate(savedInstancesState);
  setContentView(R.layout.activity_main);
  List<String> personagem = new ArrayList<>(Arrays.asList("Alex","Ken", "Ryu","Guile")); //criação de uma lista com o nome dos personagens

  ListView listaDePersonagens = findViewById(R.id.activity_main_lista_personagem); //pega a lista através do id
listaDePersonagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personagem));


       /* TextView primeiroPersonagem = findViewById(R.id.textView); //
        TextView segundoPersonagem = findViewById(R.id.textView2);
        TextView terceiroPersonagem = findViewById(R.id.textView3);

        primeiroPersonagem.setText(personagem.get(0));
        segundoPersonagem.setText(personagem.get(1));
        terceiroPersonagem.setText(personagem.get(2));*/
}
  }