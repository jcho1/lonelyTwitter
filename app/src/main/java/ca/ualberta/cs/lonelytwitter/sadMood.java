package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jcho1 on 1/19/17.
 */

public class sadMood extends Mood {
    public sadMood() {
        super("Sad");
    }

    public sadMood(Date date) {
        super(date, "sad");
    }
}
