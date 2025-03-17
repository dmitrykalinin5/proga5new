package Validaters;

import Collections.Coordinates;
import Collections.Location;
import Commands.CommandProcessor;
import Console.Client;
import Tools.Validation;

import java.util.Scanner;

public class LocationValidation implements Validation {
    private Location location;
    private final String message;
    private long x;
    private double y;
    private Float z;
    private CommandProcessor commandProcessor;

    public LocationValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
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
                String input;
                if (commandProcessor.getScriptFlag()) {
                    input = commandProcessor.getNextCommand().trim();
                    System.out.println(input);
                } else {
                    Scanner scanner = new Scanner(System.in);
                    input = scanner.nextLine().trim();
                }
                String[] elements = input.split(" ");
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
