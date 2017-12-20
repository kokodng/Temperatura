package org.izv.android.temperatura.contrato;

public interface ContratoTemperatura {
    interface Modelo {
        double decCelsius();

        double getCelsius();

        double getFahrenheit();

        double incCelsius();

        void setCelsius(double temperatura);

        void setFahrenheit(double temperatura);
    }

    interface Presentador {
        void decTemperature();

        void incTemperature();

        void temperatureChanged(double temperatura);
    }

    interface Vista {
        void showCelsius(double temperatura);

        void showFahrenheit(double temperatura);
    }
}
