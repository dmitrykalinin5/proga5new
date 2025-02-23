package Commands;

public class RemoveHeadCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Remove head");
    }

    @Override
    public String description() { return "Displays and removes the first element from collection"; }
}
