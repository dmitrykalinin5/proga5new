package Validaters;

import Tools.Validation;
import Console.Client;

public class PriceValidation implements Validation {
    private Long price;
    private final Client client;
    private final String message;

    public PriceValidation(Client client, String message) {
        this.client = client;
        this.message = message;
        validation();
    }

    public Long validation() {
        while (true) {
            try {
                System.out.print(message);
                this.price = Long.parseLong(client.userInput());
                if (!validate()) {
                    System.out.println("Цена должна быть больше 0");
                    continue;
                }
                return this.price;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public Long getPrice() { return price; }

    @Override
    public boolean validate() {return price > 0;}

    @Override
    public String getErrorMessage() {return "Ошибка в цене";}
}