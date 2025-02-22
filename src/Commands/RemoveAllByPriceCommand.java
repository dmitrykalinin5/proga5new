package Commands;

public class RemoveAllByPriceCommand implements Command {
    private final int price;

    public RemoveAllByPriceCommand(String price) { this.price = Integer.parseInt(price); }

    @Override
    public void execute() {
        System.out.println("Удаления элементов с ценой: " + price);
    }
}
