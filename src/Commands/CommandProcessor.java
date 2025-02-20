package Commands;

import Collections.Coordinates;
import Collections.TicketType;
import Validaters.CreationDateValidation;
import Errors.InvalidInput;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commands;

    public void CommandPut(String name) {
        // Словарь
        commands = new HashMap<>();

        // Делим команду, чтобы в будущем посмотреть есть ли переменная
        String[] parts = name.split(" ");

        // Тестовая команда
//        commands.put("test", new TestCommand(123, "Брат",
//                new Coordinates(3, 4), "asd", 10L, TicketType.VIP, "чел"));

        // Выполняем команду, которую ввел пользователь
        if (parts.length == 1 && name != null) {
            // Список команд
            commands.put("help", new HelpCommand());
            commands.put("info", new InfoCommand());
            commands.put("show", new ShowCommand());

            // Смотрим есть ли команда в словаре, выполняем команду
            if (commands.containsKey(parts[0]))
            { commands.get(name).execute(); } else System.out.println("Команда не найдена");
        } else if (parts.length == 2 && parts[0] != null && parts[1] != null) {
            // Список команд с переменными
            commands.put("add" + parts[1], new AddCommand(parts[1]));

            // Смотрим есть ли команда в словаре, выполняем команду
            if (commands.containsKey(parts[0] + parts[1]))
            { commands.get(parts[0] + parts[1]).execute(); } else System.out.println("Команда не найдена");
        } else System.out.println("Команда не найдена");
    }
}
