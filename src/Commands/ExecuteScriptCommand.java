package Commands;

public class ExecuteScriptCommand implements Command {

    public ExecuteScriptCommand() {}

    @Override
    public void execute(String[] args) {
        String command = args[0];
        String file_name = args[1];
        System.out.println("Запуск скрипта " + file_name + "...");
    }

    @Override
    public String description() { return "Executes script"; };
}
