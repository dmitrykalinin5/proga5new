package Collections;
import Validaters.*;
import Tools.Validation;

public class Ticket implements Validation {
    private final IdValidation id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final NameValidation name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final CoordinatesValidation coordinatesValidation;
    private final java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Long price; //Поле может быть null, Значение поля должно быть больше 0
    private final TicketType type; //Поле не может быть null
    private final Person person; //Поле может быть null

    public Ticket(int id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, Long price, TicketType type, Person person) {
        this.id = new IdValidation(id); // сделать так, чтобы было на 1 больше предыдущего id
        this.name = new NameValidation(name);
        this.coordinates = coordinates;
        this.coordinatesValidation = new CoordinatesValidation(coordinates, coordinates.getX(), coordinates.getY());
        this.creationDate = creationDate;
        // this.creationDate
        this.price = price;
        this.type = type;
        this.person = person;
    }

    // Проверка на валидность
    @Override
    public boolean validate() {
        return id.validate() && name.validate();

    }
    // Меняем сообщение
    @Override
    public String getErrorMessage() {
        if (!id.validate()) {return id.getErrorMessage();}
        if (!name.validate()) {return name.getErrorMessage();}
//        if (!id.validate()) {return id.getErrorMessage();}
//        if (!id.validate()) {return id.getErrorMessage();}
//        if (!id.validate()) {return id.getErrorMessage();}
        return "Все окей (geterrormsg)";
    }

    public int getId() {
        return id.getId();
    }

    @Override
    public String toString() {
        // Написал названия для полей, но думаю потом поменяю
        return  "Ticket{\"id\":" + id + ",\"name\":\"" + name + "\",\"coordinates\":" + coordinates + "\"Дата покупки\":"
                + creationDate + "\"Цена\":" + price + "\"Тип билета\":" + type + "\"ФИО\":" + person + "}";
    }

//    public boolean validate() {
//        if (id <= )
//    }
}
