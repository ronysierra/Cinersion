package com.mycompany.cinersion;

import com.mycompany.cinersion.Cinersion;
import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
                try {
                    Cinersion frame = new Cinersion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
        });
    }
}
