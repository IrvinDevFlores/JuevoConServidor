package Personajes;

import Niveles.Nivel;

import java.awt.*;

public abstract class Heroe
{
    public int x, y;
    protected Nivel Nivel;

    public Heroe(Nivel nivel)
    {

    }

    public final void Init(Nivel nivel)
    {
        Nivel = nivel;
    }

    public abstract void Actualizar();

    public abstract void Renderizar(Graphics g);


}
