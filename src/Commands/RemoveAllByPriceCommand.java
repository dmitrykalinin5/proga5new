package Commands;

public class RemoveAllByPriceCommand implements Command {
    private final int price;

    public RemoveAllByPriceCommand() { this.price = Integer.parseInt(price); }

    @Override
    public void execute(String[] args) {
        System.out.println("Удаления элементов с ценой: " + price);
    }

    @Override
    public String description() { return "Removes all elements from the collection where the 'price' field is equal to the specified value"; }
}
