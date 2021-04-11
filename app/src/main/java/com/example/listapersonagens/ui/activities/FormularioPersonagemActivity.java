package com.example.listapersonagens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listapersonagens.R;
import com.example.listapersonagens.dao.PersonagemDAO;
import com.example.listapersonagens.model.Personagem;

import java.io.Serializable;

public class FormularioPersonagemActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoAltura;
    private EditText campoNascimento;
    private final PersonagemDAO dao = new PersonagemDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);
        setTitle("Formulário de Personagens"); //título ao ir para o formulário
        //vincula as informações das variáveis no meu formulário com os objetos dentro do xml
        campoNome = findViewById(R.id.edittext_nome);
        campoAltura= findViewById(R.id.edittext_altura);
        campoNascimento = findViewById(R.id.edittext_nascimento);
        //botão para adicionar o personagem na lista
        Button botaoSalvar = findViewById(R.id.button_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //ao clicar no botão, guardará as informações nas variáveis, dentro do meu onClick em cada um dos campos
                String nome = campoNome.getText().toString(); //pega a variável nome e com o getText, pegará a informação passada dentro desse campo
                String altura = campoAltura.getText().toString();
                String nascimento = campoNascimento.getText().toString();

                //criação de um construtor para armazenar as variáveis locais de forma mais segura
                Personagem personagemSalvo = new Personagem(nome, altura, nascimento);

                dao.salvar(personagemSalvo);
                finish(); //não fica voltando na informação, matando o ciclo de activity e parando na lista

                //startActivity(new Intent(FormularioPersonagemActivity.this, ListaPersonagemActivity.class));

                /*Toast.makeText(FormularioPersonagemActivity.this,
                        personagemSalvo.getNome() + " - " +
                                personagemSalvo.getAltura() + " - " +
                                personagemSalvo.getNascimento(), Toast.LENGTH_SHORT).show();
*/
               // new Personagem(nome, altura, nascimento);

                //modifiCcando as informações
                personagemSalvo.setNome(nome);
                personagemSalvo.setAltura(altura);
                personagemSalvo.setNascimento(nascimento);
                dao.editar(personagemSalvo);

                //Toast.makeText(FormularioPersonagemActivity.this,"Estou Funcionando!",Toast.LENGTH_SHORT).show();

                Intent dados = getIntent();
                Personagem personagem = (Personagem) dados.getSerializableExtra("personagem");
                campoNome.setText(personagem.getNome());
                campoAltura.setText(personagem.getAltura());
                campoNascimento.setText(personagem.getNascimento());



            }
        });
    }


    }
