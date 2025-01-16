package devandroid.macedo.applistacurso.view.view;

import static android.widget.Toast.LENGTH_LONG;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.macedo.applistacurso.R;
import devandroid.macedo.applistacurso.view.controller.PessoaController;
import devandroid.macedo.applistacurso.view.model.Pessoa;


public class MainActivity extends AppCompatActivity {


    PessoaController controller;
    Pessoa pessoa;

    EditText editNome;
    EditText editSobreome;
    EditText editCurso;
    EditText editNumero;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        pessoa = new Pessoa(MainActivity.this);
        controller.buscar(pessoa);

        editNome = findViewById(R.id.editNome);
        editSobreome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editNumero = findViewById(R.id.editNumero);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNome.setText(pessoa.getPrimeiroNome());
        editSobreome.setText(pessoa.getSobreNome());
        editCurso.setText(pessoa.getTelefoneContato());
        editNumero.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNome.setText("");
                editSobreome.setText("");
                editNumero.setText("");
                editCurso.setText("");
                controller.limpar(pessoa);

            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre", LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editNome.getText().toString());
                pessoa.setSobreNome(editSobreome.getText().toString());
                pessoa.setCursoDesejado(editCurso.getText().toString());
                pessoa.setTelefoneContato(editNumero.getText().toString());
                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), LENGTH_LONG).show();

                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

    }
}


// https://class.devsamurai.com.br/ baixar uns negocio