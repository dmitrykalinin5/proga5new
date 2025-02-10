package Validaters;

import Tools.Validation;

public class NameValidation implements Validation {
    private final String name;

    public NameValidation(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public boolean validate() { return name != null; }

    @Override
    public String getErrorMessage() {
        return "Ошибка в ID";
    }
}