package Commands;

public class Help_Command implements Command {
    Help_Command() {
        System.out.println("Help_Command");
    }

    @Override
    public void execute() {
        System.out.println("Какие-то команды");
    }
}
