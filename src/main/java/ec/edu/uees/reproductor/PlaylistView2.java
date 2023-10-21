/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uees.reproductor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AnaCr
 */
public class PlaylistView2 extends Application{

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reproductor");

        // Crear el contenedor principal BorderPane
        BorderPane root = new BorderPane();

        // Label en la parte superior (norte)
        Label label = new Label("Top 25 - Global");
        root.setTop(label);
        Button addSong = new Button("Add to Playlist");
        root.setBottom(addSong);
        addSong.setOnAction(event -> {
                // Agrega aquí la lógica que deseas cuando se presiona un botón
            });
        // Segundo panel en la parte inferior (sur)
        // Crear una lista doblemente enlazada de elementos
        //ObservableList<Song> items = FXCollections.observableArrayList(
        ObservableList<String> items = FXCollections.observableArrayList(
                "Elemento 1",  //new Song("Canción 1"),
                "Elemento 2",
                "Elemento 3",
                "Elemento 4",
                "Elemento 5"
        );

        // Crear un ListView y asignarle la lista de elementos
        //ListView<Song> listView = new ListView<>(songs);
        ListView<String> listView = new ListView<>(items);
        listView.setOnMouseClicked(event -> {
        //Song
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Aquí puedes abrir una nueva ventana según el elemento seleccionado
                //openReproductor(selectedSong);
                openReproductor(selectedItem);
            }
        });

        // Crear un contenedor VBox para colocar el ListView
        HBox Hbox = new HBox(listView);
        // Crear un contenedor BorderPane y asignar el VBox al centro
        root.setCenter(Hbox);
        
        
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //private void openReproductor(Song selectedSong)
    private void openReproductor(String selectedItem) {
        // Aquí puedes definir la lógica para abrir una nueva ventana
        // Puedes usar Stage y Scene para crear una nueva ventana
        Stage newStage = new Stage();
        BorderPane root = new BorderPane();
//  Label label = new Label(selectedSong.getTitle());  
        // Crear 4 botones para la nueva ventana
        Button play = new Button("Play");
        Button pause = new Button("Pause");
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        
        play.setOnAction(event -> {
                // Agrega aquí la lógica que deseas cuando se presiona un botón
            });
        pause.setOnAction(event -> {
                // Agrega aquí la lógica que deseas cuando se presiona un botón
            });
        previous.setOnAction(event -> {
                // Agrega aquí la lógica que deseas cuando se presiona un botón
            });
        next.setOnAction(event -> {
                // Agrega aquí la lógica que deseas cuando se presiona un botón
            });
        // Agregar los botones a un VBox
        HBox buttonLayout = new HBox(15); // Espaciado entre botones
        buttonLayout.getChildren().addAll(play, pause, previous, next);
        HBox labelPanel = new HBox();
        Label label = new Label(selectedItem);
        root.setTop(label);
        root.setBottom(buttonLayout);
        // Crear la escena para la nueva ventana
        Scene newScene = new Scene(root, 400, 200);
        // Asignar la escena a la nueva ventana
        newStage.setScene(newScene);
        // Mostrar la nueva ventana
        newStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
    
