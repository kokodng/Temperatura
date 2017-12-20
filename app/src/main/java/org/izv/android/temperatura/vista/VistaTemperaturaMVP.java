package org.izv.android.temperatura.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.izv.android.temperatura.contrato.ContratoTemperatura;
import org.izv.android.temperatura.R;
import org.izv.android.temperatura.presentador.PresentadorTemperatura;

public class VistaTemperaturaMVP extends AppCompatActivity implements ContratoTemperatura.Vista {

    private EditText etTemperatura;
    private TextView tvCelsius, tvFahrenheit;
    private ContratoTemperatura.Presentador presentador;

    private void init() {
        etTemperatura = findViewById(R.id.etTemperatura);
        tvCelsius = findViewById(R.id.tvCelsius);
        tvFahrenheit = findViewById(R.id.tvFahrenheit);

        presentador = new PresentadorTemperatura(this);
        // presnetador = new PresentadorTemperatura(VistaTemperaturaMVP.this);

        Button btCambia, btResta, btSuma;
        btCambia = findViewById(R.id.btCambia);
        btResta = findViewById(R.id.btResta);
        btSuma = findViewById(R.id.btSuma);

        btCambia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //presentador
                presentador.temperatureChanged(Double.parseDouble(etTemperatura.getText().toString()));
            }
        });
        btResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //presentador
                presentador.decTemperature();
            }
        });
        btSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //presentador
                presentador.incTemperature();
            }
        });
    }


    private void setCelsius(double t) {

    }

    private void setFahrenheit(double t) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_principal);
        init();
    }

    @Override
    public void showCelsius(double temperatura) {
        tvCelsius.setText(temperatura + "º Celsius");
    }

    @Override
    public void showFahrenheit(double temperatura) {
        tvFahrenheit.setText(temperatura + "º Fahrenheit");
    }

}