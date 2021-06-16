public class Wrives extends Raza implements Descanso {

    private int ataquesRealizados = 0;
    public Wrives(){

        saludMaxima = 108;
        salud = saludMaxima;
        danioBase = 113;
    }
    /*Metodo que devuelve el danio del ataque realizado */
    @Override
    public int atacar(){

        if(descanso){
            return 0;
        }else{
            ataquesRealizados++;
            if(ataquesRealizados%2 == 0){
                return danioBase*2;
            }
            return danioBase;
        }
    }
    /*Metodo que le da una bonificacion, le aumenta la salud maxima en 50 y recupera toda la vida */
    @Override
    public void bonusDescanso() {

        descanso = true;
        saludMaxima = saludMaxima+50;
        if(salud == saludMaxima)danioBase = 0;
        else danioBase = 113;
    
    }
    /*Metodo que dania a la clase, es decir realiza el ataque que recibe el personaje */
    @Override
    public void recibirAtaque(Raza enemigo) {
        
        salud = salud - (enemigo.atacar()*2);
        descanso = false;
        herido = true;

        if (salud <= 0) muerto = true;   
    }
}
