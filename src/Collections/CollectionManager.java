package Collections;

import Collections.Ticket;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;
import java.util.regex.*;

/**
 * Класс для управления коллекцией
 */

public class CollectionManager {
    private final PriorityQueue<Ticket> queue = new PriorityQueue<>(Comparator.comparing(Ticket::getId));
    private final LocalDateTime creationTime;
    private int lastId = 0;

    public CollectionManager() {
        this.creationTime = LocalDateTime.now();
    }

    /**
     * Метод, который добавляет ticket в коллекцию
     * @param ticket;
     */
    public void add(Ticket ticket) {
        this.queue.add(ticket);
    }

    /**
     * Метод, который возвращает следующий id
     * @return nextId
     */
    public int getNextId() {
        // Собираем все существующие id
        Set<Integer> existingIds = new HashSet<>();
        for (Ticket ticket : this.queue) {
            existingIds.add(ticket.getId());
        }
        int nextId = 1;
        while (existingIds.contains(nextId)) {
            nextId++;
        }
        // Обновляем lastId, если нужно
        this.lastId = Math.max(this.lastId, nextId);
        return nextId;
    }

    /**
     * Метод, который возвращает все элементы
     * @return queue
     */
    public String getAllElements() {
        if (this.queue.isEmpty()) {
            return "Коллекция пуста\n";
        } else {
            StringBuilder result = new StringBuilder();
            this.queue.stream()
                    .sorted(Comparator.comparing(Ticket::getId))
                    .forEach(ticket -> result.append(ticket.toString()).append("\n"));
            return result.toString();
        }
    }

    /**
     * Метод, который очищает всю коллекцию
     */
    public void clearAllElements() { queue.clear(); }

    /**
     * Метод, который возвращает информацию о коллекции
     * @return info
     */
    public String collectionInfo() {
        String info = "Информация о коллекции:\nДата создания: " + creationTime.toString()
                + "\nКол-во элементов: " + collectionSize();
        return info;
    }

