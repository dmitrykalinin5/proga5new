package Validaters;

import Tools.Validation;
import Console.Client;

/**
 * Класс для валидации роста
 */
public class HeightValidation implements Validation {
    private Long Height;
    private final Client client;
    private final String message;

    /**
     * Конструктор класса
     * @param client
     * @param message
     */
    public HeightValidation(Client client, String message) {
        this.client = client;
        this.message = message;
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
                this.Height = Long.parseLong(client.userInput());
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