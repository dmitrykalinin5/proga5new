package Commands;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Справка по коллекции");
    }
}
