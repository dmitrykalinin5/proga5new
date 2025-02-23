package Commands;

public class RemoveByIdCommand implements Command{
    private final int id;

    public RemoveByIdCommand(String id) { this.id = Integer.parseInt(id); }

    @Override
    public void execute() {
        System.out.println("Убираем элемент с айди: " + id);
    }

    @Override
    public String description() { return "Removes an element by its id"; }
}
