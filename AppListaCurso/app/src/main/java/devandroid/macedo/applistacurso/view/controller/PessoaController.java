package devandroid.macedo.applistacurso.view.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.macedo.applistacurso.view.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
  //a
    public void salvar(Pessoa pessoa) {

        Log.i("MVC_CONTROLLER","COntroller Salva: "+pessoa.toString());

    }
}
