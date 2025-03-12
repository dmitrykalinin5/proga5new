package Collections;
import Validaters.*;
import Tools.Validation;

import java.time.ZonedDateTime;

public class Ticket implements Comparable<Ticket> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long price; //Поле может быть null, Значение поля должно быть больше 0
    private TicketType type; //Поле не может быть null
    private Person person; //Поле может быть null

    public Ticket(int id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, Long price, TicketType type, Person person) {
        this.id = id; // сделать так, чтобы было на 1 больше предыдущего id
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.type = type;
        this.person = person;
    }

    // геттеры
    public Integer getId() { return id; }

    public String getName() { return name; }

    public Coordinates getCoordinates() { return coordinates; }

    public java.time.LocalDateTime getCreationDate() { return creationDate; }

    public Long getPrice() { return price; }

    public TicketType getType() { return type; }

    public ZonedDateTime getBirthday() { return person.getBirthday(); }

    public Long getHeight() { return person.getHeight(); }

    public int getWeight() { return person.getWeight(); }

    public Location getLocation() { return person.getLocation(); }

    public void setName(String name) { this.name = name; }

    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }

    public void setPrice(Long price) { this.price = price; }

    public void setType(TicketType type) { this.type = type; }

    public void setBirthday(String birthday) {

    }

    @Override
    public int compareTo(Ticket other) {
        return Integer.compare(this.id, other.id);
    };

//    // Проверка на валидность
//    @Override
//    public boolean validate() {
//        return id.validate() &&
//                name.validate() &&
//                coordinatesValidation.validate() &&
//                creationDateValidation.validate() &&
//                price.validate();
//
//    }
//    // Меняем сообщение
//    @Override
//    public String getErrorMessage() {
//        if (!id.validate()) {return id.getErrorMessage();}
//        if (!name.validate()) {return name.getErrorMessage();}
//        if (!coordinatesValidation.validate()) {return coordinatesValidation.getErrorMessage();}
//        if (!creationDateValidation.validate()) {return creationDateValidation.getErrorMessage();}
//        if (!price.validate()) {return price.getErrorMessage();}
//        return "Все окей (geterrormsg)";
//    }

    @Override
    public String toString() {
        // Написал названия для полей, но думаю потом поменяю
        return  "Ticket{\"id\" : " + id + ", \"name\" : \"" + name + "\", \"coordinates\" : " +
                coordinates.toString() + ", \"Дата покупки\" : "
                + creationDate + ", \"Цена\" : " + price +
                ", \"Тип билета\" : " + type + ", \"Дата рождения:\" : " + person.getBirthday() +
                ", \"Рост\" : " + person.getHeight() + ", \"Вес\" : " + person.getWeight() + ", \"Локация\" : " + person.getLocation() + "}";
    }

//    public boolean validate() {
//        if (id <= )
//    }
}
