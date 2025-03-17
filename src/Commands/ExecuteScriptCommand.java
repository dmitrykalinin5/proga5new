package Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ExecuteScriptCommand implements Command {
    private final CommandProcessor commandProcessor;

    public ExecuteScriptCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    private String[] readFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName)).split("\n");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void execute(String[] args) {
        commandProcessor.setScriptFlag(true);
        Set<String> bannedFiles = new HashSet<>(commandProcessor.getBannedFiles());
        String fileName = args[1];

        if (bannedFiles.contains(fileName)) {
            System.out.println("Предотвращено рекурсивное выполнение: " + fileName);
            return;
        }

        String[] fileInput = readFile(fileName);
        if (fileInput == null) return;

        // баним файл
        bannedFiles.add(fileName);
        commandProcessor.setBannedFiles(new ArrayList<>(bannedFiles));

        Deque<String> newCommands = new ArrayDeque<>();

        // заполняем дек
        for (String line : fileInput) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length > 1 && "execute_script".equals(parts[0])) {
                String nextFile = parts[1];
                if (!bannedFiles.contains(nextFile)) {
                    newCommands.addLast(line);
                } else {
                    System.out.println("Игнорируем рекурсивный вызов: " + nextFile);
                }
            } else {
                newCommands.addLast(line);
            }
        }

        Deque<String> mergeStack = new ArrayDeque<>(newCommands);
        mergeStack.addAll(commandProcessor.getCommandStack());
        commandProcessor.setCommandStack(mergeStack);
//        for (String element : mergeStack) {
//            System.out.println(element);
//        }

        commandProcessor.CommandPut();
        try {
            while (!commandProcessor.getCommandStack().isEmpty()) {
                commandProcessor.executeScript();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Ошибка, элементы кончились. Проверьте правильность введенных вами команд, скорее всего проблема в них.");
        }
        commandProcessor.setScriptFlag(false);
    }

    @Override
    public String description() {
        return "Executes script";
    }
}