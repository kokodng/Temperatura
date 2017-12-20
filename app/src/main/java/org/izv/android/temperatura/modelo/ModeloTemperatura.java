package org.izv.android.temperatura.modelo;
// falta implementar el presentador para el lunes

import org.izv.android.temperatura.contrato.ContratoTemperatura;

public class ModeloTemperatura implements ContratoTemperatura.Modelo {
    private double celsius;

    @Override
    public double decCelsius() {
        return --celsius;
    }

    @Override
    public double getCelsius() {
        return celsius;
    }

    @Override
    public double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    @Override
    public double incCelsius() {
        return ++celsius;
    }

    @Override
    public void setCelsius(double temperatura) {
        celsius = temperatura;
    }

    @Override
    public void setFahrenheit(double temperatura) {
        celsius = (temperatura - 32.0) * 5.0 / 9.0;
    }
}
