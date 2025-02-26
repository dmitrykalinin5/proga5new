package Commands;

import Collections.*;

import java.time.LocalDateTime;

/**
 * Класс, который реализует добавление элемента в коллекцию
 */

public class AddCommand implements Command {
    private final String element;

    // Делаем из parts[1] element
    public AddCommand(String element) {
        this.element = element;
    }

    @Override
    public void execute() {
        String[] elements = element.split(",");
        Coordinates coordinates = new Coordinates(Integer.parseInt(elements[2].split(" ")[0]), Double.parseDouble(elements[2].split(" ")[1]))
        Person person = new Person(new Zoned elements[6].split(" ")[0]);
        Ticket ticket = new Ticket(Integer.parseInt(elements[0]), elements[1], coordinates,
                LocalDateTime.now(), Long.parseLong(elements[4]), TicketType.valueOf(elements[5]), new Person(elements[6]);
        System.out.printf("Добавить элемент %s\n", element);

    }

    @Override
    public String description() { return "Exits session"; };
}
