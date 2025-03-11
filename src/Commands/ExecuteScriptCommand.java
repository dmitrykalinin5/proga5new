package Commands;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;

/**
 * Класс, который читает файл построчно и выполняет команды, которые в нем находятся
 */
public class ExecuteScriptCommand implements Command {
    private CommandProcessor commandProcessor;

    public ExecuteScriptCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    private String[] readFile(String fileName) {
        try {
            String[] content = Files.readString(Path.of(fileName)).split("\n");
            return content;
        } catch (NoSuchFileException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void execute(String[] args) {
        String file_name = args[1];
        String[] fileInput = readFile(file_name);
//        System.out.println("чо в файле:" + Arrays.toString(fileInput));
//        System.out.println("отдельыый элемент " + fileInput[0]);
//        System.out.println("длина файла " + fileInput.length);
        // Если файл не был найден или произошла ошибка при его чтении, завершаем выполнение метода
        if (fileInput == null) {
            return;  // Останавливаем выполнение метода
        }
        // нерабочий If
        if (fileInput[0] == null) {
            System.out.println("Файл пустой");
            return;
        }
        System.out.println("Запуск скрипта " + file_name + "...");
        for (String command : fileInput) {
            command = command.trim();
            System.out.println("Выполнение команды: " + command.split(" ")[0]);
            //System.out.println(command);
            commandProcessor.CommandPut();
            commandProcessor.executeCommand(command);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Скрипт выполнен");
    }

    @Override
    public String description() { return "Executes script"; };
}
