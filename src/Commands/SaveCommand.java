package Commands;

public class SaveCommand implements Command{
    @Override
    public void execute(String[] args) {
        System.out.println("Сохранение...");
    }

    @Override
    public String description() { return "Save the collection to a file"; }
}
