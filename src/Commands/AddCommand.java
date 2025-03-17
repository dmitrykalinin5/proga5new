package Commands;

import Collections.*;
import Console.Client;
import Validaters.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.*;

/**
 * Класс, который реализует добавление элемента в коллекцию
 */

public class AddCommand implements Command {
    private final CollectionManager collectionManager;
    private Deque<String> historyDeque;
    private CommandProcessor commandProcessor;

    public AddCommand(CollectionManager collectionManager, Deque<String> history, CommandProcessor commandProcessor) {
        this.collectionManager = collectionManager;
        this.historyDeque = history;
        this.commandProcessor = commandProcessor;
    }

    /**
     * Метод, который выполняет команду
     * @param args;
     */
    @Override
    public void execute(String[] args) {
        int newId = collectionManager.getNextId();

        String message = "Введите ваше имя: ";
        NameValidation nameValidation = new NameValidation(message, commandProcessor);
        String name = nameValidation.getName();

        System.out.println("Ввод координат:");
        message = "Введите координату x: ";
        XCoordinateValidation xCoordinateValidation = new XCoordinateValidation(message, commandProcessor);
        int x = xCoordinateValidation.getX();
        message = "Введите координату y: ";
        YCoordinateValidation yCoordinateValidation = new YCoordinateValidation(message,commandProcessor);
        double y = yCoordinateValidation.getY();
        Coordinates coordinates = new Coordinates(x, y); // коорды

        LocalDateTime date = LocalDateTime.now(); // дата

        message = "Введите цену: ";
        PriceValidation priceValidation = new PriceValidation(message, commandProcessor);
        Long price = priceValidation.getPrice();

        message = "Введите тип вашего билета(VIP, USUAL, CHEAP): ";
        TicketTypeValidation ticketTypeValidation = new TicketTypeValidation(message, commandProcessor);
        TicketType ticketType = ticketTypeValidation.getTicketType();

        message = "Введите дату рождения в формате DD.MM.YYYY: ";
        BirthdayValidation birthdayValidation = new BirthdayValidation(message, commandProcessor);
        String birthdayInput = birthdayValidation.getBirthday();
        // парсинг даты из формата DD.MM.YYYY в ZonedDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localdate = LocalDate.parse(birthdayInput, formatter);
        ZonedDateTime birthday = localdate.atStartOfDay(ZoneId.systemDefault());

        message = "Введите ваш рост: ";
        HeightValidation heightValidation = new HeightValidation(message, commandProcessor);
        Long height = heightValidation.getHeight();

        message = "Введите ваш вес: ";
        WeightValidation weightValidation = new WeightValidation(message, commandProcessor);
        int weight = weightValidation.getweight();

        message = "Введите координаты вашей локации через пробел (x y z): ";
        LocationValidation locationValidation = new LocationValidation(message, commandProcessor);
        Location location = locationValidation.getLocation();

        Person person = new Person(birthday, height, weight, location);
        Ticket ticket = new Ticket(newId, name, coordinates, date,
                price, ticketType, person);

        this.collectionManager.add(ticket);
        System.out.println("Элемент добавлен");
    }

    @Override
    public String description() { return "Adds element to collection"; };
}
