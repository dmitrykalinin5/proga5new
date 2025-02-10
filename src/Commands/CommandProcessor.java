package Commands;

import Collections.Coordinates;
import Collections.TicketType;
import Validaters.CreationDateValidation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commands;

    public void CommandPut(String name) {
        // Словарь
        commands = new HashMap<>();

        // Тестовая команда
        commands.put("test", new TestCommand(123, "Брат",
                new Coordinates(3, 4), "asd", 10L, TicketType.VIP, "чел"));

        // Список комманд
        commands.put("help", new HelpCommand());


        // Выполняем команду, которую ввел пользователь
        commands.get(name).execute();
    }
}
