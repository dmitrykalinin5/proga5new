package Commands;

public class InfoCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Справка по коллекции");
    }

    @Override
    public String description() { return "Displays information about the collection"; }
}
