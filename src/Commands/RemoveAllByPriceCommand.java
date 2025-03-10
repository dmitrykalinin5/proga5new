package Commands;

import Collections.CollectionManager;

public class RemoveAllByPriceCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveAllByPriceCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            int price = Integer.parseInt(args[1]);
            boolean result = collectionManager.removeAllByPrice(price);
            if (result) {
                System.out.println("Элементы успешно удалены");
            } else {
                System.out.println("Элементов с такой ценой нет");
            }
        } catch (NumberFormatException e) {
            System.out.println("Цена должна быть числом");
        }
    }

    @Override
    public String description() { return "Removes all elements from the collection where the 'price' field is equal to the specified value"; }
}
