package ProyectoFinal;

import java.util.ArrayList;
import java.util.LinkedList;

public class TablaHash {

    private ArrayList<Palabra> listPalab;
    private ArrayList<LinkedList> tabla;

    public TablaHash(ArrayList<Palabra> listPalab) {
        this.listPalab = listPalab;
        this.tabla = new ArrayList<>(999);
        cargarTabla();
    }

    public void cargarTabla() {
        int cod;
        String pal;
        System.out.println(tabla.size());
        for (int i = 0; i < 999; i++) {
            LinkedList<String> list = new LinkedList<>();
            this.tabla.add(i, list);
        }
        for (int i = 0; i < listPalab.size(); i++) {
            cod = Integer.parseInt(listPalab.get(i).getCodFonetico().substring(1));
            pal = listPalab.get(i).getPalabra();
            this.tabla.get(cod).add(pal);
        }
    }

    public void printTabla() {
        for (int i = 0; i < this.tabla.size(); i++) {
            System.out.println("Codigo = " + i);
            System.out.println(this.tabla.get(i));
        }
    }

    public void buscarCod(int cod) {
        int tam = tabla.get(cod).size();
        for (int i = 0; i < tam; i++) {
            System.out.println(tabla.get(cod).get(i));
        }
        if (tam > 100) {
            System.out.println("Hay mucho que imprimir.");
        } else if (tam == 0) {
            System.out.println("No existe");
        }
    }

    public ArrayList<Palabra> getListPalab() {
        return listPalab;
    }

    public ArrayList<LinkedList> getTabla() {
        return tabla;
    }

    public void setListPalab(ArrayList<Palabra> listPalab) {
        this.listPalab = listPalab;
    }

    public void setTabla(ArrayList<LinkedList> tabla) {
        this.tabla = tabla;
    }

}

