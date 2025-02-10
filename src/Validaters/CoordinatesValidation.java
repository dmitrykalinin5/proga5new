package Validaters;

import Collections.Coordinates;
import Tools.Validation;

public class CoordinatesValidation implements Validation {
    private final Coordinates coordinates;

    public CoordinatesValidation(Coordinates coordinates, int x, int y) {
        this.coordinates = new Coordinates(x, y);
    }

    public Integer getCoordinates() { return x;}

    @Override
    public boolean validate() { return id != null; }

    @Override
    public String getErrorMessage() {
        return "Ошибка в ID";
    }
}
