package org.izv.android.temperatura.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import org.izv.android.temperatura.R;
import org.izv.android.temperatura.contrato.ContratoTemperatura;
import org.izv.android.temperatura.presentador.PresentadorTemperatura;

public class VistaAlternativaMVP extends AppCompatActivity implements ContratoTemperatura.Vista {

    private final static String TAG = "xyzyx";
    private SeekBar sbCelsius, sbFahrenheit;
    private ContratoTemperatura.Presentador presentador;

    private void init() {
        sbCelsius = findViewById(R.id.sbCelsius);
        sbFahrenheit = findViewById(R.id.sbFahrenheit);
        // j
        presentador = new PresentadorTemperatura(this);

        sbCelsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.v(TAG, "valor " + i);
                presentador.temperatureChanged(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_alternativa_mvp);
        init();
    }

    @Override
    public void showCelsius(double temperatura) {
        sbCelsius.setProgress((int) temperatura);
    }

    @Override
    public void showFahrenheit(double temperatura) {
        sbFahrenheit.setProgress((int) temperatura);
    }
}
