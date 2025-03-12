//package Commands;
//
//import Collections.Coordinates;
//import Collections.TicketType;
//import Validaters.*;
//
//public class TestCommand implements Command {
//    private final int id;
//    private final NameValidation name;
//    private final Coordinates coordinates;
//    private final CoordinatesValidation coordinatesValidation;
//    private final String creationDate;
//    //private final CreationDateValidation creationDateValidation;
//    private final PriceValidation price;
//    private final TicketType type;
//    private final String person;
//
//    public TestCommand(int id, String name, Coordinates coordinates, String creationDate , Long price, TicketType type, String person) {
//        this.id = 123; // сделать так, чтобы было на 1 больше предыдущего id
//        this.name = new NameValidation("Братиш");
//        this.coordinates = coordinates;
//        this.coordinatesValidation = new CoordinatesValidation(coordinates, 5, 4);
//        this.creationDate = "asd";
//        //this.creationDateValidation = new CreationDateValidation(creationDate);
//        this.price = new PriceValidation(10L);
//        this.type = type;
//        this.person = person;
//    }
//    @Override
//    public void execute(String[] args) {
//        System.out.println(toString()); }
//
//    @Override
//    public String toString() {
//        return  "Ticket{\"id\" : " + id + ", \"name\" : \"" + name.getName() + "\", \"coordinates\" : (" +
//                coordinates + ", " + coordinates + "), \"Дата покупки\" : "
//                + "creationDateValidation" + ", \"Цена\":" + price.getPrice() + "" +
//                ", \"Тип билета\" : " + type + ", \"ФИО\":" + person + "}";
//    }
//
//    @Override
//    public String description() { return null; }
//}
