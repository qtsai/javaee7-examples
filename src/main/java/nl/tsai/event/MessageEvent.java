package nl.tsai.event;

import java.time.LocalDate;

/**
 * https://docs.oracle.com/javaee/6/tutorial/doc/gkhic.html
 */
public class MessageEvent {
    private final LocalDate date;
    private final String text;

    public MessageEvent(String text) {
        this.text = text;
        this.date = LocalDate.now();
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }
}
