package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * <p>
 * This class is a subclass of Tweet
 * In this class tweets are created and given false in isImportant booleans
 * </p>
 */
public class NormalTweet extends Tweet {
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public NormalTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }
}
