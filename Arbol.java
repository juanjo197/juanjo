package ProyectoFinal;

import java.util.*;

public class Arbol {

    private ArrayList<Nodo> raiz;
    private ArrayList<String> palabrasEncontradas;

    public Arbol() {
        this.raiz = new ArrayList<>();
        this.palabrasEncontradas = new ArrayList<>();
    }
    
    public void agregar(Queue<Character> palab){
        ArrayList <Nodo> auxRaiz = getRaiz();
        Nodo auxNodo;
        
        while (!palab.isEmpty()) {
            Nodo let = new Nodo(palab.poll());
            if(palab.isEmpty()) let.setEsFinal(true);
            
            ArrayList<Character> search = new ArrayList<>();
            for (int i = 0; i < auxRaiz.size(); i++) {
                search.add(auxRaiz.get(i).getDato());
            }

            if (!search.contains(let.getDato()))auxRaiz.add(let);
            
            int index = 0;
            for (int i = 0; i < auxRaiz.size(); i++) {
                if (auxRaiz.get(i).getDato() == let.getDato()) {
                    index = i;
                    break;
                }
            }

            auxNodo = auxRaiz.get(index);
            auxRaiz = auxNodo.getHijos();
            search.clear();
        }
    }
    
    public ArrayList<String> buscar(String pal) {
        this.palabrasEncontradas.clear();
        Queue<Character> cola = new LinkedList<>();
        for (int i = 0; i < pal.length(); i++) {
            cola.add(pal.charAt(i));
        }

        Nodo here = arrancarDe(cola);

        if (here != null) {
            printInOrden(here, pal.substring(0,pal.length()-1));
            System.out.println("Las palabras que encontré son:");
            /*for (int i = 0; i < getPalabrasEncontradas().size(); i++) {
                System.out.println(getPalabrasEncontradas().get(i));
            }*/
            return getPalabrasEncontradas();
        }
        return null;
    }
    
    private Nodo arrancarDe(Queue<Character> palab) {
        ArrayList<Nodo> auxRaiz = getRaiz();
        Nodo auxNodo = null;

        while (!palab.isEmpty()) {
            Nodo let = new Nodo(palab.poll());

            ArrayList<Character> search = new ArrayList<>();
            for (int i = 0; i < auxRaiz.size(); i++) {
                search.add(auxRaiz.get(i).getDato());
            }

            if (!search.contains(let.getDato())) {
                return null;
            }

            auxNodo = auxRaiz.get(search.indexOf(let.getDato()));
            auxRaiz = auxNodo.getHijos();
            search.clear();
        }

        return auxNodo;
    }

    private void printInOrden(Nodo n, String str) {

        if (0 == n.getHijos().size()) {
            str = str + n.getDato();
            getPalabrasEncontradas().add(str);
        } else if (n.getHijos().size() > 0) {
            str = str + n.getDato();

            if (n.getEsFinal()) {
                getPalabrasEncontradas().add(str);
            }
            printInOrden(n.getHijos().get(0), str);

            for (int i = 1; i < n.getHijos().size(); i++) {
                printInOrden(n.getHijos().get(i), str);
            }
        }
    }

    public ArrayList<Nodo> getRaiz() {
        return raiz;
    }

    public void setRaiz(ArrayList<Nodo> raiz) {
        this.raiz = raiz;
    }

    public ArrayList<String> getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    public void setPalabrasEncontradas(ArrayList<String> palabrasEncontradas) {
        this.palabrasEncontradas = palabrasEncontradas;
    }
    
}
