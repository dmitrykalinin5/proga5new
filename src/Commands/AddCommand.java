package Commands;

import Collections.*;
import Console.Client;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * Класс, который реализует добавление элемента в коллекцию
 */

public class AddCommand implements Command {
    private final CollectionManager collectionManager;


    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, который выполняет команду
     * @param args;
     */
    @Override
    public void execute(String[] args) {
        int newId = collectionManager.getNextId();
        Client client = new Client(); // добавить аргументы
        System.out.print("Введите ваше имя: ");
        String name = client.userInput(); // имя
        System.out.print("\nВведите координату x: ");
        int x = Integer.parseInt(client.userInput());
        System.out.print("\nВвдите координату y: ");
        double y = Double.parseDouble(client.userInput());
        Coordinates coordinates = new Coordinates(x, y); // коорды
        LocalDateTime date = LocalDateTime.now(); // дата
        System.out.print("\nВведите цену: ");
        int price = Integer.parseInt(client.userInput());
        System.out.print("\nВведите тип вашего билета(VIP, USUAL, CHEAP): ");
        TicketType ticketType = TicketType.valueOf(client.userInput());
        System.out.print("\nВведите дату рождения в формате DD.MM.YYYY: ");
        // сделать парсинг, дата должны быть в формате выше
        String birthday = ZonedDateTime.parse();
        System.out.print("\nВведите ваш рост: ");
        Long height = Long.parseLong(client.userInput());
        System.out.print("\nВведите ваш вес (необязательно): ");
        Integer weight = Integer.parseInt(client.userInput());
        System.out.print("\nВведите вашу локацию (скип похуй)");
        Location location = new Location(1, 1, 1);
        Person person = new Person(birthday, height, weight, location);

        /*
        String[] elements = args[1].split(",");
        Coordinates coordinates = new Coordinates(Integer.parseInt(elements[1].split(";")[0]), Double.parseDouble(elements[1].split(";")[1]));
        Location location = new Location(Long.parseLong(elements[7].split(";")[0]), Double.parseDouble(elements[7].split(";")[1]), Float.parseFloat(elements[7].split(";")[2]));
         */
        Person person = new Person(java.time.ZonedDateTime.now(/*elements[5]*/),
                Long.parseLong(elements[5]), Integer.parseInt(elements[6]), location);
        // имя, координаты через ";", цена, тип (USUAL, VIP, CHEAP), др, рост, вес, локация (x;y;z)
        Ticket ticket = new Ticket(newId, elements[0], coordinates,
                LocalDateTime.now(), Long.parseLong(elements[2]), TicketType.valueOf(elements[3]), person);
        this.collectionManager.add(ticket);
        System.out.printf("Добавить элемент %s\n", ticket.toString());
    }

    @Override
    public String description() { return "Adds element to collection"; };
}
