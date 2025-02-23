package Commands;

public class ExecuteScriptCommand implements Command {
    private final String file_name;

    public ExecuteScriptCommand(String file_name) { this.file_name = file_name; }

    @Override
    public void execute() {
        System.out.println("Запуск скрипта " + file_name + "...");
    }

    @Override
    public String description() { return "Executes script"; }
}
