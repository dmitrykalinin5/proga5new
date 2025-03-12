package Validaters;

import Tools.Validation;
import Collections.TicketType;
import Console.Client;

import java.util.Arrays;

public class BirthdayValidation implements Validation {
    private String birthday;
    private final Client client;
    private final String message;

    public BirthdayValidation(Client client, String message) {
        this.client = client;
        this.message = message;
        validation();
    }

    public String validation() {
        int[] months31 = {1, 3, 5, 7, 8, 10, 12};
        int[] months30 = {4, 6, 9, 11};
        while (true) {
            try {
                System.out.print(message);
                this.birthday = client.userInput();
                String[] input = this.birthday.split("\\.");
                int day = Integer.parseInt(input[0]);
                int month = Integer.parseInt(input[1]);
                int year = Integer.parseInt(input[2]);
                if (((day >= 1 && day <= 31 && Arrays.stream(months31).anyMatch(n -> n == month))
                || (day >= 1 && day <= 30 && Arrays.stream(months30).anyMatch(n -> n == month))
                || (day >= 1 && day <= 29 && month == 2 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)))
                || (day >= 1 && day <= 28 && month == 2 && !(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)))) && year > 0) {
                    return this.birthday;
                } else {
                    System.out.println("Некорректный ввод");
                }
            } catch (NullPointerException e) {
                System.out.println("Дата не может быть null");
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public boolean validate() {
        return birthday != null;
    }

    @Override
    public String getErrorMessage() {
        return "Ошибка в дне рождения";
    }
}
