package Validaters;

import Commands.CommandProcessor;
import Tools.Validation;
import Console.Client;

import java.util.Scanner;

/**
 * Класс для валидации роста
 */
public class HeightValidation implements Validation {
    private Long Height;
    private final String message;
    private CommandProcessor commandProcessor;

    /**
     * Конструктор класса
     * @param message
     */
    public HeightValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
        validation();
    }

    /**
     * Метод, который валидирует
     * @return
     */
    public Long validation() {
        while (true) {
            try {
                System.out.print(message);
                String input;
                if (commandProcessor.getScriptFlag()) {
                    input = commandProcessor.getNextCommand().trim();
                    System.out.println(input);
                } else {
                    Scanner scanner = new Scanner(System.in);
                    input = scanner.nextLine().trim();
                }
                this.Height = Long.parseLong(input);
                if (!validate()) {
                    System.out.println("Рост должен быть больше 0");
                    continue;
                }
                return this.Height;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public Long getHeight() { return Height; }

    @Override
    public boolean validate() {return Height != null && Height > 0;}

    @Override
    public String getErrorMessage() {return "Ошибка в росте";}
}