import java.awt.*;

public class Scania extends Car {

    private Wagon wagon = new Wagon();

    public Scania() {
        super(2, 700, 0,Color.WHITE, "Scania");
        stopEngine();
    }

    /**
     * Speed factor of the truck
     * @return returns engine power
     */
    public double speedFactor() {
        return enginePower;
    }

    public Wagon getWagon() {
        return wagon;
    }

    @Override
    public void setCurrentSpeed(double speed) {
        super.setCurrentSpeed(speed);
        wagon.setTruckSpeed(speed);
    }


}
