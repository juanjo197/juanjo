package ProyectoFinal;

import java.util.ArrayList;

public class Fonetica {

    public Fonetica() {
    }

    public String codigoFonetico(Palabra pal) {
        String codigo = pal.getPalabra().charAt(0) + "";
        codigo = codigo.toUpperCase();

        String palab = pal.getPalabra();
        ArrayList<String> palabra = new ArrayList<>();

        for (int i = 0; i < palab.length(); i++) {
            palabra.add(palab.charAt(i) + "");
            palabra.set(i, palabra.get(i).toLowerCase());
        }

        palabra.remove(0);
        omitirHY(palabra);
        ArrayList<Integer> numerico = transformarLetNum(palabra);
        verificarRepeticion(numerico);
        eliminarCeros(numerico);
        codigo = ajustarNumsCad(codigo, numerico);

        return codigo;
    }

    public static void omitirHY(ArrayList<String> palabra) {
        //System.out.println(palabra + ">>> Llega así" );

        ArrayList<String> aux = new ArrayList<>();
        aux.add("h");
        aux.add("y");

        int i = 0;
        while (i != palabra.size()) {
            if (aux.contains(palabra.get(i))) {
                palabra.remove(i);
                i--;
            }
            i++;
        }
        //System.out.println(palabra + ">> SALE ASI" );
    }

    public static ArrayList<Integer> transformarLetNum(ArrayList<String> p) {
        ArrayList<Integer> numerico = new ArrayList<>();

        for (int i = 0; i < p.size(); i++) {
            if ((p.get(i).equals("a")) || (p.get(i).equals("e")) || (p.get(i).equals("i")) || (p.get(i).equals("o"))
                    || (p.get(i).equals("u")) || (p.get(i).equals("y"))) {
                numerico.add(0);
            } else if ((p.get(i).equals("b")) || (p.get(i).equals("f")) || (p.get(i).equals("p")) || (p.get(i).equals("v"))) {
                numerico.add(1);
            } else if ((p.get(i).equals("c")) || (p.get(i).equals("g")) || (p.get(i).equals("j")) || (p.get(i).equals("k"))
                    || (p.get(i).equals("q")) || (p.get(i).equals("s")) || (p.get(i).equals("x")) || (p.get(i).equals("z"))) {
                numerico.add(2);
            } else if ((p.get(i).equals("d")) || (p.get(i).equals("t"))) {
                numerico.add(3);
            } else if ((p.get(i).equals("l"))) {
                numerico.add(4);
            } else if ((p.get(i).equals("m")) || (p.get(i).equals("n"))) {
                numerico.add(5);
            } else if (p.get(i).equals("r")) {
                numerico.add(6);
            }
        }
        //System.out.println(numerico);
        return numerico;
    }

    public static void verificarRepeticion(ArrayList<Integer> numerico) {
        int i = 0;

        while (i <= (numerico.size() - 2)) {

            if (numerico.get(i) == 0) {
            } else if (numerico.get(i) == numerico.get(i + 1)) {
                numerico.remove(i + 1);
                i--;
            }
            i++;
        }
        //System.out.println(numerico + "Eliminados");
    }

    public static void eliminarCeros(ArrayList<Integer> numerico) {
        int i = 0;
        Object x = 0;
        while (numerico.contains(x)) {
            numerico.remove(x);
        }
        //System.out.println(numerico);
    }

    public static String ajustarNumsCad(String codigo, ArrayList<Integer> numerico) {

        int i = numerico.size();

        if (i >= 3) {
            for (int j = 0; j < 3; j++) {
                codigo += Integer.toString(numerico.get(j));
            }
        } else {
            for (int k = 0; k < 3; k++) {
                numerico.add(0);
                codigo += Integer.toString(numerico.get(k));
            }
        }

        return codigo;

    }

}
