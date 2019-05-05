package xylixlike;

import java.util.ArrayDeque;
import java.util.Deque;

public final class EventLog {

    private EventLog() {
        throw new IllegalStateException("Utility class");
    }

    private static Deque<Event> eventDeque = new ArrayDeque<>();

    public static void log(Event.Type eventType, String message) {
        eventDeque.add(new Event(eventType, message));
    }

    public static Event getLastEvent() {
        return eventDeque.peekLast();
    }
}
