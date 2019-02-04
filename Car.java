import com.sun.xml.internal.bind.v2.util.FatalAdapter;

import java.awt.*;

public abstract class Car implements Movable {

    final private int nrDoors;
    double enginePower;
    private double currentSpeed;
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
        this.currentSpeed = currentSpeed;
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
     * @return returns the current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
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
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Moves the car
     */
    public void move(double y) {
        this.y += currentSpeed * speedFactor() +     y;
    }

    /**
     * Turns right
     */
    public void turnRight () {
        x += currentSpeed + speedFactor();
    }

    /**
     * Turns left
     */
    public void turnLeft() {
        x -= currentSpeed + speedFactor();
    }

    /**
     * Gets x
     * @return returns x
     */
    public double getX() {
        return x;
    }

    /**
     * Gets y
     * @return returns y
     */
    public double getY() {
        return y;
    }

    /**
     * Increases speed of the car (abstract)
     *
     * @param amount specifies the value of the speed increase
     */
    public abstract void incrementSpeed(double amount);

    /**
     * Decreases speed of the car (abstract)
     *
     * @param amount specifies the value of the speed decrease
     */
    public abstract void decrementSpeed(double amount);

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

    public void setCurrentSpeed(double amount) {
        if (amount >= 0 && amount <= enginePower)
            currentSpeed = amount;
    }
}
