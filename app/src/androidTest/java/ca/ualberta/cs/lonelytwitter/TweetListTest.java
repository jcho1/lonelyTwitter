package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

/**
 * Created by jcho1 on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public  TweetListTest(){

        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet tweet");

        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

    }

    public void testGetTweet(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test test tweet tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(tweet.getMessage(), returnedTweet.getMessage());
        assertEquals(tweet.getDate(), returnedTweet.getDate());

    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Delete this tweet");

        tweets.add(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testStrings(){
        assertEquals("'test' should be 'test'","test","test");
        assertTrue("'test' should start with 't'", "test".startsWith("t"));
    }

    public void testDoubleTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("double this tweet");

        tweets.add(tweet);
        try {
            tweets.add(tweet);
            fail();
        }catch (IllegalArgumentException exception){

        };
    }


    public void testGetList(){
        ArrayList<Tweet> tweetlist = new ArrayList<Tweet>();
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet1");
        Tweet tweet2 = new NormalTweet("test tweet2");

        tweets.add(tweet);
        tweets.add(tweet2);
        tweetlist.add(tweet);
        tweetlist.add(tweet2);

        ArrayList<Tweet> returnedList = tweets.getTweets();

        assertEquals(tweetlist, returnedList);

    }

    public void testcount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet1");
        Tweet tweet2 = new NormalTweet("test tweet2");

        tweets.add(tweet);
        tweets.add(tweet2);

        assertEquals(tweets.getCount(), 2);

    }

}