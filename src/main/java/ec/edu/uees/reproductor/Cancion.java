package ec.edu.uees.reproductor;

public class Cancion {
    String rutaArchivo;
    Cancion siguiente;
    Cancion atras;
    String nombre;

    Cancion(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.siguiente = null;
    }
}