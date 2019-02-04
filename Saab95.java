import java.awt.*;
import java.io.CharArrayReader;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95() {
        super(2, 125, 0, Color.red, "Saab95");
        turboOn = false;
        stopEngine();
    }

    /**
     * Sets turbo on
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets turbo off
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Calculates the speed factor
     *
     * @return returns the speed factor
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    /**
     * Increases the speed of the car
     *
     * @param amount specifies the value of the speed increase
     */
    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    /**
     * Decreases the speed of the car
     *
     * @param amount specifies the value of the speed decrease
     */
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }
}
