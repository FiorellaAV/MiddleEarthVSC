public class Radaiteran extends Raza {
    
    private int ataquesRealizados = 0;
    public Radaiteran(){

        saludMaxima = 36;
        salud = saludMaxima;
        danioBase = 56;
        

    }
    /*Metodo que devuelve el danio del ataque que realiza */
    @Override
    public int atacar(){
    
        ataquesRealizados++;

        return danioBase*ataquesRealizados;

    }
    /*Metodo que dania a la clase, es decir reliza el ataque que recibe el personaje */
    @Override
    public void recibirAtaque(Raza enemigo) {
        
        salud = salud - enemigo.atacar();
        
        herido = true;

        if (salud <= 0) muerto = true;
        
    }
}
