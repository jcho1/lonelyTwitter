package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

import io.searchbox.annotations.JestId;

public abstract class Tweet implements Tweetable {
    private String tweets;
    private Date date;
    @JestId
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tweet(String message){
        this.tweets = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.tweets = message;
        this.date = date;
    }

    @Override
    public String toString(){
        return tweets;
    }

    public abstract Boolean isImportant();


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do Something!
            throw new TweetTooLongException();
        }
        this.tweets = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return tweets;
    }

    public Date getDate() {
        return date;
    }
}
