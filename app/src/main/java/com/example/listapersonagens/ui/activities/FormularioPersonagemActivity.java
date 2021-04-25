package com.example.listapersonagens.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listapersonagens.R;
import com.example.listapersonagens.dao.PersonagemDAO;
import com.example.listapersonagens.model.Personagem;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import static com.example.listapersonagens.ui.activities.ContantesActivities.CHAVE_PERSONAGEM;

public class FormularioPersonagemActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR_EDITAR_PERSONAGEM = "Editar Personagem";
    public static final String TITULO_APP_BAR_NOVO_PERSONAGEM = "Novo Personagem";
    private EditText campoNome;
    private EditText campoAltura;
    private EditText campoNascimento;
    private final PersonagemDAO dao = new PersonagemDAO();
    private Personagem personagem;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_formulario_personagem_menu_salvar, menu);
    return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
    if(itemId == R.id.activity_formulario_personagem_menu_salvar){finalizarFormulario();
    }
    return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);
        inicializacaoCampos();//refatoração
        configuraBotaoSalvar();//refatoração
        carregaPersonagem();//refatoração
    }
    private void carregaPersonagem() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_PERSONAGEM)) {
            setTitle(TITULO_APP_BAR_EDITAR_PERSONAGEM); //título ao ir para o formulário
            personagem = (Personagem) dados.getSerializableExtra(CHAVE_PERSONAGEM);
            preencheCampos();
        } else {
            setTitle(TITULO_APP_BAR_NOVO_PERSONAGEM);
            personagem = new Personagem();

        }
    }

    private void preencheCampos() {
        campoNome.setText(personagem.getNome());
        campoAltura.setText(personagem.getAltura());
        campoNascimento.setText(personagem.getNascimento());
    }

    private void configuraBotaoSalvar() {//botão para adicionar o personagem na lista
        Button botaoSalvar = findViewById(R.id.button_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizarFormulario();
            }
        });
    }

    private void finalizarFormulario() {
        preencherPersonagem();
        if (personagem.IdValido()) {
            dao.editar(personagem);
            finish();
        } else {
            dao.salvar(personagem);
        }
        finish();
    }

    private void inicializacaoCampos() {
        //vincula as informações das variáveis no meu formulário com os objetos dentro do xml
        campoNome = findViewById(R.id.edittext_nome);
        campoAltura = findViewById(R.id.edittext_altura);
        campoNascimento = findViewById(R.id.edittext_nascimento);
        //máscaras
        SimpleMaskFormatter smfAltura = new SimpleMaskFormatter("N,NN");
        MaskTextWatcher mtwAltura = new MaskTextWatcher(campoAltura, smfAltura);
        campoAltura.addTextChangedListener(mtwAltura);

        SimpleMaskFormatter smfNascimento = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwNascimento = new MaskTextWatcher(campoNascimento, smfNascimento);
        campoNascimento.addTextChangedListener(mtwNascimento);

    }

    private void preencherPersonagem() {
        String nome = campoNome.getText().toString(); //pega a variável nome e com o getText, pegará a informação passada dentro desse campo
        String nascimento = campoNascimento.getText().toString();
        String altura = campoAltura.getText().toString();

        personagem.setNome(nome);
        personagem.setAltura(altura);
        personagem.setNascimento(nascimento);
    }


}
