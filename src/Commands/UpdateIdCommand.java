package Commands;

public class UpdateIdCommand implements Command {
    private String id;
    // Потом переделай string в int

    public UpdateIdCommand(String id) { this.id = id;}

    @Override
    public void execute() {
        System.out.println("Апдейдим айди " + id);
    }
}
