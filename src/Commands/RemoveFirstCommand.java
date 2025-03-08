package Commands;

public class RemoveFirstCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Remove first command");
    }

    @Override
    public String description() { return "Removes the first element from collection"; }
}
