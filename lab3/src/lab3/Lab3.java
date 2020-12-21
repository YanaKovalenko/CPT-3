/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.io.*;
/**
 *
 * @author Яна
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File audio3var = new File(".\\3.bin");
        BufferedReader redaudio3var = new BufferedReader(new FileReader(audio3var));
        char[] buffer = new char[(int)audio3var.length()];
        redaudio3var.read(buffer);
        audio audio = new audio(buffer);
        System.out.println("Энергия: " + audio.Energy_audio());
        System.out.println("Средняя мощность: " + audio.Average_power());
        System.out.println("Среднее значение отсчетов: " + audio.Average_reading());
        System.out.println("Дисперсия значений отсчетов: " + audio.Dispersion());
        System.out.println("Функция автокорреляции: "+audio.Autocorrelation_function(3));

    }
    
}
