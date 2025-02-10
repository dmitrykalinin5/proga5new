package Validaters;

import Tools.Validation;

public class PriceValidation implements Validation {
    private final Long price;

    public PriceValidation(Long price) {
        this.price = price;
    }

    public Long getPrice() { return price; }

    @Override
    public boolean validate() {return price != null && price > 0;}

    @Override
    public String getErrorMessage() {return "Ошибка в цене";}
}
