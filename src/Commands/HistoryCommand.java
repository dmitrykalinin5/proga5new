package Commands;

public class HistoryCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Вывод истории команд");
    }
}
