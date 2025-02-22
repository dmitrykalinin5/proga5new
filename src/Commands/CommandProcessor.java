package Commands;

import Collections.Coordinates;
import Collections.TicketType;
import Validaters.CreationDateValidation;
import Errors.InvalidInput;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();

    public void CommandPut(String name) {
        // Словарь

        // Делим команду, чтобы в будущем посмотреть есть ли переменная
        String[] parts = name.split(" ");

        // Тестовая команда
//        commands.put("test", new TestCommand(123, "Брат",
//                new Coordinates(3, 4), "asd", 10L, TicketType.VIP, "чел"));

        // Выполняем команду, которую ввел пользователь
        if (parts.length == 1 && parts[0] != null) {
            // Список команд
            commands.put("help", new HelpCommand());
            commands.put("info", new InfoCommand());
            commands.put("show", new ShowCommand());
            commands.put("clear", new ClearCommand());
            commands.put("save", new SaveCommand());
            commands.put("remove_first", new RemoveFirstCommand());
            commands.put("remove_head", new RemoveHeadCommand());
            commands.put("history", new HistoryCommand());
            commands.put("min_by_id", new MinByIdCommand());
            commands.put("group_counting_by_person", new ClearCommand());
            commands.put("exit", new ExitCommand());

            // Смотрим есть ли команда в словаре, выполняем команду
            if (commands.containsKey(parts[0]))
            { commands.get(parts[0]).execute(); } else System.out.println("Команда не найдена");
        } else if (parts.length == 2 && parts[0] != null && parts[1] != null) {
            // Список команд с переменными
            commands.put("add" + parts[1], new AddCommand(parts[1]));
            commands.put("update_id" + parts[1], new UpdateIdCommand(parts[1]));
            commands.put("remove_by_id" + parts[1], new RemoveByIdCommand(parts[1]));
            commands.put("execute_script" + parts[1], new ExecuteScriptCommand(parts[1]));
            commands.put("remove_all_by_price" + parts[1], new RemoveAllByPriceCommand(parts[1]));


            // Смотрим есть ли команда в словаре, выполняем команду
            if (commands.containsKey(parts[0] + parts[1]))
            { commands.get(parts[0] + parts[1]).execute(); } else System.out.println("Команда не найдена");
        } else System.out.println("Команда не найдена");
    }
}
