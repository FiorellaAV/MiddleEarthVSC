public class Nortachian extends Raza implements Descanso{

    private int turnosEnojado = 0;

    public Nortachian(){
        
        saludMaxima = 66;
        salud = saludMaxima;
        danioBase = 18;
        
    }
    /*Metodo que devuelve el danio del ataque que realiza */
    @Override
    public int atacar(){
        
        if(turnosConBuffo > 0){
            turnosConBuffo--;
            return 0;
        }else{
            salud = salud + (salud*4)/100;
            if(turnosEnojado > 0){
                turnosEnojado--;
            return danioBase*2;
            }
        return danioBase;
        }     
    }
    /*Metodo que le aplica una bonificacion al personaje, recupera toda la vida, pero se vuelve de piedra por 2 turnos */
    @Override
    public void bonusDescanso() {
        turnosConBuffo = 2;
        salud = saludMaxima;
        
    }
    /*Metodo que dania a la clase, es decir reliza el ataque que recibe el personaje */
    @Override
    public void recibirAtaque(Raza enemigo) {
        
        if(turnosConBuffo > 0){

            salud = salud - (enemigo.atacar())/2;
            turnosEnojado = 2;

        }else{
            
            salud = salud - enemigo.atacar();
            turnosEnojado = 2;
        }

        herido = true;

        if (salud <= 0) muerto = true;
        
    }
}  