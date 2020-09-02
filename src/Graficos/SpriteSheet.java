package Graficos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet
{
    public String RutaImagen;
    public int Ancho;
    public int Alto;

    public int[] PixelesDeImagen;

    public BufferedImage Imagen;

    public SpriteSheet(String ruta)  {
        BufferedImage imagen = null;
        try {
            imagen = ImageIO.read(new File( ruta ));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se puedo leer");
        }

        if(imagen == null) { return; }

        RutaImagen = ruta;
        Ancho = imagen.getWidth();
        Alto = imagen.getHeight();
        Imagen = imagen;
    }
}
