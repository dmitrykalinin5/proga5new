package Collections;

public class Location {
    private long x;
    private double y;
    private Float z; //Поле не может быть null

    public Location(long x, double y, Float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

//    public long getX() { return x; }
//    public double getY() { return y; }
//    public Float getZ() { return z; }

    @Override
    public String toString() {
        return x + "," + y + "," + z;
    }
}
