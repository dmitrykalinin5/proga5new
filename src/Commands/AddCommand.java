package Commands;

public class AddCommand implements Command {
    String element;

    // Делаем из parts[1] element
    public AddCommand(String element) {
        this.element = element;
    }

    @Override
    public void execute() {
        System.out.println("Добавить элемент " + element);
    }
}