    /**
     * Метод, который удаляет элемент с заданным ID из коллекции
     * @param id ID элемента, который нужно удалить
     * @return true, если элемент удален; false, если элемент с данным айди не найден.
     */
    public boolean removeById(int id) {
        for (Ticket ticket : this.queue) {
            if (ticket.getId() == id) {
                this.queue.remove(ticket);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод, который возвращает кол-во элементов коллекции
     * @return queue.size()
     */
    public int collectionSize() {
        return queue.size();
    }

    /**
     * Метод, который возвращает объект класса по минимальному id
     * @return queue.peek(), объект по минимальному айди
     */
    public Ticket getByMinimumId() {
        return queue.peek();
    }

    /**
     * Метод, который удаляет все элементы эквивалентные заданной цене
     * @param price
     * @return true, если элемент удален; false, если элемент не удален
     */
    public boolean removeAllByPrice(int price) {
        boolean flag = false;
        Iterator<Ticket> iterator = this.queue.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getPrice() == price) {
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Метод, который удаляет первый объект
     * @return true, если удален; false, если не получилось удалить
     */
    public boolean removeFirst() {
        if (this.queue.isEmpty()) {
            return false;
        } else {
            this.queue.remove(this.queue.peek());
            return true;
        }
    }

    /**
     * Выводит первый элемент коллекции и удаляет его
     * @return
     */
    public boolean removeHead() {
        if (this.queue.isEmpty()) {
            return false;
        } else {
            System.out.println(this.queue.peek());
            this.queue.remove(this.queue.peek());
            return true;
        }
    }


    public void update(int id, String element, String newValue) {
        for (Ticket ticket : this.queue) {
            if (ticket.getId() == id) {
                switch (element.toLowerCase()) {
                    case "имя":
                        ticket.setName(newValue);
                        break;
                    case "координаты":

                    case "цена":
                        ticket.setPrice(newValue);
                        case "тип"

                }
            }
        }
    }

    /**
     * Метод, который сохраняет коллекцию в файл
     */
    public void saveToFile() {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("collection.xml"))) {
            bos.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            bos.write("<Tickets>\n".getBytes());
            for (Ticket ticket : this.queue) {
                bos.write("    <ticket>\n".getBytes());
                bos.write(("        <id>" + ticket.getId() + "</id>\n").getBytes());
                bos.write(("        <name>" + ticket.getName() + "</name>\n").getBytes());
                bos.write(("        <coordinates>" + ticket.getCoordinates() + "</coordinates>\n").getBytes());
                bos.write(("        <date>" + ticket.getCreationDate() + "</date>\n").getBytes());
                bos.write(("        <price>" + ticket.getPrice() + "</price>\n").getBytes());
                bos.write(("        <type>" + ticket.getType() + "</type>\n").getBytes());
                bos.write(("        <birthday>" + ticket.getBirthday() + "</birthday>\n" ).getBytes());
                bos.write(("        <height>" + ticket.getHeight() + "</height>\n").getBytes());
                bos.write(("        <weight>" + ticket.getWeight() + "</weight>\n").getBytes());
                bos.write(("        <location>" + ticket.getLocation() + "</location>\n").getBytes());
                bos.write("    </ticket>\n".getBytes());
            }
            bos.write("</Tickets>\n".getBytes());
        } catch (IOException exception) {
            System.err.println("Ошибка при сохранении коллекции в файл " + exception.getMessage());
        }
    }

    /**
     * Метод, который читает файл сразу при запуске программы
     */
    public void loadFromFile() {
        try (
                FileInputStream fis = new FileInputStream("collection.xml");
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader reader = new BufferedReader(isr);
                ) {
            String line;
            Ticket ticket = null;

            int id = 0;
            String name = "";
            String coordinates = "";
            String date = "";
            long price = 0;
            String type = "";
            String birthday = "";
            long height = 0;
            int weight = 0;
            String location = "";

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<ticket>")) {
                    // новый тикет
                    id = 0;
                    name = "";
                    coordinates = "";
                    date = "";
                    price = 0;
                    type = "";
                    birthday = "";
                    height = 0;
                    weight = 0;
                    location = "";
                } else if (line.startsWith("<id>")) {
                    id = Integer.parseInt(extractValue(line, "id"));
                } else if (line.startsWith("<name>")) {
                    name = extractValue(line, "name");
                } else if (line.startsWith("<coordinates>")) {
                    coordinates = extractValue(line, "coordinates");
                } else if (line.startsWith("<date>")) {
                    date = extractValue(line, "date");
                } else if (line.startsWith("<price>")) {
                    price = Long.parseLong(extractValue(line, "price"));
                } else if (line.startsWith("<type>")) {
                    type = extractValue(line, "type");
                } else if (line.startsWith("<birthday>")) {
                    birthday = extractValue(line, "birthday");
                } else if (line.startsWith("<height>")) {
                    height = Long.parseLong(extractValue(line, "height"));
                } else if (line.startsWith("<weight>")) {
                    weight = Integer.parseInt(extractValue(line, "weight"));
                } else if (line.startsWith("<location>")) {
                    location = extractValue(line, "location");
                } else if (line.startsWith("</ticket>")) {
                    // создаем тикет

                    Person person = new Person(
                            java.time.ZonedDateTime.parse(birthday),
                            height,
                            weight,
                            new Location(Long.parseLong(location.split(",")[0]),
                                    Double.parseDouble(location.split(",")[1]),
                                    Float.parseFloat(location.split(",")[2]))
                    );

                    Ticket ticketobj = new Ticket(
                            id,
                            name,
                            new Coordinates(Integer.parseInt(coordinates.split(",")[0]), Double.parseDouble(coordinates.split(",")[1])),
                            LocalDateTime.parse(date),
                            price,
                            TicketType.valueOf(type),
                            person
                    );

                    queue.add(ticketobj);
                    //System.out.println("Добавлен тикет: " + ticketobj);
                }
            }
            lastId = id;
            System.out.println("Файл успешно загружен!");
        } catch (IOException exception) {
            System.err.println("Ошибка чтения файла: " + exception.getMessage());
        } catch (Exception exception) {
            System.err.println("Ошибка парсинга в файла: " + exception);
        }
    }

    /**
     * Метод достаёт содержимое тега <tag>value</tag>
     */
    private String extractValue(String line, String tagName) {
        String openTag = "<" + tagName + ">";
        String closeTag = "</" + tagName + ">";
        if (line.contains(openTag) && line.contains(closeTag)) {
            return line.substring(line.indexOf(openTag) + openTag.length(), line.indexOf(closeTag));
        } else {
            return "";
        }
    }

}
