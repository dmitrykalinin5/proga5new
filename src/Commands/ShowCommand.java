package Commands;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Все элементы коллекции");
    }

    @Override
    public String description() { return "Displays all elements from collection"; }
}
