package ProyectoFinal;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    public Archivo() {
    }

    public ArrayList<Palabra> leerTxt(String direccion) {

        Fonetica f = new Fonetica();
        ArrayList<Palabra> listPalab = new ArrayList<>();
        boolean band = false;
        try {
            BufferedReader leer = new BufferedReader(new FileReader(direccion));

            while (leer.readLine() != null) {
                String palab = leer.readLine();
                Palabra a = new Palabra(palab);
                a.setCodFonetico(f.codigoFonetico(a));
                listPalab.add(a);
            }
        } catch (Exception e) {
            if (band) {
                System.out.println("Problemas al cargar txt");
            }
            band = true;
        }

        return listPalab;
    }

}
