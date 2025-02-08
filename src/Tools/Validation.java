package Tools;

public class Validation {

    public static void idValidation(int id){
        if (id <= 0) {
            throw new IllegalArgumentException("id меньше или равен нулю");
        }
    }

    public static void nameValidation(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ошибка в названии");
        }
    }

    public static void coordinatesValidation(Integer x, Integer y){
        if (x == null || y == null) {
            throw new IllegalArgumentException("Неправильные координаты");
        }
    }

    public static void
}
