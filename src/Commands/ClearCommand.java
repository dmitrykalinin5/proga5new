package Commands;

public class ClearCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Очистка");
    }

    @Override
    public String description() { return "Clears collection"; }
}
