package Graficos;

public class Pantalla
{
    public static final int ANCHO_MAPA = 90;
    public static final int ANCHO_MAPA_MASCARA = ANCHO_MAPA -1;

    public int[] Cuadro = new int[ANCHO_MAPA * ANCHO_MAPA];
    public int[] Colores = new int[ANCHO_MAPA * ANCHO_MAPA * 4];

    public int CompensacionEnX = 0;
    public int CompensacionEnY = 0;

    public int Ancho;
    public int Alto;

    public SpriteSheet Fondo;

    public Pantalla(int ancho, int alto, SpriteSheet canvas)
    {
        Ancho = ancho;
        Alto = alto;
        Fondo = canvas;
    }


    public void Renderizar(int[] pixeles, int compensacion, int columna)
    {
        for(int cuadroY = CompensacionEnY >> 3; cuadroY <= (CompensacionEnY + Ancho)>>3;cuadroY++)
        {
                int yMin = cuadroY * 8 - CompensacionEnY;
                int yMax = yMin + 8;
                if(yMin < 0) yMin = 0;
                if(yMax > Alto) yMax = Alto;

                for(int cuadroX = CompensacionEnX >> 3; cuadroX <= (CompensacionEnX + Ancho)>>3; cuadroX++)
                {
                    int xMin = cuadroX + 8 - CompensacionEnX;
                    int xMax = xMin + 8;
                    if(xMin < 0 ) xMin = 0;
                    if(xMax > Ancho)xMax = Ancho;

                    int indexCuadro = (cuadroX & (ANCHO_MAPA_MASCARA) + (cuadroY & (ANCHO_MAPA_MASCARA) * ANCHO_MAPA));
                            for(int y = yMin; y < yMax; y++)
                            {
                                int pixelImagen = ((y + CompensacionEnY)&7)*Fondo.Ancho +
                                        ((xMin + CompensacionEnX) & 7);
                                int pixelCuadro = compensacion + xMin + y * columna;
                                for(int x = xMin; x < xMax; x++)
                                {
                                    int color = indexCuadro * 4 + Fondo.PixelesDeImagen[pixelImagen++];
                                    pixeles[pixelCuadro++] = Colores[color];
                                }
                            }
                }
        }
    }
}
