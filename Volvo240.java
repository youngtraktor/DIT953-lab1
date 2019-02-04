import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, 0, Color.black, "Volvo240");
        stopEngine();
    }

    /**
     * Calculates the speed factor
     *
     * @return returns the speed factor
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Increases the speed of the car
     *
     * @param amount specifies the value of the speed increase
     */
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower));
    }

    /**
     * Decreases the speed of the car
     *
     * @param amount specifies the value of the speed decrease
     */
    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
}
