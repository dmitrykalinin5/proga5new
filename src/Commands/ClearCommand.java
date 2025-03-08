package Commands;

public class ClearCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Очистка");
    }

    @Override
    public String description() { return "Clears collection"; }
}
