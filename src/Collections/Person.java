package Collections;

import java.time.ZonedDateTime;
import Validaters.PersonValidator;
/**
 * Класс в котором хранятся данные о человеке
 */

public class Person {
    private ZonedDateTime birthday; //Поле не может быть null
    private Long height; //Поле не может быть null, Значение поля должно быть больше 0
    private int weight; //Значение поля должно быть больше 0
    private Location location; //Поле может быть null

    /**
     * Конструктор для создания объекта Person
     *
     * @param birthday Дата рождения (не может быть null)
     * @param height Рост (не может быть null, знач > 0)
     * @param weight Вес (Знач > 0)
     * @param location Локация (x, y, z) (может быть null)
     */
    public Person(java.time.ZonedDateTime birthday, Long height, int weight, Location location) {
        PersonValidator personvalidator = new PersonValidator(birthday, height, weight);
        personvalidator.validateOrThrow();

        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.location = location;
    }

    //геттеры
    public ZonedDateTime getBirthday() { return birthday; }
    public Long getHeight() { return height; }
    public int getWeight() { return weight; }
    public Location getLocation() { return location; }
    public void setBirhday(ZonedDateTime birthday) { this.birthday = birthday;}
    public void setHeight(Long height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setLocation(Location location) { this.location = location; }


}
