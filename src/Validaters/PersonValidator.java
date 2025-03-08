package Validaters;

import Collections.Person;
import Tools.Validation;

/**
 * Класс для валидации объекта Person
 */

public class PersonValidator implements Validation {
    private final java.time.ZonedDateTime birthday;
    private final Long height;
    private final int weight;

    public PersonValidator(java.time.ZonedDateTime birthday, Long height, int weight) {
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    public boolean validateBirthday(java.time.ZonedDateTime birthday) {
        return birthday != null;
    }

    public boolean validateHeight(Long height) {
        return height != null && height > 0;
    }

    public boolean validateWeight(int weight) {
        return weight > 0;
    }

// чет надо с этим сделать, хз зачем мне это
    @Override
    public boolean validate() {
        return validateBirthday(birthday) && validateHeight(height) && validateWeight(weight);
    }

    @Override
    public String getErrorMessage() {
        if (birthday == null) return "Дата рождения не может быть null";
        if (height == null || height <= 0) return "Рост не может быть null или <= 0";
        if (weight <= 0) return "Вес не может быть <= 0";
        return "Неизвестная ошибка";
    }

    public void validateOrThrow() {
        if (!validate()) {
            throw new IllegalStateException(getErrorMessage());
        }
    }
}
