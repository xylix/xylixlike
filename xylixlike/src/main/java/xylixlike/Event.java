package xylixlike;

public class Event {
    public enum Type {
        INTERACTION,
        MOVEMENT;
    }
    public Type type;
    public String message;

    public Event(Type type, String message) {
        this.type = type;
        this.message = message;
    }

}
