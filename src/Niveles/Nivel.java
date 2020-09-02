package Niveles;

import Graficos.Pantalla;
import Personajes.Heroe;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Nivel {

    private byte[] tiles;
    public int width;
    public int height;
    private List<Heroe> heroes = new ArrayList<Heroe>();
    private String imagePath;
    private BufferedImage image;

    public Nivel(String imagePath) {
        if (imagePath != null) {
            this.imagePath = imagePath;
            this.loadLevelFromFile();
        } else {
            this.width = 1200;
            this.height = 700;
            tiles = new byte[width * height];
            this.generateLevel();
        }
    }

    private void loadLevelFromFile() {
        try {
            this.image = ImageIO.read( new File( imagePath ) );
            this.width = this.image.getWidth();
            this.height = this.image.getHeight();
            tiles = new byte[width * height];
            this.loadTiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTiles() {

    }

    @SuppressWarnings("unused")
    private void saveLevelToFile() {
        try {
            ImageIO.write( image, "png", new File( imagePath ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void alterTile(int x, int y) {

    }

    public void generateLevel() {

    }

    public synchronized List<Heroe> obtenerHeroes() {
        return this.heroes;
    }

    public void tick() {
        for (Heroe e : obtenerHeroes()) {

        }

    }

}
