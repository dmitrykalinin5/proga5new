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
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand(collectionManager));
        commands.put("remove_first", new RemoveFirstCommand());
        commands.put("remove_head", new RemoveHeadCommand());
        commands.put("history", new HistoryCommand());
        commands.put("min_by_id", new MinByIdCommand(collectionManager));
        //commands.put("group_counting_by_person", new Command(collectionManager));
        commands.put("exit", new ExitCommand());

        // Команды с аргументами
        commands.put("add", new AddCommand(collectionManager));
        commands.put("update", new UpdateIdCommand());
        commands.put("remove_by_id", new RemoveByIdCommand(collectionManager));
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("remove_all_by_price", new RemoveAllByPriceCommand(collectionManager));
    }

    public void executeCommand(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];
        Command command = commands.get(commandName);
        try {
            command.execute(parts);
        } catch (NullPointerException exeption) {
            System.out.println("Такой команды не существует");
        }
    }
}
