package Commands;

/**
 * Команда для завершения работы программы.
 * Этот класс реализует команду, которая завершает выполнение программы.
 */
public class ExitCommand implements Command {

    /**
     * Выполняет команду завершения программы.
     * Этот метод вызывает системное завершение программы с кодом 0.
     *
     * @param args Аргументы команды (не используются в данном случае)
     */
    @Override
    public void execute(String[] args) {
        System.exit(0);
    }

    /**
     * Описание команды.
     *
     * @return Описание команды, которая завершает выполнение программы
     */
    @Override
    public String description() {
        return "Exits the program";
    }
}
