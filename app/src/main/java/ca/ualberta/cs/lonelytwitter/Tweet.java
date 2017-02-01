package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import static android.R.id.message;

/**
 * Created by jcho1 on 1/17/17.
 *
 * Tweet class is a super class that implements Tweetable
 */
public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    /**
     * The Array list.
     */
    public ArrayList<Mood> arrayList = new ArrayList<Mood>();

    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 144) {
            throw new TweetTooLongException();
        }else{
            this.message = message;
        }
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
        // private String hiddenString;
        // ^ that can be change in another class using the setters
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date(); // current time and date
    }

    /**
     * Add happy mood.
     *
     * @param date the date
     */
    public void addHappyMood(Date date) {
        Mood mood = new happyMood(date);
        addmood(mood);
    }

    /**
     * Add sad mood.
     *
     * @param date the date
     */
    public void addSadMood(Date date) {
        Mood mood = new sadMood(date);
        addmood(mood);
    }


    /**
     * Add happy mood.
     */
    public void addHappyMood() {
        Mood mood = new happyMood();
        addmood(mood);
    }

    /**
     * Add sad mood.
     */
    public void addSadMood() {
        Mood mood = new sadMood();
        addmood(mood);
    }

    private void addmood(Mood mood){
        arrayList.add(mood);
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
