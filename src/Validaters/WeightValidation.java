package Validaters;

import Tools.Validation;
import Console.Client;

/**
 * Класс для валидации роста
 */
public class WeightValidation implements Validation {
    private int weight;
    private final Client client;
    private final String message;

    /**
     * Конструктор класса
     * @param client
     * @param message
     */
    public WeightValidation(Client client, String message) {
        this.client = client;
        this.message = message;
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
                this.weight = Integer.parseInt(client.userInput());
                if (!validate()) {
                    System.out.println("Рост должен быть больше 0");
                    continue;
                }
                return this.weight;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public int getweight() { return weight; }

    @Override
    public boolean validate() {return weight > 0;}

    @Override
    public String getErrorMessage() {return "Ошибка в росте";}
}