package Validaters;

import Commands.CommandProcessor;
import Tools.Validation;
import Console.Client;

import java.util.Scanner;

/**
 * Класс для валидации роста
 */
public class WeightValidation implements Validation {
    private int weight;
    private final String message;
    private CommandProcessor commandProcessor;

    /**
     * Конструктор класса
     * @param message
     */
    public WeightValidation(String message, CommandProcessor commandProcessor) {
        this.message = message;
        this.commandProcessor = commandProcessor;
        validation();
    }

    /**
     * Метод, который валидирует
     * @return this.weight, если валидация прошла успешно
     */
    public int validation() {
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
                this.weight = Integer.parseInt(input);
                if (!validate()) {
                    System.out.println("Вес должен быть больше 0");
                    continue;
                }
                return this.weight;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Некорректный ввод" + e.getMessage());
            }
        }
    }

    public int getweight() { return weight; }

    @Override
    public boolean validate() {return weight > 0;}

    @Override
    public String getErrorMessage() {return "Ошибка в росте";}
}