package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jcho1 on 1/19/17.
 */

public class Mood {

        private Date date;
        private String mood;

        public Mood(Date date, String mood) {
            this.date = date;
            this.mood = mood;
        }

        public Mood(String mood) {
            this.date = new Date();
            this.mood = mood;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getMood() {
            return mood;
        }

        public void setMood(String mood) {
            this.mood = mood;
        }
}

