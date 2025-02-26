package Commands;

public class HelpCommand implements Command {
//    Help_Command() {
//        System.out.println("Help_Command");
//    }

    @Override
    public void execute() {
        System.out.printf("Справка по возможным командам:\n" +
                "1. help - справка.\n" +
                "2. info - получить информацию о коллекции.\n" +
                "3. show - получить все элементы коллекции.\n" +
                "4. add {element} - добавить новый элемент в коллекцию.\n" +
                "5. update id {element} - обновить значение элемента коллекции, id которого равен заданному.\n" +
                "6. remove_by_id id - удалить элемент из коллекции по его id.\n" +
                "7. clear - очистить коллекцию.\n" +
                "8. save - сохранить коллекцию в файл.\n" +
                "9. execute_script file_name - считать и исполнить скрипт из указанного файла.\n" +
                "10. exit - завершить программу (без сохранения в файл).\n" +
                "11. remove_first - удалить первый элемент из коллекции.\n" +
                "12. remove_head - вывести первый элемент коллекции и удалить его.\n" +
                "13. history - вывести последние 13 команд без их аргументов.\n" +
                "14. remove_all_by_price (price) - удалить из коллекции все элементы, значения поля price которых равны заданному.\n" +
                "15. min_by_id - вывести любой объект из коллекции, значение поля id которого является минимальным.\n" +
                "16. group_counting_by_person - сгруппировать элементы коллекции по значению поля person, вывести количество элементов в каждой группе.\n");
    }

    @Override
    public String description() { return "Displays help information about commands"; }
}
