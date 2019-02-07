import java.awt.*;

public class CarTransport extends Car {

    private CarCargo carCargo;

    public CarTransport(){
        super(2, 750,0, Color.BLACK, "Car Transport");
        stopEngine();
    }

    public double speedFactor() {
        return enginePower * 0.8;
    }
}
