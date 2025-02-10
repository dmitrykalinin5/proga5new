package Collections;

public enum TicketType {
    VIP,
    USUAL,
    CHEAP;

    public static String types() {
        StringBuilder list = new StringBuilder();
        for (var TicketType : values()) {
            list.append(TicketType.name()).append(", ");
            }
        return list.substring(0, list.length() - 2);
    }
}
