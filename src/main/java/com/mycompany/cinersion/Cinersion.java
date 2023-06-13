package com.mycompany.cinersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cinersion extends JFrame {

    //Paneles y Botones
    private JPanel contentPane;
    private JLabel lblQuestion;
    private JButton btnOption1;
    private JButton btnOption2;
    private JButton btnOption3;
    private JButton btnOption4;
    private int currentQuestion = 0;
    private int score = 0;

    // Array de preguntas 
    private String[] questions = {
        "Pregunta 1: ¿Cuál fue la primera película de terror a color?",
        "Pregunta 2: ¿Qué película de terror fue el debut de Johnny Depp?",
        "Pregunta 3: ¿En qué película vemos a una chica de secundaria (Drew Barrymore) recibir llamadas telefónicas cada vez más amenazantes?",
        "Pregunta 4: ¿Qué película de terror moderna describe MovieWeb para \"magnificar el racismo en un nivel muy profundo?",
        "Pregunta 5: ¿Qué película de terror presentó el primer inodoro abierto en la pantalla?",};

    // Array de respuestas
    private String[][] options = {
        {"La maldición de Frankenstein", "Casa del diablo", "Misterio del musero de cera", "El aro"},
        {"Sombras en la oscuridad", "Desde el infierno", "Una pesadilla en la calle Elm", "Terranova"},
        {"Hiedra venenosa", "Gritar", "Mad Love", "Hannibal"},
        {"Salí", "Hereditario", "Midsommar", "El dragón Rojo"},
        {"Ghoulies II (1988)", "El Manoir du Diable", "El silencio de los corderos", "Psycho (1960)"}

    };

    private int[] correctAnswers = {0, 2, 1, 0, 3};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Cinersion frame = new Cinersion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Cinersion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cinersion");
        setPreferredSize(new Dimension(400, 200));
        contentPane = new JPanel();
        setContentPane(contentPane);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        setContentPane(contentPane);
        
        //Panel de preguntas
        lblQuestion = new JLabel("Esta es tu pregunta:");
        lblQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuestion.setVerticalAlignment(SwingConstants.CENTER);
        lblQuestion.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblQuestion);

        pack();
        setLocationRelativeTo(null);

        lblQuestion = new JLabel("");
        lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuestion.setBounds(10, 11, 414, 40);
        contentPane.add(lblQuestion);

        btnOption1 = new JButton("");
        btnOption1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(0);
            }
        });
        btnOption1.setBounds(49, 90, 150, 40);
        contentPane.add(btnOption1);

        btnOption2 = new JButton("");
        btnOption2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(1);
            }
        });
        btnOption2.setBounds(229, 90, 150, 40);
        contentPane.add(btnOption2);

        btnOption3 = new JButton("");
        btnOption3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(2);
            }
        });
        btnOption3.setBounds(49, 157, 150, 40);
        contentPane.add(btnOption3);

        btnOption4 = new JButton("");
        btnOption4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(3);
            }
        });
        btnOption4.setBounds(229, 157, 150, 40);
        contentPane.add(btnOption4);

        // Comenzar el juego con la primera pregunta
        showQuestion(0);
    }

    private void showQuestion(int questionIndex) {
        lblQuestion.setText(questions[questionIndex]);
        btnOption1.setText(options[questionIndex][0]);
        btnOption2.setText(options[questionIndex][1]);
        btnOption3.setText(options[questionIndex][2]);
        btnOption4.setText(options[questionIndex][3]);
    }

    //Panel de respuesta
    private void checkAnswer(int selectedOption) {
        if (selectedOption == correctAnswers[currentQuestion]) {
            score++;
            JOptionPane.showMessageDialog(this, "¡Respuesta correcta!");
        } else {
            JOptionPane.showMessageDialog(this, "Respuesta incorrecta. La respuesta correcta era: " + options[currentQuestion][correctAnswers[currentQuestion]]);
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            showQuestion(currentQuestion);
        } else {
            // Fin del juego, mostrar puntuación final
            JOptionPane.showMessageDialog(this, "Juego completado. Puntuación final: " + score + "/" + questions.length);
            System.exit(0);
        }
    }
}
