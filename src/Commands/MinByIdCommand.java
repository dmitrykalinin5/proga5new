package Commands;

public class MinByIdCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Минимальный по айди");
    }

    @Override
    public String description() { return "Displays the element from collection which id is minimum"; }
}
