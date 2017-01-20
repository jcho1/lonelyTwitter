package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jcho1 on 1/19/17.
 */

public class happyMood extends Mood {
    public happyMood() {
        super("Happy");
    }

    public happyMood(Date date) {
        super(date, "Happy");
    }
}
