package Commands;

public class ClearCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Очистка");
    }
}
