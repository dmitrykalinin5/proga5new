package Commands;

import Collections.*;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Класс, который реализует добавление элемента в коллекцию
 */

public class AddCommand implements Command {
    private String element;

    // Делаем из parts[1] element
    public AddCommand() {
        this.element = element;
    }

    @Override
    public void execute(String[] args) {
        String[] elements = args[1].split(",");
        Coordinates coordinates = new Coordinates(Integer.parseInt(elements[2].split(";")[0]), Double.parseDouble(elements[2].split(";")[1]));
        Location location = new Location(Long.parseLong(elements[8].split(";")[0]), Double.parseDouble(elements[8].split(";")[1]), Float.parseFloat(elements[8].split(";")[2]));
        Person person = new Person(java.time.ZonedDateTime.now(/*elements[5]*/),
                Long.parseLong(elements[6]), Integer.parseInt(elements[7]), location);
        Ticket ticket = new Ticket(Integer.parseInt(elements[0]), elements[1], coordinates,
                LocalDateTime.now(), Long.parseLong(elements[3]), TicketType.valueOf(elements[4]), person);
        System.out.printf("Добавить элемент %s\n", ticket.toString());
    }

    @Override
    public String description() { return "Exits session"; };
}
