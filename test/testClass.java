import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.awt.*;
import java.util.Random;

import static org.junit.Assert.*;

public class testClass {
    private Car saab;
    private Car volvo;
    private Scania scania;

    @Before
    public void cars() {
        volvo = new Volvo240();
        saab = new Saab95();
        scania = new Scania();
    }

    @Test
    public void setColorTest() {
        volvo.setColor(Color.CYAN);
        saab.setColor(Color.GRAY);
        assertSame(volvo.getColor(), Color.CYAN);
        assertSame(saab.getColor(), Color.GRAY);
    }

    @Test
    public void testGasRandomValues() {
        Random random = new Random();
        double value = random.nextDouble() * 200 - 100;
        volvo.gas(value);
        saab.gas(value);
        assertTrue(volvo.getCurrentSpeed() >= 0 && volvo.getCurrentSpeed() <= volvo.enginePower);
        assertTrue(saab.getCurrentSpeed() >= 0 && saab.getCurrentSpeed() <= saab.enginePower);
    }

    @Test
    public void testBrakeRandomValues() {
        Random random = new Random();
        double value = random.nextDouble() * 200 - 100;
        volvo.brake(value);
        saab.brake(value);
        assertTrue(volvo.getCurrentSpeed() >= 0 && volvo.getCurrentSpeed() <= volvo.enginePower);
        assertTrue(saab.getCurrentSpeed() >= 0 && saab.getCurrentSpeed() <= saab.enginePower);
    }

    @Test
    public void testMove() {
        volvo.move(3);
        saab.move(3);
        assertTrue(volvo.getY() == (volvo.getCurrentSpeed() * volvo.speedFactor()) + 3);
        assertTrue(saab.getY() == (saab.getCurrentSpeed() * saab.speedFactor()) + 3);
    }

    @Test
    public void testVolvoTurnRight() {
        double volvoXBefore = volvo.getX();
        volvo.turnRight();
        assertTrue(volvo.getX() == volvoXBefore + volvo.getCurrentSpeed() + volvo.speedFactor());
    }

    @Test
    public void testVolvoTurnLeft() {
        double volvoXBefore = volvo.getX();
        volvo.turnLeft();
        assertTrue(volvo.getX() == volvoXBefore - (volvo.getCurrentSpeed() + volvo.speedFactor()));
    }

    @Test
    public void testSaabTurnRight() {
        double saabXBefore = saab.getX();
        saab.turnRight();
        assertTrue(saab.getX() == saabXBefore + saab.getCurrentSpeed() + saab.speedFactor());
    }

    @Test
    public void testSaabTurnLeft() {
        double saabXBefore = saab.getX();
        saab.turnLeft();
        assertTrue(saab.getX() == saabXBefore - (saab.getCurrentSpeed() + saab.speedFactor()));
    }

    @Test
    public void testWagonAngle() {
        double currentScaniaAngle = scania.getWagon().getWagonAngle();
        scania.getWagon().tiltWagon(50);
        assertTrue(scania.getWagon().getWagonAngle() == currentScaniaAngle + 50);
    }

    @Test
    public void testWagonAngleWhileMoving() {
        scania.setCurrentSpeed(5);
        scania.getWagon().tiltWagon(50);
        assertEquals(scania.getWagon().getWagonAngle(), 0.0, 0);
    }

    @Test
    public void testWrongWagonAngle() {
        scania.getWagon().tiltWagon(90);
        assertEquals(scania.getWagon().getWagonAngle(), 0.0 , 0); ;
    }
}

