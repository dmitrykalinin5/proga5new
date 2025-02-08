package Server.Collections;
import Tools.Validation;

public class Ticket {
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

    public int getId() {
        return id;
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
