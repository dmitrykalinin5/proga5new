package Validaters;

import Collections.Coordinates;
import Collections.Location;
import Console.Client;
import Tools.Validation;

public class LocationValidation implements Validation {
    private Location location;
    private final Client client;
    private final String message;
    private long x;
    private double y;
    private Float z;

    public LocationValidation(Client client, String message) {
        this.client = client;
        this.message = message;
        validation();
    }


//    public LocationValidation(Location location, long x, double y, Float z) {
//        this.x = x;
//        this.y = y;
//        this.z = z;
//        this.location = new Location(x, y, z);
//    }

    public Location validation() {
        while (true) {
            try {
                System.out.print(message);
                String[] elements = client.userInput().split(" ");
                long x = Long.parseLong(elements[0]);
                double y = Double.parseDouble(elements[1]);
                Float z = Float.parseFloat(elements[2]);
                this.location = new Location(x, y, z);
                return this.location;
            } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean validate() { return location != null; }

    @Override
    public String getErrorMessage() {
        return "Ошибка в Coordinates";
    }
}
