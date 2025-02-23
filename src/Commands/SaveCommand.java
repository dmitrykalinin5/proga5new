package Commands;

public class SaveCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Сохранение...");
    }

    @Override
    public String description() { return "Save the collection to a file"; }
}
