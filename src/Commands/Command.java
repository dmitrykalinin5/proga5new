package Commands;

public interface Command {
    /**
     * Метод, который выполняет команду
     * @param args
     */
    void execute(String[] args);

    /**
     * Метод, который возвращает описание команды
     * @return String, описание;
     */
    public String description();
}
