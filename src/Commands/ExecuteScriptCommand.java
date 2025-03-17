package Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Commands.Command;
import Commands.CommandProcessor;

public class ExecuteScriptCommand implements Command {
    private final CommandProcessor commandProcessor;
    private Deque<String> localCommandStack = new ArrayDeque<>();

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
        List<String> bannedFiles = commandProcessor.getBannedFiles();
        String fileName = args[1];
        String[] fileInput = readFile(fileName);
        if (fileInput == null) return;

        Deque<String> newCommands = new ArrayDeque<>();

        // Заполняем стек с командами из файла
        for (String line : fileInput) {
            if (line.split(" ").length > 1 && Objects.equals(line.split(" ")[1], fileName)) {
                localCommandStack.addFirst(line);
                commandProcessor.addFirstCommandtoStack(line);
                bannedFiles.add(line.split(" ")[1]);
                commandProcessor.setBannedFiles(bannedFiles);
//            } else if (line.split(" ").length > 1 && !Objects.equals(line.split(" ")[1], fileName)) {
//                localCommandStack.addFirst(line);
//                Deque<String> helpfulCommandStack = new ArrayDeque<>();
//                for (String element : commandProcessor.getCommandStack()) {
//                    helpfulCommandStack.addFirst(commandProcessor.removeFirstCommandStack());
//                }
//                for (String element : localCommandStack) {
//                    helpfulCommandStack.addFirst(localCommandStack.removeFirst());
//                }
//                for (String element : helpfulCommandStack) {
//                    System.out.println("helpful " + element);
//                }
//                commandProcessor.setCommandStack(helpfulCommandStack);
            } else {
//                commandProcessor.addFirstCommandtoStack(line);
            }
        }

        Deque<String> mergeStack = new ArrayDeque<>(newCommands);



        commandProcessor.CommandPut();
        while (!commandProcessor.getCommandStack().isEmpty()) {
            commandProcessor.executeScript();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        commandProcessor.setScriptFlag(false);
    }

    @Override
    public String description() {
        return "Executes script";
    }
}