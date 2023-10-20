/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.uees.reproductor;

/**
 *
 * @author user
 */
public interface List {
    void agregarCancion(String rutaArchivo);
    void eliminarCancion(String rutaArchivo);
    void reproducir();
    void siguienteCancion();
    void cancionAnterior();
    void reproducirCancion(int indice);
    int size();
    
}
