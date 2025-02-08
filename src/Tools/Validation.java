package Tools;

public interface Validation {
    boolean validate();

    default void validateOrThrow() {
        if (!validate()) {
            throw new IllegalStateException(getErrorMessage());
        }
    }

    String getErrorMessage();
}
//    public static void idValidation(int id){
//        if (id <= 0) {
//            throw new IllegalArgumentException("id меньше или равен нулю");
//        }
//    }
//
//    public static void nameValidation(String name){
//        if (name == null || name.isEmpty()) {
//            throw new IllegalArgumentException("Ошибка в названии");
//        }
//    }
//
//    public static void coordinatesValidation(Integer x, Integer y){
//        if (x == null || y == null) {
//            throw new IllegalArgumentException("Неправильные координаты");
//        }
//    }
//
//    public static void priceValidation(Integer price) {
//        if (price == null || price <= 0) {
//            throw new IllegalArgumentException("Неправильная цена");
//        }
//    }
//
//    public static void typeValidation(String type) {
//        if (type == null) {
//            throw new IllegalArgumentException("Неправильный тип");
//        }
//    }
//
//    public static void personValidation(String person) {
//        if (person == null) {
//            throw new IllegalArgumentException("Неправильное ФИО(????)");
//        }
//    }

