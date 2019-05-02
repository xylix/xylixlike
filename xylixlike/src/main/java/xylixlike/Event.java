package xylixlike;

public class Event {
    public enum Type {
        INTERACTION,
        MOVEMENT
    }
    public final Type type;
    public final String message;

    public Event(Type type, String message) {
        this.type = type;
        this.message = message;
    }

}
