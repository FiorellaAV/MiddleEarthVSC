public abstract class Raza{

    protected int salud;
    protected int saludMaxima;
    protected int rangoDeDistancia;
    protected int danioBase;
    
    protected int turnosConBuffo = 0;
    protected boolean herido = false;
    protected boolean muerto = false;
    protected boolean descanso = false;

    public abstract int atacar();
    public abstract void recibirAtaque(Raza enemigo);
    /*
    Estos metodos capaz estan demas? porque podemos acceder por los atributos.
    Pendiente a revisar.
    */
    public boolean estaHerido(){
        return herido;
    }
    public void desmayarse(){
        muerto = true;
    }
} 