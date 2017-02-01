package ca.ualberta.cs.lonelytwitter;

/**
 * Created by jcho1 on 1/17/17.
 * This class handles the errors when the tweets are too long
 */
public class TweetTooLongException extends Exception {
    /**
     * Instantiates a new Tweet too long exception.
     */
    public TweetTooLongException() {
    }

    /**
     * Instantiates a new Tweet too long exception.
     *
     * @param detailMessage the detail message
     */
    public TweetTooLongException(String detailMessage) {
        super(detailMessage);
    }
}
