package ar.com.lautaaro.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class testArchivos {

    public static void main(String[] args) {

        // Lista cargada por fuerza bruta!! 
        List<String> palabrasDeporte = new ArrayList<>();
        palabrasDeporte.add("Estadio");
        palabrasDeporte.add("\nJugadores");
        palabrasDeporte.add("\nTécnico");
        palabrasDeporte.add("\nUtilero");
        palabrasDeporte.add("\nPelota\n");

        String ruta = "PruebaArchivos.txt";
        funcionWriter(palabrasDeporte, ruta);
        funcionReader(ruta);
    }

    public static void funcionReader(String ruta) {
        try {
            FileReader lector = new FileReader(ruta);
            int c = lector.read();
            while (c != -1) {
                System.out.print((char) c);
                c = lector.read();
            }
            lector.close();
        } catch (IOException ex) {
            System.out.println("Error!!");
            ex.printStackTrace(System.out);
        }

    }

    public static void funcionWriter(List<String> lista, String ruta) {
        try {
            // No olvidar el true, sino se perdera la información si la hubiera en la ruta elegida.
            FileWriter escritor = new FileWriter(ruta, true);
            Date fecha = new Date();
            // Métodos del SimpleFormatDate..
            // dd -> Día
            // MM -> Mes
            // yyyy -> Año
            // DD -> Dias desde el inicio del año
            // mm -> minutos
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fechaTexto = sdf.format(fecha);
            escritor.write("-------------------------------------------\n");
            escritor.write("La fecha de hoy es: " + fechaTexto + "\n");
            escritor.write("-------------------------------------------\n");
            for (String e : lista) {
                escritor.write(e);
            }
            // Cerrar los archivos sino se utiliza ram.
            escritor.close();
        } catch (IOException ex) {
            System.out.println("Error!!");
            ex.printStackTrace(System.out);
        }

    }
}
