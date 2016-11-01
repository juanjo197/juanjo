package ProyectoFinal;

import java.util.Scanner;

public class Main {

    private static Diccionario dicc;

    public static void main(String[] args) {

        System.out.println("Bienvenido al Autocompletado - Estructura de Datos y Algoritmos 1\n\n");
        System.out.println("..........      Cargando las palabras al diccionario      ..........\n\n");
        dicc = new Diccionario();
        cargarMenu();
    }

    public static void cargarMenu() {
        Scanner leer = new Scanner(System.in);
        boolean band = true;

        while (band) {
            System.out.println("Ingrese: \n1. Autocompletar\n2. Búsqueda fonética\n3. Ver diccioario\n4.Salir");

            try {
                int rta = leer.nextInt();

                switch (rta) {
                    case 1:
                        System.out.println("Ingrese palabra a buscar por sufijo: ");
                        String palBuscarS = leer.next();
                        getDicc().buscarSufijo(palBuscarS);
                        break;
                    case 2:
                        System.out.println("Ingrese palabra a buscar por fonética: ");
                        String palBuscarF = leer.next();
                        getDicc().buscarFonética(palBuscarF);
                        break;
                    case 3:
                        getDicc().printDiccionario();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error en la entrada");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("La entrada debe ser un número");
            }
        }
    }

    public static Diccionario getDicc() {
        return dicc;
    }
}
