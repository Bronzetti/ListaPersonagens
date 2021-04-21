


package com.example.listapersonagens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listapersonagens.R;
import com.example.listapersonagens.dao.PersonagemDAO;
import com.example.listapersonagens.model.Personagem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static com.example.listapersonagens.ui.activities.ContantesActivities.CHAVE_PERSONAGEM;


public class ListaPersonagemActivity extends AppCompatActivity {

  public static final String TITULO_APPBAR = "Lista de Personagens";  //criação da classe Main
  private final PersonagemDAO dao = new PersonagemDAO();

  @Override
  protected void onCreate(Bundle savedInstancesState) {
    super.onCreate(savedInstancesState);
    setContentView(R.layout.activity_lista_personagem);
    setTitle(TITULO_APPBAR); //título ao entrar na lista de personagens
    configuraFabNovoPersonagem();

  }

  private void configuraFabNovoPersonagem() {
    FloatingActionButton botaoNovoPersonagem = findViewById(R.id.fab_add);//botão que leva da lista para o formulário
    botaoNovoPersonagem.setOnClickListener(new View.OnClickListener() {//chamar ação do botão
      @Override
      public void onClick(View v) { //toda vez que apertar o fab irá direto para o formulário
        abreFormulario();
      }
    });
  }

  private void abreFormulario() {
    startActivity(new Intent(this, FormularioPersonagemActivity.class));
  }

  @Override
  protected void onResume() {
    super.onResume();

    ListView listaDePersonagens = findViewById(R.id.activity_main_lista_personagem); //pega a lista através do id
    final List<Personagem> personagens = dao.todos();
    listaDePersonagens(listaDePersonagens, personagens);

    configuraItemPorClique(listaDePersonagens);
  }

  private void configuraItemPorClique(ListView listaDePersonagens) {
    listaDePersonagens.setOnItemClickListener(new AdapterView.OnItemClickListener() {//seleciona personagem
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) { //superclasse onItemClick
        Personagem personagemEscolhido = (Personagem) adapterView.getItemAtPosition(posicao);
        abreFormularioEditar(personagemEscolhido);
      }
    });
  }

  private void abreFormularioEditar(Personagem personagemEscolhido) {
    Intent vaiParaoFormulario = new Intent(ListaPersonagemActivity.this, FormularioPersonagemActivity.class);  //intent para abrir meu formulário
    vaiParaoFormulario.putExtra(CHAVE_PERSONAGEM, personagemEscolhido);//grava o nome ao clicar nele
    startActivity(vaiParaoFormulario);
  }

  private void listaDePersonagens(ListView listaDePersonagens, List<Personagem> personagens) {
    listaDePersonagens.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personagens));
  }
}