public class Reralopes extends Raza implements Descanso {
    
    private int danioConBuffo;
    public Reralopes(){

        saludMaxima = 53;
        salud = saludMaxima;
        danioBase = 27;
    }
    /*Metodo que devuelve el danio del ataque que realiza */
    @Override
    public int atacar(){
        /* CHEQUEAR LO DE MATH RANDOM EN UNA CLASE APARTE O WEA */
        double chances = Math.random()*1000;
        
        if(chances <= 50.0){
            return 0;
        }else{
            if(turnosConBuffo > 0){
                turnosConBuffo--;
                return danioConBuffo;

            }
            return danioBase;
        }
    }
    /*Metodo que le aplica una bonificacion al personaje, le aumenta el danio base */
    @Override
    public void bonusDescanso() {
        
        turnosConBuffo +=3;
        danioConBuffo = danioBase * 2;    

    }
    /*Metodo que dania a la clase, es decir reliza el ataque que recibe el personaje */
    @Override
    public void recibirAtaque(Raza enemigo) {

        salud = salud - enemigo.atacar();

        if(turnosConBuffo > 0){
            turnosConBuffo = 0;
        }
        
        herido = true;

        if (salud <= 0) muerto = true;
        
    }
}

