package data;

public final class Message {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String color;
    private final String message;
    private final long currentTime;

    public Message(long id, String firstName, String lastName, String email, String color, String message, long currentTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.color = color;
        this.message = message;
        this.currentTime = currentTime;
    }
}