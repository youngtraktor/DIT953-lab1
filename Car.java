import com.sun.xml.internal.bind.v2.util.FatalAdapter;

import java.awt.*;

public abstract class Car extends Movable implements Turnable {

    final private int nrDoors;
    double enginePower;
    private Color color;
    final private String modelName;
    private double x, y;

    /**
     * @param nrDoors      number of doors
     * @param enginePower  engine power
     * @param currentSpeed current speed
     * @param color        color of the car
     * @param modelName    model name
     */
    public Car(int nrDoors,
               double enginePower,
               double currentSpeed,
               Color color,
               String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        super.setCurrentSpeed(currentSpeed);
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * @return returns the number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * @return returns the engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return returns color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param clr Changes the color of the car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the engine
     */
    public void startEngine() {
        super.setCurrentSpeed(0.1);
    }

    /**
     * Stops the engine
     */
    public void stopEngine() {
        super.setCurrentSpeed(0);
    }

    /**
     * Moves the car
     */
    public void move(double y) {
        this.y += getCurrentSpeed() * speedFactor() + y;
    }

    /**
     * Turns right
     */
    public void turnRight() {
        x += getCurrentSpeed() + speedFactor();
    }

    /**
     * Turns left
     */
    public void turnLeft() {
        x -= getCurrentSpeed() + speedFactor();
    }

    /**
     * Gets x
     *
     * @return returns x
     */
    public double getX() {
        return x;
    }

    /**
     * Gets y
     *
     * @return returns y
     */
    public double getY() {
        return y;
    }

    /**
     * Speed Factor (abstract)
     *
     * @return returns the speed factor
     */
    public abstract double speedFactor();

    /**
     * Accelerates the car with a certain amount when gas is applied
     *
     * @param amount specifies the value of the gas
     */
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }

    /**
     * Brakes the car with a certain amount when breaks are applied
     *
     * @param amount specifies the value of the break
     */
    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }

    /**
     * Increases the speed of the car
     *
     * @param amount specifies the value of the speed increase
     */
    private void incrementSpeed(double amount) {
        super.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower));
    }

    /**
     * Decreases the speed of the car
     *
     * @param amount specifies the value of the speed decrease
     */
    private void decrementSpeed(double amount) {
        super.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }
}
