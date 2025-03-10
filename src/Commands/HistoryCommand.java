package Commands;

import Commands.HistoryCommand;

public class HistoryCommand implements Command {
    private CommandProcessor commandProcessor;

    public HistoryCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    @Override
    public void execute(String[] args) {
        String[] commands = commandProcessor.getDeque().toArray(new String[0]);
        System.out.println("Список последних 13 команд:");
        for (int i = commands.length - 1, index = 1; i >= 0; i--, index++) {
            System.out.println(index + ". " + commands[i]);
        }
    }

    @Override
    public String description() { return "Displays the last 13 entered commands"; }
}
