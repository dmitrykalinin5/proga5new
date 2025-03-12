package Validaters;

import Console.Client;
import Tools.Validation;

public class NameValidation implements Validation {
    private String name;
    private Client client;
    private String message;

    public NameValidation(Client client, String message) {
        this.client = client;
        this.message = message;
        validation();
    }

    public String validation() {
        while (true) {
            try {
                System.out.print(message);
                this.name = client.userInput();
                if (!validate()) {
                    System.out.println("Неверный формат ввода.");
                    continue;
                }
                return this.name;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public String getName() { return name; }

    @Override
    public boolean validate() {
        return name != null && !name.isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return "Ошибка в ID";
    }
}