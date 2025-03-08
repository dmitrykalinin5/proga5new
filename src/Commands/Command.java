package Commands;

public interface Command {
    void execute(String[] args);

    public String description();
}
