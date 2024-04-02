package com.mycompany.editordibujo;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Archivo {

    //Metodo para mostrar una ventana que permita elegir un archivo mediante exploracion
    public static String elegirArchivo() {
        JFileChooser fc = new JFileChooser();

        if (fc.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            return f.getAbsolutePath();
        } else {
            return "";
        }
    }

    // Método estático para abrir archivos planos
    public static BufferedReader abrirArchivo(String nombreArchivo) {
        File f = new File(nombreArchivo);
        // Existe el archivo?
        if (f.exists()) {
            /*
             * captura de error estructurada. Intenta realizar la instrucción de
             * apertura del archivo. Es susceptible de no poder realizarse
             */
            try {
                /*
                 * Apertura del archivo plano La clase BufferedReader permite
                 * manipular secuencia de caracteres. La clase File ofrece
                 * funcionalidad para operar con archivos
                 */
                FileReader fr = new FileReader(f);
                return new BufferedReader(fr);
            } catch (IOException e) {
                /*
                 * Sucedió un error que se captura mediante la clase IOException
                 * encargada de manipular errores de entrada y salida
                 */
                return null;
            }
        } else {
            return null;
        }
    }//abrirArchivo

    // Método estático para guardar archivos planos dado un conjunto de líneas
    public static boolean guardarArchivo(String nombreArchivo, String[] lineas) {
        if (lineas != null) {
            /*
             * captura de error estructurada. Intenta realizar la instrucción de
             * escritura del archivo. Es susceptible de no poder realizarse
             */
            try {
                //Abrir el archivo para escritura
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
                for (int i = 0; i < lineas.length; i++) {
                    //Guardar cada linea
                    bw.write(lineas[i]);
                    bw.newLine();
                }
                //Cerrar el archivo
                bw.close();
                return true;
            } catch (IOException e) {
                /*
                 * Sucedió un error que se captura mediante la clase IOException
                 * encargada de manipular errores de entrada y salida
                 */
                return false;
            }
        } else {
            return false;
        }
    }
        public static boolean guardar(String nombreArchivo,JPanel pnlLienzo) {
    if (pnlLienzo != null) {
        String[] lineas = new String[2];
        
        int x1 = -1;
        int y1 = -1;
        
        Point position = pnlLienzo.getLocation();
        Dimension size = pnlLienzo.getSize();
        
        lineas[0] = "Position: " + position.x + ", " + position.y;
        lineas[1] = "Size: " + size.width + ", " + size.height;
        
        return Archivo.guardarArchivo(nombreArchivo, lineas);
    } else {
        return false;
    }
}
}
