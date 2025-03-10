package Commands;

import Collections.CollectionManager;

import java.util.Collection;

public class RemoveByIdCommand implements Command{
    private CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            int id = Integer.parseInt(args[1]);
            if (collectionManager.removeById(id)) {
                System.out.println("Removed " + id + " from the collection");
            } else {
                System.out.println("Could not remove " + id + " from the collection");
            }
        } catch (NumberFormatException e) {
            System.out.println("id должно быть числом");
        }
    }

    @Override
    public String description() { return "Removes an element by its id"; }
}
