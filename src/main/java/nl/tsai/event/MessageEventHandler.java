package nl.tsai.event;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

/**
 * https://docs.oracle.com/javaee/6/tutorial/doc/gkhic.html
 */
@Stateless
public class MessageEventHandler {
    public void onMessageEvent(@Observes(during = TransactionPhase.AFTER_SUCCESS) @Message MessageEvent messageEvent) {
        String msg = String.format("AFTER_SUCCESS - %s - %s%n", messageEvent.getDate(), messageEvent.getText());
        System.out.println(msg);
    }
    public void onMessageEvent2(@Observes(during = TransactionPhase.AFTER_COMPLETION) @Message MessageEvent messageEvent) {
        String msg = String.format("AFTER_COMPLETION - %s - %s%n", messageEvent.getDate(), messageEvent.getText());
        System.out.println(msg);
    }
    public void onMessageEvent3(@Observes(during = TransactionPhase.IN_PROGRESS) @Message MessageEvent messageEvent) {
        String msg = String.format("IN_PROGRESS - %s - %s%n", messageEvent.getDate(), messageEvent.getText());
        System.out.println(msg);
    }
    public void onMessageEvent4(@Observes(during = TransactionPhase.AFTER_FAILURE) @Message MessageEvent messageEvent) {
        String msg = String.format("AFTER_FAILURE - %s - %s%n", messageEvent.getDate(), messageEvent.getText());
        System.out.println(msg);
    }
    public void onMessageEvent5(@Observes(during = TransactionPhase.BEFORE_COMPLETION) @Message MessageEvent messageEvent) {
        String msg = String.format("BEFORE_COMPLETION - %s - %s%n", messageEvent.getDate(), messageEvent.getText());
        System.out.println(msg);
    }
}
