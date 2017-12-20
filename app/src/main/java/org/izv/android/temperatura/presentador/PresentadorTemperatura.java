package org.izv.android.temperatura.presentador;

import org.izv.android.temperatura.contrato.ContratoTemperatura;
import org.izv.android.temperatura.modelo.ModeloTemperatura;

public class PresentadorTemperatura implements ContratoTemperatura.Presentador {

    private ContratoTemperatura.Modelo modelo;
    private ContratoTemperatura.Vista vista;

    public PresentadorTemperatura(ContratoTemperatura.Vista vista) {
        this.vista = vista;
        this.modelo = new ModeloTemperatura();
    }

    /* Funcionamiento
    * 1. La vista llama al presentador
    * 2. El presentador utiliza al modelo
    * 3. El presentador envía la respuesta a la vista
    * */

    @Override
    public void decTemperature() {
        modelo.decCelsius();
        vista.showCelsius(modelo.getCelsius());
        vista.showFahrenheit(modelo.getFahrenheit());
    }

    @Override
    public void incTemperature() {
        modelo.incCelsius();
        vista.showCelsius(modelo.getCelsius());
        vista.showFahrenheit(modelo.getFahrenheit());
    }

    @Override
    public void temperatureChanged(double temperatura) {
        modelo.setCelsius(temperatura);
        vista.showCelsius(modelo.getCelsius());
        vista.showFahrenheit(modelo.getFahrenheit());
    }
}
