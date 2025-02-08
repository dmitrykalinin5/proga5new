package Server.Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commands;

    public void CommandPut(String name) {
        // Словарь
        commands = new HashMap<>();

        // Список комманд
        commands.put("help", new HelpCommand());


        // Выполняем команду, которую ввел пользователь
        commands.get(name).execute();
    }
}
