/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author Яна
 */
public class audio {
    char[] audio;

    public audio(char[] buffer) {
        audio = buffer;
    }

    //энергия=сумма (Si-й 2 степени),где i(0...N-1); Si-отсчет цифрового сигнала;
    public int Energy_audio() {
        int energy_audio = 0;
        for (int i = 0; i < audio.length; i++) {
            energy_audio = energy_audio + audio[i] * 2;
        }
        return energy_audio;
    }

    //средняя мощность=сумма (Si-й 2 степени),где i(0...N-1)/N; Si-отсчет цифрового сигнала);
    public int Average_power() {
        int average_power = Energy_audio() / audio.length;
        return average_power;
    }

    // среднее значение отсчетов=сумма (Si-й ), где i(0...N-1) Si-отсчет цифрового сигнала)/N;
    public double Average_reading() {
        double average_reading = 0;
        for (int i = 0; i < audio.length; i++) {
            average_reading = average_reading + audio[i];
        }
        return average_reading / audio.length;
    }

    // дисперсия=сумма ((Si-й-Ms)2 степени) , где i(0...N-1) Si-отсчет цифрового сигнала)/N;
    public double Dispersion() {
        double dispersion = 0;
        double average_reading = Average_reading();
        for (int i = 0; i < audio.length; i++) {
            dispersion = dispersion + (audio[i] - average_reading) * (audio[i] - average_reading);
        }
        return dispersion / audio.length;
    }
    //функция автокорреляции  =сумма ((S(i-t)-Ms)*(Si-Ms)) , где i(0...N-t-1) Si-отсчет цифрового сигнала)/N;
    //функция автокорреляции =сумма ((S(i+t)-Ms)*(Si-Ms)) , где i(0...N+t-1) Si-отсчет цифрового сигнала)/N;
    public double Autocorrelation_function(int t) {
        double autocorrelation_function = 0;
        double average_reading = Average_reading();
        if (t < 0) {
            for (int i = 0; i < audio.length + t; i++) {
                autocorrelation_function = autocorrelation_function + (audio[(i - (int) t)] - average_reading) * (audio[i] - average_reading);
            }
            autocorrelation_function /= (audio.length + t);
        } else {
            for (int i = 0; i < audio.length - t; i++) {
                autocorrelation_function = autocorrelation_function + (audio[(i + (int) t)] - average_reading) * (audio[i] - average_reading);
            }
            autocorrelation_function /= (audio.length - t);
        }
        return autocorrelation_function;
    }

    public double Correlation_interval()
    {
        double correlation_interval=0;
        double k=Autocorrelation_function(3);
        for (int i=0;i<audio.length;i++){
            correlation_interval+=k;
        }
        return correlation_interval/k;
    }

}
