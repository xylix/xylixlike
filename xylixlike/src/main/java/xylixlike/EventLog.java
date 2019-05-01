package xylixlike;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class EventLog {
    private static Deque<Map.Entry<Event, String>> eventLog = new ArrayDeque<>();

    public static void log(Event eventType, String message) {
        eventLog.add(Map.entry(eventType, message));
    }

    public static Event getLastEvent() {
        return eventLog.peekLast().getKey();
    }
}
