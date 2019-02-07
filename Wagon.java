public class Wagon {

    private double wagonAngle;
    private double truckSpeed;

    public Wagon() {
        this.wagonAngle = 0;
        this.truckSpeed = 0;
    }

    /**
     * Check angle of the wagon so it doesn't exceed 70 degrees while standing
     * still. Angle must be 0 when in motion.
     *
     * @param angle, the angle of the wagon
     * @return returns true if the angle meets the requirements
     */
    private boolean checkAngle(double angle) {
        return truckSpeed == 0 && (angle >= 0 && angle <= 70) || angle == 0;
    }

    /**
     * Tilts the wagon with the desired angle.
     *
     * @param angle, can be both positive and negative
     * @return returns the new angle of the wagon
     */
    public void tiltWagon(double angle) {
        if (checkAngle(wagonAngle + angle))
            wagonAngle += angle;
    }

    public double getWagonAngle() {
        return wagonAngle;
    }

    public void setTruckSpeed(double speed) {
        truckSpeed = speed;
    }
}
