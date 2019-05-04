package xylixlike;

import java.util.ArrayDeque;
import java.util.Deque;

public final class EventLog {


    private static Deque<Event> eventLog = new ArrayDeque<>();

    public static void log(Event.Type eventType, String message) {
        eventLog.add(new Event(eventType, message));
    }

    public static Event getLastEvent() {
        return eventLog.peekLast();
    }
}
