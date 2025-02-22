package Commands;

public class UpdateIdCommand implements Command {
    private final int id;

    public UpdateIdCommand(String id) { this.id = Integer.parseInt(id); }

    @Override
    public void execute() {
        System.out.println("Обновляем значение id: " + id);
    }
}
