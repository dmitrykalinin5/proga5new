package Commands;

public class ExecuteScriptCommand implements Command {
    private final String file_name;

    public ExecuteScriptCommand() { this.file_name = file_name; }

    @Override
    public void execute(String[] args) {
        System.out.println("Запуск скрипта " + file_name + "...");
    }

    @Override
    public String description() { return "Executes script"; }
}
