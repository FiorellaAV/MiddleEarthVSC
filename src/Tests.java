

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class Tests {

    //Propios

    Wrives mago = new Wrives();
    Reralopes catapulta = new Reralopes();
    Radaiteran ninja = new Radaiteran();
    Nortachian arquero = new Nortachian();

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

    /* Tests de Wrives */
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
    
        mago.recibirAtaque(ninjaEnemigo);
        
        Assert.assertEquals(-10, mago.salud );
    }
    @Test
    public void testSaludDeWriveHeridoPorNortachian(){

        int salud = mago.salud - (arqueroEnemigo.danioBase*2);
        mago.recibirAtaque(arqueroEnemigo);
        
        Assert.assertEquals(salud, mago.salud );
    }
    /* Tests de Reralopes */
    /* Este test puede fallar, ya que el reralope puede errar 2 de cada 4 golpes */
    @Test
    public void testDanioDeReralopesSinBeneficioDeDescanso(){

        int danio = catapulta.atacar();

        Assert.assertEquals(27, danio);
    }
    @Test
    public void testDanioDeReralopesConBeneficioDeDescanso(){

        catapulta.bonusDescanso();
        int danio = catapulta.danioBase*2;

        Assert.assertEquals(danio, catapulta.atacar());
    }
    @Test
    public void testDanioDeReralopesLuegoDeSerAtacadoYConBeneficioActivo(){

        int danio = catapulta.danioBase;
        catapulta.bonusDescanso();
        catapulta.recibirAtaque(catapultaEnemigo);

        Assert.assertEquals(danio, catapulta.atacar());
    }
    @Test
    public void testTurnosBuffeadoDeReralopesConDobleBeneficioDeDescanso(){
        
        catapulta.bonusDescanso();
        catapulta.bonusDescanso();

        Assert.assertEquals(6, catapulta.turnosConBuffo);
    }
    @Test
    public void testSaludDeReraloreHeridoPorWrive(){
        
        catapulta.recibirAtaque(magoEnemigo);

        Assert.assertEquals(-60, catapulta.salud);
    }
    /* Puede fallar ya que erra 2 de 4 ataques */
    @Test
    public void testSaludDeReraloreHeridoPorOtroReralope(){
        
        catapulta.recibirAtaque(catapultaEnemigo);

        Assert.assertEquals(26, catapulta.salud);
    }
    @Test
    public void testSaludDeReralopeHeridoPorRadaiteran(){
        
        catapulta.recibirAtaque(ninjaEnemigo);

        Assert.assertEquals(-6, catapulta.salud);
    }
    @Test
    public void testSaludDeReralopeHeridoPorNortachian(){

        catapulta.recibirAtaque(arqueroEnemigo);

        Assert.assertEquals(35, catapulta.salud);
    }

    /* Test de Radaiteran */
    @Test
    public void testDanioDeRadaiteranPrimerAtaque(){
        int danio = ninja.danioBase+3;

        assertEquals(danio, ninja.atacar());
    }
    @Test
    public void testDanioDeRadaiteranSegundoAtaque(){
        int danio = ninja.danioBase + (3 * 2);
        ninja.atacar();
        assertEquals(danio, ninja.atacar());
    }
    @Test
    public void testDanioDeRadaiteranTercerAtaque(){
        int danio = ninja.danioBase + (3 * 3);
        ninja.atacar();
        ninja.atacar();
        assertEquals(danio, ninja.atacar());
    }
    @Test
    public void testSaludDeRadaiteranHeridoPorWrive(){

        ninja.recibirAtaque(magoEnemigo);
        assertEquals(-77, ninja.salud);
    }
    @Test
    public void testSaludDeRadaiteranHeridoPorReralope(){

        ninja.recibirAtaque(catapultaEnemigo);
        assertEquals(9, ninja.salud);
    }
    @Test
    public void testSaludDeRadaiteranHeridoPorOtroRadaiteran(){

        ninja.recibirAtaque(ninjaEnemigo);
        assertEquals(-23, ninja.salud);
    }
    @Test
    public void testSaludDeRadaiteranHeridoPorNortachian(){

        ninja.recibirAtaque(arqueroEnemigo);
        assertEquals(18, ninja.salud);
    }
    
    /* Test de Nortachian */

    @Test
    public void testDanioDeNortachianSinBeneficioDeDescanso(){
        int danio = arquero.danioBase;

        Assert.assertEquals(danio,arquero.atacar());

    }
    @Test
    public void testDanioDeNortachianConBeneficioDeDescanso(){
        arquero.bonusDescanso();

        Assert.assertEquals(0,arquero.atacar());
    }
    @Test
    public void testNortachianRecibirDanioSinBeneficioDeDescanso(){
        int salud = arquero.salud - arqueroEnemigo.danioBase;
        arquero.recibirAtaque(arqueroEnemigo);

        Assert.assertEquals(salud,arquero.salud );
    }
    @Test
    public void testNortachianRecibirDanioConBeneficioDeDescanso(){
        int salud = arquero.salud - (arqueroEnemigo.danioBase / 2);
        arquero.bonusDescanso();
        arquero.recibirAtaque(arqueroEnemigo);

        Assert.assertEquals(salud,arquero.salud );
    }
    @Test
    public void testNortachianRecibirAtaqueYAtacarConDobleDanio(){
        int danio = arquero.danioBase * 2;
        arquero.recibirAtaque(arqueroEnemigo);
        
        Assert.assertEquals(danio, arquero.atacar());
    }
    @Test
    public void testNortachianRecibirAtaqueYAtacarYCurarse(){
    
        arquero.recibirAtaque(arqueroEnemigo);
        int salud = arquero.salud + (int)(arquero.saludMaxima * 0.04);
        arquero.atacar();
        Assert.assertEquals(salud ,arquero.salud);
    }
    @Test
    public void testSaludDeNortaichianHeridoPorWrive(){

        arquero.recibirAtaque(magoEnemigo);
        Assert.assertEquals(-47, arquero.salud);
    }
    @Test
    public void testSaludDeNortaichianHeridoPorReralope(){

        arquero.recibirAtaque(catapultaEnemigo);
        Assert.assertEquals(39, arquero.salud);
    }
    @Test
    public void testSaludDeNortaichianHeridoPorRadaiteran(){

        arquero.recibirAtaque(ninjaEnemigo);
        Assert.assertEquals(7, arquero.salud);
    }
    @Test
    public void testSaludDeNortaichianHeridoPorNortachian(){

        arquero.recibirAtaque(arqueroEnemigo);
        Assert.assertEquals(48, arquero.salud);
    }
    
}