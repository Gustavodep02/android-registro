package br.edu.fateczl.registro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:<Gustavo de Paula>
 */
public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvSaida = findViewById(R.id.tvSaida);
        tvSaida.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String cpf = bundle.getString("cpf");
        String nome = bundle.getString("nome");
        char local = cpf.charAt(8);
        switch(local){
            case '1':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins");
                break;
            case '2':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Pará, Amazonas, Acre, Amapá, Rondônia e Roraima");
                break;
            case '3':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Ceará, Maranhão e Piauí");
                break;
            case '4':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Pernambuco, Rio Grande do Norte, Paraíba e Alagoas");
                break;
            case '5':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Bahia e Sergipe");
                break;
            case '6':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Minas Gerais");
                break;
            case '7':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Rio de Janeiro e Espírito Santo");
                break;
            case '8':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: São Paulo");
                break;
            case '9':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Paraná e Santa Catarina");
                break;
            case '0':
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Rio Grande do Sul");
                break;
            default:
                tvSaida.setText("Cpf: "+cpf+"\nNome: "+nome+"\nLocal: Cpf inválido");
                break;
        }

        btnVoltar.setOnClickListener(op -> {
            Intent i = new Intent(this, MainActivity.class);
            this.startActivity(i);
            this.finish();
        });

    }
}