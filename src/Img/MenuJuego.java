package Img;

import javax.swing.*;
import java.awt.*;

public class MenuJuego extends JFrame {
    Dimension sizePantalla = Toolkit.getDefaultToolkit().getScreenSize();
    MenuJuego(){
        add(new Panel());
        setSize(868,500);
        setVisible(true);
        setResizable( false );
        setLocationRelativeTo( null );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Audio a = new Audio();
    }

    public static void main(String[] args) {
        new MenuJuego();
    }
}
