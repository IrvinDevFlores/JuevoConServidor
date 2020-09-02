package Game;

import Graficos.Pantalla;
import Graficos.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable
{

    private static final long serialVersionUID = 1L;

    public static final int Width = 160;
    public static final int Height = Width / 12 * 9;
    public static final int Scale = 3;
    public static final String Name = "Game";

    private JFrame frame;
    private boolean running = false;
    private int actualizacionesCont = 0;


    //Obtiene el la imagen a bits...
    private BufferedImage Imagen = new BufferedImage( Width, Height,
            BufferedImage.TYPE_INT_RGB );
    private int[] PixelesDeImagen = ((DataBufferInt) Imagen.getRaster().getDataBuffer()).getData();

    private Pantalla pantalla;
    private InputHandler input;

    public Game()  {
        setMinimumSize( new Dimension( Width * Scale , Height * Scale ) );
        setMaximumSize( new Dimension(Width * Scale, Height * Scale) );
        setPreferredSize( new Dimension(Width * Scale, Height * Scale) );

        frame = new JFrame( Name );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLayout( new BorderLayout(  ) );

        frame.add( this,BorderLayout.CENTER );
        frame.pack();

        frame.setResizable( false );
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }

    public void Init()
    {
        pantalla = new Pantalla(Width,Height, new SpriteSheet( "src/Img/fondo.png" ));
        input = new InputHandler( this );
    }

    public synchronized void Start()
    {
        running = true;
        new Thread(this).start();
    }

    public synchronized void Stop()
    {
        running = false;
    }

    //Metdo que estara renderizando en el proceso que se crea en cada hilo
    public  void run()
    {
        long tiempoAnterior = System.nanoTime();
        double nsPorActualizacion = 1000000000D / 60D;

        int actualizaciones = 0;
        int frames = 0;

        long tiempoAntes = System.currentTimeMillis();
        double delta = 0;
        //Iniciamos todo
        Init();

        while (running)
        {
            long Ahora = System.nanoTime();
            delta += (Ahora - tiempoAnterior) / nsPorActualizacion;
            tiempoAntes = Ahora;
            boolean deberiaRenderizar = true;
            while (delta >= 1)
            {
                actualizaciones++;
                ActualizarLogica();
                delta -= 1;
                deberiaRenderizar = true;
            }


            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (deberiaRenderizar) {
                frames++;
                RenderizarJuego();
            }

            if (System.currentTimeMillis() - tiempoAntes >= 1000) {
                tiempoAntes += 1000;
                System.out.println(actualizaciones + " ticks, " + frames + " frames");
                frames = 0;
                actualizaciones = 0;
            }
        }
    }

    //Actualiza la logica del juego
    public void ActualizarLogica()
    {
        actualizacionesCont++;
        if(input.up.isPressed())
        {
            pantalla.CompensacionEnY--;
        }

        if(input.down.isPressed())
        {
            pantalla.CompensacionEnY++ ;
        }

        if(input.left.isPressed())
        {
            pantalla.CompensacionEnX--;
        }

        if(input.right.isPressed())
        {
            pantalla.CompensacionEnX++;
        }
    }

    public void RenderizarJuego()
    {
        BufferStrategy bufferDeImagen = getBufferStrategy();
        if(bufferDeImagen == null)
        {
            createBufferStrategy( 3 );
            return;
        }

        //Sino
        Graphics grafico = bufferDeImagen.getDrawGraphics();
        grafico.drawImage( pantalla.Fondo.Imagen, 0 , 0 , getWidth(), getHeight(), null );
        grafico.dispose();
        bufferDeImagen.show();

    }

    public static void main(String... args) {
        new Game().Start();
    }
}
