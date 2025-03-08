package Commands;

public class UpdateIdCommand implements Command {
    private int id;
    // Потом переделай string в int

    public UpdateIdCommand() { this.id = Integer.parseInt(id);}

    @Override
    public void execute(String[] args) {
        System.out.println("Апдейдим айди " + id);
    }

    @Override
    public String description() { return "Обновить айди вроде"; }
}
