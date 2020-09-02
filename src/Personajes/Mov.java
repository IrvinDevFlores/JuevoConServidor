package Personajes;

import Niveles.Nivel;

public abstract class Mov extends Heroe{

    protected String Name;
    protected int Velocidad;
    protected int numPasos = 0;
    protected boolean seMueve;
    protected int DireccionMovimiento = 1;
    protected int Scale = 1;

    public Mov(Nivel nivel, String name, int x, int y, int velocidad) {
        super( nivel );
        Name = name;
        Velocidad = velocidad;
        this.x = x;
        this.y = y;
    }
    
    public void Mover(int x, int y)
    {
        if(x!=0 && y!=0)
        {
            Mover( x,0 );Mover( y,0 );
            numPasos--;
            return;
        }

            this.x += x;
    }

    private boolean jugadorColisiono(int x, int y) {
        return false;
    }
}
