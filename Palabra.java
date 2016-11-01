package ProyectoFinal;

public class Palabra {

    private String palabra;
    private String codFonetico;
    private int numBusqueda;

    public Palabra(String palabra) {
        this.palabra = palabra;
        this.codFonetico = "";
        this.numBusqueda = 0;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getCodFonetico() {
        return codFonetico;
    }

    public void setCodFonetico(String codFonetico) {
        this.codFonetico = codFonetico;
    }

    public int getNumBusqueda() {
        return numBusqueda;
    }

    public void setNumBusqueda(int numBusqueda) {
        this.numBusqueda = numBusqueda;
    }
    
    
    
}
