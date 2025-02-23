package Commands;

public class HelpCommand implements Command {
//    Help_Command() {
//        System.out.println("Help_Command");
//    }

    @Override
    public void execute() {
        System.out.println("Лови хелпу убежище");
    }

    @Override
    public String description() { return "Displays help information about commands"; }
}
