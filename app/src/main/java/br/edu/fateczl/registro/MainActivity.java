package br.edu.fateczl.registro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {
    private EditText etNome, etCPF;
    private Button btnVerificar;
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
        etNome = findViewById(R.id.etNome);
        etCPF = findViewById(R.id.etCPF);
        btnVerificar = findViewById(R.id.btnVerificar);
        btnVerificar.setOnClickListener(op -> {
            verificar();
        });
    }
    private void verificar(){
        String nome = etNome.getText().toString();
        String cpf = etCPF.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("cpf", cpf);
        Intent i = new Intent(this, ResultadoActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
        }
    }
