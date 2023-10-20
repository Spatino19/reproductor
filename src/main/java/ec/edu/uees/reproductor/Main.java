package ec.edu.uees.reproductor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

    public static void main(String[] args) {
         JFrame frame = new JFrame("Reproductor de Música");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500); // Establecer el tamaño de la ventana

        JButton playButton = new JButton("Play");
        JButton stopButton = new JButton("Stop");
        JButton saveButton = new JButton("Guardar Música");

        JTextField fileNameField = new JTextField(20);

        JFileChooser fileChooser = new JFileChooser("./music");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); // Usar un GridLayout para organizar los componentes

        panel.add(fileNameField);
        panel.add(playButton);
        panel.add(stopButton);
        panel.add(saveButton);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File selectedFile = fileChooser.getSelectedFile();
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(selectedFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Detener la reproducción del audio
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                if (!fileName.isEmpty()) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter("./music/" + fileName + ".wav"))) {
                        // Crear un archivo nuevo para guardar la música
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    
    }
    

