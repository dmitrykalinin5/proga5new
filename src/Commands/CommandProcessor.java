package Commands;

import Collections.CollectionManager;
import Commands.CommandProcessor;

import java.util.*;

public class CommandProcessor {
    private final Map<String, Command> commands = new HashMap<>();
    private final CollectionManager collectionManager;
    private Deque<String> historyDeque;

    public CommandProcessor(CollectionManager collectionManager, Deque<String> historyDeque) {
        this.collectionManager = collectionManager;
        this.historyDeque = historyDeque;
    }

    public void CommandPut() {
        // Список команд
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand(collectionManager));
        commands.put("show", new ShowCommand(collectionManager));
        commands.put("clear", new ClearCommand(collectionManager));
        commands.put("save", new SaveCommand(collectionManager));
        commands.put("remove_first", new RemoveFirstCommand(collectionManager));
        commands.put("remove_head", new RemoveHeadCommand(collectionManager));
        commands.put("history", new HistoryCommand(new CommandProcessor(collectionManager, historyDeque)));
        commands.put("min_by_id", new MinByIdCommand(collectionManager));
        //commands.put("group_counting_by_person", new Command(collectionManager));
        commands.put("exit", new ExitCommand());

        // Команды с аргументами
        commands.put("add", new AddCommand(collectionManager));
        commands.put("update", new UpdateIdCommand());
        commands.put("remove_by_id", new RemoveByIdCommand(collectionManager));
        commands.put("execute_script", new ExecuteScriptCommand(new CommandProcessor(collectionManager, historyDeque)));
        commands.put("remove_all_by_price", new RemoveAllByPriceCommand(collectionManager));
    }

    /**
     * Метод, который выполняет программу
     * @param input, входные данные (сама команда)
     */
    public void executeCommand(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];
        Command command = commands.get(commandName);
//        System.out.println("Parts: " + Arrays.toString(parts));
//        System.out.println("Значение: " + commandName);
        try {
            command.execute(parts);
            saveCommand(parts[0]);
        } catch (NullPointerException exeption) {
            System.out.println("Такой команды не существует " + exeption.getMessage());
        }
    }

    public void saveCommand(String command) {
        int maxSize = 13;
        if (this.historyDeque.size() >= maxSize) {
            this.historyDeque.removeFirst();
        }
        this.historyDeque.addLast(command);
    }

    public Deque<String> getDeque() {
        return this.historyDeque;
    }
}
