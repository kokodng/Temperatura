package org.izv.android.temperatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.izv.android.temperatura.contrato.ContratoTemperatura;

public class VistaPrincipal extends AppCompatActivity {

    private static final double T_INICIAL = 20.0;

    private double temperatura;
    private EditText etTemperatura;
    private TextView tvCelsius, tvFahrenheit;

    private double getCelsius() {
        return temperatura;
    }

    private double getFahrenheit() {
        return temperatura * 9.0 / 5.0 + 32.0;
    }

    private void init() {
        temperatura = T_INICIAL;
        etTemperatura = findViewById(R.id.etTemperatura);
        tvCelsius = findViewById(R.id.tvCelsius);
        tvFahrenheit = findViewById(R.id.tvFahrenheit);



        Button btCambia, btResta, btSuma;
        btCambia = findViewById(R.id.btCambia);
        btResta = findViewById(R.id.btResta);
        btSuma = findViewById(R.id.btSuma);
        showTemperatura();
        btCambia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = etTemperatura.getText().toString();
                try {
                    double valor = Double.parseDouble(cadena);
                    temperatura = valor;
                    showTemperatura();
                } catch (NumberFormatException e) {

                }
            }
        });
        btResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temperatura--;
                showTemperatura();
            }
        });
        btSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temperatura++;
                showTemperatura();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_principal);
        init();
    }

    private void setCelsius(double t) {
        temperatura = t;
    }

    private void setFahrenheit(double t) {
        temperatura = (temperatura - 32.0) * 5.0 / 9.0;
    }

    private void showTemperatura() {
        this.tvCelsius.setText(temperatura + "");
        this.tvFahrenheit.setText(getFahrenheit() + "");
    }
}
