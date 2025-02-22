package Commands;

public class SaveCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Сохранение...");
    }
}
