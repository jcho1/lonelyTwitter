package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jcho1 on 1/19/17.
 * <p>
 * This class is a subclass of Mood
 * In this class sadMoods are created with string "Sad"
 * </p>
 */
public class sadMood extends Mood {
    /**
     * Instantiates a new Sad mood.
     */
    public sadMood() {
        super("Sad");
    }

    /**
     * Instantiates a new Sad mood.
     *
     * @param date the date
     */
    public sadMood(Date date) {
        super(date, "sad");
    }
}
