

import org.junit.Assert;
import org.junit.Test;

public class Tests {

    //Propios

    Wrives mago = new Wrives();
    Raza catapulta = new Reralopes();
    Raza ninja = new Radaiteran();
    Raza arquero = new Nortachian();

    //Enemigos

    Raza magoEnemigo = new Wrives();
    Raza catapultaEnemigo = new Reralopes();
    Raza ninjaEnemigo = new Radaiteran();
    Raza arqueroEnemigo = new Nortachian();

    @Test
    public void testMagoEnemigoHerido(){

        magoEnemigo.recibirAtaque(mago);

        Assert.assertEquals(true,magoEnemigo.herido);
    }

    @Test
    public void testDanioDeWriveSinBeneficioDeDescansoYEnPrimerTurno(){

        int danio = mago.atacar();

        Assert.assertEquals(113, danio);
    }
    @Test
    public void testDanioDeWriveSinBeneficioDeDescansoLuegoDeDosAtaques(){

        mago.atacar();

        Assert.assertEquals(226, mago.atacar());
    }
    @Test
    public void testDanioDeWrivesConBeneficioDeDescanso(){

        mago.descanso = true;

        Assert.assertEquals(0, mago.atacar());
    }

    @Test
    public void testSaludMaximaDeWrivesSinBeneficio(){
        
        Assert.assertEquals(108, mago.saludMaxima);
    }
    
    @Test
    public void testSaludMaximaDeWrivesConBeneficio(){
        
        mago.bonusDescanso();
        Assert.assertEquals(158, mago.saludMaxima);
    }
    @Test
    public void testSaludMaximaDeWrivesConDobleBeneficio(){
        mago.bonusDescanso();
        mago.bonusDescanso();
        Assert.assertEquals(208, mago.saludMaxima);
    }
    @Test
    public void testSaludDeWriveHeridoPorOtroWrive(){

        int salud = mago.salud - magoEnemigo.danioBase*2;

        mago.recibirAtaque(magoEnemigo);
        
        Assert.assertEquals(salud, mago.salud );
    }
    @Test
    public void testSaludDeWriveHeridoPorReralope(){

        int salud = mago.salud - (catapultaEnemigo.danioBase*2);
        mago.recibirAtaque(catapultaEnemigo);
        
        Assert.assertEquals(salud, mago.salud );

    }
    @Test
    public void testSaludDeWriveHeridoPorRadaiteran(){
        int salud = mago.salud - (ninjaEnemigo.danioBase*2);
        mago.recibirAtaque(ninjaEnemigo);
        
        Assert.assertEquals(salud, mago.salud );
    }
    @Test
    public void testSaludDeWriveHeridoPorNortachian(){

        int salud = mago.salud - (arqueroEnemigo.danioBase*2);
        mago.recibirAtaque(arqueroEnemigo);
        
        Assert.assertEquals(salud, mago.salud );
    }

}