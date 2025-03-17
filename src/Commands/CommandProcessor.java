package Commands;

import Collections.CollectionManager;
import Commands.CommandProcessor;

import java.util.*;

public class CommandProcessor {
    private final Map<String, Command> commands = new HashMap<>();
    private final CollectionManager collectionManager;
    private Deque<String> historyDeque;
    private Queue<String> inputQueue = new LinkedList<>();
    private boolean scriptFlag = false;
    private List<String> bannedFiles = new ArrayList<>();
    private Deque<String> commandStack = new ArrayDeque<>();

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
        commands.put("history", new HistoryCommand(this));
        commands.put("min_by_id", new MinByIdCommand(collectionManager));
        //commands.put("group_counting_by_person", new Command(collectionManager));
        commands.put("exit", new ExitCommand());

        // Команды с аргументами
        commands.put("add", new AddCommand(collectionManager, historyDeque, this));
        commands.put("update", new UpdateIdCommand(collectionManager, historyDeque, this));
        commands.put("remove_by_id", new RemoveByIdCommand(collectionManager));
        commands.put("execute_script", new ExecuteScriptCommand(this));
        commands.put("remove_all_by_price", new RemoveAllByPriceCommand(collectionManager));
    }

    public void executeScript() {
        String currentCommand = getNextCommand();
        String[] args = currentCommand.split(" ");
        System.out.println("Текущая команда: " + currentCommand);
        if (args[0].equals("execute_script") && bannedFiles.contains(args[1])) {
            System.out.println("Скрипт не может вызывать сам себя");
//        } else if (args[0].equals("execute_script") && !bannedFiles.contains(args[1])) {
//            bannedFiles.add(args[1]);
//            System.out.println("Скрипт не может вызывать себя или другой скрипт в котором содержится этот");
        } else {
            Command command = commands.get(args[0]);
            command.execute(args);
            saveCommand(args[0]);
        }
    }

    public void setCommandStack(Deque<String> commandStack) {
        this.commandStack = commandStack;
    }

    public String removeFirstCommandStack() {
        return commandStack.removeFirst();
    }

    public String removeLastCommandStack() {
        return commandStack.removeLast();
    }

    public Deque<String> getCommandStack() {
        return commandStack;
    }

    public void addFirstCommandtoStack(String command) {
        commandStack.addFirst(command);
    }

    public void addLastCommandtoStack(String command) {
        commandStack.addLast(command);
    }

    public String getNextCommand() {
        return this.commandStack.removeFirst().trim();
    }

    public void setScriptFlag(boolean flag) {
        this.scriptFlag = flag;
    }

    public boolean getScriptFlag() {
        return scriptFlag;
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
        } catch (NullPointerException exception) {
            System.out.println("Такой команды не существует");
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

    public List<String> getBannedFiles() {
        return bannedFiles;
    }

    public void setBannedFiles(List<String> bannedFiles) {
        this.bannedFiles = bannedFiles;
    }
}
