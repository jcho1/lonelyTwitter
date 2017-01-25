package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import static android.R.id.message;

/**
 * Created by jcho1 on 1/17/17.
 */

public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    public ArrayList<Mood> arrayList = new ArrayList<Mood>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 144) {
            throw new TweetTooLongException();
        }else{
            this.message = message;
        }
    }

    public Tweet(Date date, String message) throws TweetTooLongException {
        this.date = date;
        this.setMessage(message);
        // private String hiddenString;
        // ^ that can be change in another class using the setters
    }

    public Tweet(String message) throws TweetTooLongException {
        this.setMessage(message);
        this.date = new Date(); // current time and date
    }

    public void addHappyMood(Date date) {
        Mood mood = new happyMood(date);
        addmood(mood);
    }

    public void addSadMood(Date date) {
        Mood mood = new sadMood(date);
        addmood(mood);
    }


    public void addHappyMood() {
        Mood mood = new happyMood();
        addmood(mood);
    }

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
