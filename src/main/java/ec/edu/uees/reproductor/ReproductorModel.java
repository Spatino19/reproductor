/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uees.reproductor;

/**
 *
 * @author user
 */
public class ReproductorModel implements List {
    private Nodo inicio;
    private Nodo actual;

    @Override
    public void reproducirCancion(int indice) {
        if (indice < 0 || indice >= size()) {
            System.out.println("Índice de canción no válido.");
            return;
        }

        Nodo temp = inicio;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        actual = temp;
        reproducir();
    }

    private class Nodo {
        String rutaArchivo;
        Nodo siguiente;

        Nodo(String rutaArchivo) {
            this.rutaArchivo = rutaArchivo;
            this.siguiente = null;
        }
    }

    @Override
    public void agregarCancion(String rutaArchivo) {
        Nodo nuevaCancion = new Nodo(rutaArchivo);
        if (inicio == null) {
            inicio = nuevaCancion;
            inicio.siguiente = inicio;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != inicio) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevaCancion;
            nuevaCancion.siguiente = inicio;
        }
        actual = inicio;
    }

    @Override
    public void eliminarCancion(String rutaArchivo) {
         if (inicio == null) {
            return;
        }

        Nodo temp = inicio;
        Nodo prev = null;

        do {
            if (temp.rutaArchivo.equals(rutaArchivo)) {
                if (temp == inicio) {
                    inicio = inicio.siguiente;
                }
                prev.siguiente = temp.siguiente;
                temp.siguiente = null;
                return;
            }
            prev = temp;
            temp = temp.siguiente;
        } while (temp != inicio);
    }

    @Override
    public void reproducir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void siguienteCancion() {
         if (actual == null) {
            System.out.println("No hay canciones en la lista.");
        } else {
            actual = actual.siguiente;
            reproducir();
        }
    }

    @Override
    public void cancionAnterior() {
          if (actual == null) {
            System.out.println("No hay canciones en la lista.");
        } else {
            Nodo temp = actual;
            while (temp.siguiente != actual) {
                temp = temp.siguiente;
            }
            actual = temp;
            reproducir();
        }
    }

    @Override
    public int size() {
                if (inicio == null) {
            return 0;
        }

        int count = 1; // Iniciamos en 1 porque hay al menos un nodo (inicio).
        Nodo temp = inicio.siguiente;
        while (temp != inicio) {
            count++;
            temp = temp.siguiente;
        }

        return count;
    }

}
   

