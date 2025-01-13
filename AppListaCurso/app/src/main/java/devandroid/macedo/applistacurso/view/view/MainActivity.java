package devandroid.macedo.applistacurso.view.view;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.macedo.applistacurso.R;
import devandroid.macedo.applistacurso.view.model.Pessoa;


public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

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

        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("Ygor");
        pessoa.setSobreNome("Macedo");
        pessoa.setCursoDesejado("Android Java/Kotlin");
        pessoa.setTelefoneContato("11947578682");

        Log.i("Exibir: ","Nome: "+pessoa.getPrimeiroNome());
        Log.i("Exibir: ","Nome: "+pessoa.getSobreNome());
        Log.i("Exibir: ","Nome: "+pessoa.getCursoDesejado());
        Log.i("Exibir: ","Nome: "+pessoa.getTelefoneContato());


    }
}