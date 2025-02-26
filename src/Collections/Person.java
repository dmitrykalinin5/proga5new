package Collections;

public class Person {
    private java.time.ZonedDateTime birthday; //Поле не может быть null
    private Long height; //Поле не может быть null, Значение поля должно быть больше 0
    private int weight; //Значение поля должно быть больше 0
    private Location location; //Поле может быть null

    public Person(java.time.ZonedDateTime birthday, Long height, int weight, Location location) {

    }

}
