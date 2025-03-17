package Commands;

import Collections.CollectionManager;
import Collections.Ticket;
import java.util.*;

public class GroupCountingByPersonCommand implements Command {
    private CollectionManager collectionManager;

    public GroupCountingByPersonCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        // Группируем билеты по росту
        Map<Long, List<Ticket>> groupedByHeight = new HashMap<>();

        // Проходим по всем тикетам в коллекции и группируем их по росту
        for (Ticket ticket : collectionManager.getQueue()) {
            long height = ticket.getPerson().getHeight(); // Получаем рост из объекта Person
            groupedByHeight.computeIfAbsent(height, k -> new ArrayList<>()).add(ticket);
        }

        // Строим строку с количеством билетов в каждой группе
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Long, List<Ticket>> entry : groupedByHeight.entrySet()) {
            long height = entry.getKey();
            int count = entry.getValue().size();
            result.append("Рост: ").append(height)
                    .append(" - Количество элементов: ").append(count)
                    .append("\n");
        }

        // Выводим результат
        System.out.println(result.toString());
    }

    @Override
    public String description() {
        return "Grouping by Person (по росту)";
    }
}
