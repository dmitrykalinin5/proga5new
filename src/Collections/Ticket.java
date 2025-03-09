package Collections;
import Validaters.*;
import Tools.Validation;

import java.time.ZonedDateTime;

public class Ticket implements Validation, Comparable<Ticket> {
    private final IdValidation id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final NameValidation name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final CoordinatesValidation coordinatesValidation;
    private final java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final CreationDateValidation creationDateValidation;
    private final PriceValidation price; //Поле может быть null, Значение поля должно быть больше 0
    private final TicketType type; //Поле не может быть null
    private final Person person; //Поле может быть null

    public Ticket(int id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, Long price, TicketType type, Person person) {
        this.id = new IdValidation(id); // сделать так, чтобы было на 1 больше предыдущего id
        this.name = new NameValidation(name);
        this.coordinates = coordinates;
        this.coordinatesValidation = new CoordinatesValidation(coordinates, coordinates.getX(), coordinates.getY());
        this.creationDate = creationDate;
        this.creationDateValidation = new CreationDateValidation(creationDate);
        this.price = new PriceValidation(price);
        this.type = type;
        this.person = person;
    }

    // геттеры
    public Integer getId() { return id.getId(); }

    public String getName() { return name.getName(); }

    public Coordinates getCoordinates() { return coordinates; }

    public java.time.LocalDateTime getCreationDate() { return creationDate; }

    public CoordinatesValidation getCoordinatesValidation() { return coordinatesValidation; }

    public Long getPrice() { return price.getPrice(); }

    public TicketType getType() { return type; }

    public ZonedDateTime getBirthday() { return person.getBirthday(); }

    public Long getHeight() { return person.getHeight(); }

    public int getWeight() { return person.getWeight(); }

    public Location getLocation() { return person.getLocation(); }

    @Override
    public int compareTo(Ticket other) {
        return Integer.compare(this.id.getId(), other.id.getId());
    };

    // Проверка на валидность
    @Override
    public boolean validate() {
        return id.validate() &&
                name.validate() &&
                coordinatesValidation.validate() &&
                creationDateValidation.validate() &&
                price.validate();

    }
    // Меняем сообщение
    @Override
    public String getErrorMessage() {
        if (!id.validate()) {return id.getErrorMessage();}
        if (!name.validate()) {return name.getErrorMessage();}
        if (!coordinatesValidation.validate()) {return coordinatesValidation.getErrorMessage();}
        if (!creationDateValidation.validate()) {return creationDateValidation.getErrorMessage();}
        if (!price.validate()) {return price.getErrorMessage();}
        return "Все окей (geterrormsg)";
    }

    @Override
    public String toString() {
        // Написал названия для полей, но думаю потом поменяю
        return  "Ticket{\"id\" : " + id.getId() + ", \"name\" : \"" + name.getName() + "\", \"coordinates\" : " +
                coordinates.toString() + ", \"Дата покупки\" : "
                + creationDateValidation.getCreationDate() + ", \"Цена\" : " + price.getPrice() +
                ", \"Тип билета\" : " + type + ", \"Дата рождения:\" : " + person.getBirthday() +
                ", \"Рост\" : " + person.getHeight() + ", \"Вес\" : " + person.getWeight() + ", \"Локация\" : " + person.getLocation() + "}";
    }

//    public boolean validate() {
//        if (id <= )
//    }
}
