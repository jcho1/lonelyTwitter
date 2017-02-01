package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * <p>
 * This class is a subclass of Tweet
 * In this class tweets are created and given true in isImportant booleans
 * </p>
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public ImportantTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + "!!!!";
    }
}
