package Img;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.PrinterName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private  Image Imagen;
    private  ImageIcon Ima;
    private int Alto;
    private int Ancho;
    String ruta = "src/Img/fondo.png";

    public Panel()
    {

        Ima = new ImageIcon(ruta);
        Imagen = Ima.getImage();
        Ancho = Ima.getIconWidth() + 150;
        Alto = Ima.getIconHeight();

        setLayout( null );
        setSize( Ancho,Alto );
        setVisible( true );

        JButton s = new JButton( "Iniciar" );

        s.setBounds( 290,350,100,50 );
        add(s);
        s.addActionListener( e ->
        {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            SwingUtilities.invokeLater( () -> {
                new MenuJuego();
                System.out.println("segundo panel");
                frame.dispose();
            } );
        });

    }

    public void paint(Graphics g)
    {
        super.paint( g );
        g.drawImage( Imagen, 0,0,getWidth(),getHeight(),null );
        repaint(  );
    }
}
