package Commands;

import Collections.CollectionManager;

public class GroupCountingByPersonCommand implements Command {
    private CollectionManager collectionManager;

    public GroupCountingByPersonCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {

    }

    @Override
    public String description() {
        return "Grouping by Person";
    }
}
