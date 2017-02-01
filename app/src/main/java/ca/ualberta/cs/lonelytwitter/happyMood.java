package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jcho1 on 1/19/17.
 * <p>
 * This class is a subclass of Mood
 * In this class sadMoods are created with string "Sad"
 * </p>
 */
public class happyMood extends Mood {
    /**
     * Instantiates a new Happy mood.
     */
    public happyMood() {
        super("Happy");
    }

    /**
     * Instantiates a new Happy mood.
     *
     * @param date the date
     */
    public happyMood(Date date) {
        super(date, "Happy");
    }
}
