package Commands;

public class HistoryCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Вывод истории команд");
    }

    @Override
    public String description() { return "Displays the last 13 entered commands"; }
}
