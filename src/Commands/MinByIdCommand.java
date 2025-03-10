package Commands;

import Collections.CollectionManager;

public class MinByIdCommand implements Command {
    private CollectionManager collectionManager;

    public MinByIdCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        String element = collectionManager.getByMinimumId().toString();
        System.out.println("Элемент с минимальным айди:\n" + element);
    }

    @Override
    public String description() { return "Displays the element from collection which id is minimum"; }
}
