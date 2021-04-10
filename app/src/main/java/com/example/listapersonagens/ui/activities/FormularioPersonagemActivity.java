package com.example.listapersonagens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listapersonagens.R;
import com.example.listapersonagens.model.Personagem;

public class FormularioPersonagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);

       //vincula as informações das variáveis no meu formulário com os objetos dentro do xml
        EditText campoNome = findViewById(R.id.edittext_nome);
        EditText campoAltura= findViewById(R.id.edittext_altura);
        EditText campoNascimento = findViewById(R.id.edittext_nascimento);

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


                Toast.makeText(FormularioPersonagemActivity.this,
                        personagemSalvo.getNome() + " - " +
                                personagemSalvo.getAltura() + " - " +
                                personagemSalvo.getNascimento(), Toast.LENGTH_SHORT).show();

                new Personagem(nome, altura, nascimento);

                //Toast.makeText(FormularioPersonagemActivity.this,"Estou Funcionando!",Toast.LENGTH_SHORT).show();


            }
        });


    }
}