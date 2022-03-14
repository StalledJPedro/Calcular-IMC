package br.edu.unis.minhacnh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtMassa;
    EditText edtAltura;
    Button btnVerificar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoVerificar();
    }

    protected void carregaComponentes() {
        edtAltura = findViewById(R.id.edtAltura);
        edtMassa = findViewById(R.id.edtMassa);
        btnVerificar = findViewById(R.id.btnVerificarIdade);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoVerificar() {
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem= realizaCalculo();
                exibiResultado(mensagem);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        int massa = Integer.parseInt(edtMassa.getText().toString());
        int altura = Integer.parseInt(edtAltura.getText().toString());
        int resultado = massa / (altura * altura);
        String mensagem ="";

        if (resultado < 16) {
            mensagem = "Magreza Grave";
        }else
        if (resultado >= 16 && resultado <17){
            mensagem = "Magreza Moderada";
        }else
        if (resultado >= 17 && resultado <18.5){
            mensagem = "Magreza Leve";
        }else
        if (resultado >= 18.5 && resultado <25){
            mensagem = "Saudável";
        }else
        if (resultado >= 25 && resultado <30){
            mensagem = "Sobrepeso";
        }else
        if (resultado >= 30 && resultado < 35){
            mensagem = "Obesidade Grau 1";
        }else
        if (resultado >= 35 && resultado <40){
            mensagem = "Obesidade Grau 2";
        }else
        if (resultado >= 40){
            mensagem = "Obesidade Grau 3";
        }
        return mensagem;
    }

    protected void exibiResultado(String mensagem) {
        txtResultado.setText(mensagem);
    }

    protected void limpaCampos() {
        edtMassa.setText("");
        edtMassa.requestFocus();
        edtAltura.setText("");

    }
}