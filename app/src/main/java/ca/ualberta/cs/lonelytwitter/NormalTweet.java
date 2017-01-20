package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jcho1 on 1/17/17.
 */

public class NormalTweet extends Tweet {
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

    public NormalTweet(Date date, String message) throws TweetTooLongException {
        super(date, message);
    }

    public NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }
}
