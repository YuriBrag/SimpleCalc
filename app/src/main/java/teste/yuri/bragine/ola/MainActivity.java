package teste.yuri.bragine.ola;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        Button botaoSoma = findViewById(R.id.buttonSum);
        Button botaoSubtracao = findViewById(R.id.buttonSub);
        Button botaoMultiplicacao = findViewById(R.id.buttonMult);
        Button botaoDivisao = findViewById(R.id.buttonDiv);

        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("+");
            }
        });

        botaoSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("-");
            }
        });

        botaoMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("*");
            }
        });

        botaoDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("/");
            }
        });
    }

    private void realizarOperacao(String operacao) {
        String textoValor1 = num1.getText().toString();
        String textoValor2 = num2.getText().toString();

        if (!textoValor1.isEmpty() && !textoValor2.isEmpty()) {
            double valor1 = Double.parseDouble(textoValor1);
            double valor2 = Double.parseDouble(textoValor2);
            double finalResult = 0;

            switch (operacao) {
                case "+":
                    finalResult = valor1 + valor2;
                    break;
                case "-":
                    finalResult = valor1 - valor2;
                    break;
                case "*":
                    finalResult = valor1 * valor2;
                    break;
                case "/":
                    if (valor2 == 0) {
                        result.setText("Operação inválida: Divisão por zero");
                        return;
                    } else {
                        finalResult = valor1 / valor2;
                    }
                    break;
                default:
                    break;
            }

            result.setText("O Resultado é: " + finalResult);
        } else {
            result.setText("Por favor, preencha com numeros validos");
        }
    }
}