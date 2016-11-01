package ProyectoFinal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Diccionario {

    private final Arbol arbol;
    private final Archivo archivo;
    private final ArrayList<Palabra> listPalab;
    private final TablaHash th;

    public Diccionario() {
        this.archivo = new Archivo();
        this.listPalab = archivo.leerTxt("C:\\Users\\Camilo Suaza\\Desktop\\txt\\words.txt");

        this.arbol = new Arbol();
        cargarArbol(this.listPalab);
        
        this.th = new TablaHash(this.listPalab);

    }

    public void printDiccionario() {
        for (int j = 0; j < getListPalab().size(); j++) {
            System.out.println(j + "               \t" + getListPalab().get(j).getPalabra() + "        \t" + getListPalab().get(j).getCodFonetico() + "        \t" + getListPalab().get(j).getNumBusqueda());
        }
    }

    private void cargarArbol(ArrayList<Palabra> listaPalabras) {
        Queue<Character> cola = new LinkedList<>();;
        for (Palabra x : listaPalabras) {
            for (int i = 0; i < x.getPalabra().length(); i++) {
                cola.add(x.getPalabra().charAt(i));
            }
            this.arbol.agregar(cola);
            cola.clear();
        }
    }
    
    

    public void buscarSufijo(String palBuscar) {
        ArrayList<String> palabEncontradas = getArbol().buscar(palBuscar);
        System.out.println("Palabra: " + palBuscar + ", Resultados:\n");
        if (palabEncontradas != null) {
            for (int i = 0; i < palabEncontradas.size(); i++) {
                System.out.println("   >> " + palabEncontradas.get(i));
            }
        } else {
            System.out.println("   >> No se encontraron sufijos esa palabra");
        }
    }

    public void buscarFonética(String palBuscar) {
        Palabra pal= new Palabra(palBuscar);
        Fonetica fon= new Fonetica();
        th.buscarCod(Integer.parseInt(fon.codigoFonetico(pal).substring(1)));
    }

    public Arbol getArbol() {
        return arbol;
    }

    public ArrayList<Palabra> getListPalab() {
        return listPalab;
    }

}

     

