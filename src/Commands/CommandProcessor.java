package Commands;

import Collections.CollectionManager;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commands = new HashMap<>();
    private final CollectionManager collectionManager;

    public CommandProcessor(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void CommandPut() {
        // Список команд
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand(collectionManager));
        commands.put("remove_first", new RemoveFirstCommand());
        commands.put("remove_head", new RemoveHeadCommand());
        commands.put("history", new HistoryCommand());
        commands.put("min_by_id", new MinByIdCommand());
        commands.put("group_counting_by_person", new ClearCommand());
        commands.put("exit", new ExitCommand());

        // Команды с аргументами
        commands.put("add", new AddCommand(collectionManager));
        commands.put("update", new UpdateIdCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("remove_all_by_price", new RemoveAllByPriceCommand());
    }

    public void executeCommand(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];
        Command command = commands.get(commandName);
        command.execute(parts);
    }
}
