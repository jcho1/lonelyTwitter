package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static ca.ualberta.cs.lonelytwitter.R.id.textView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        TextView text = (TextView) findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();
        String tweet = extras.getString("the_tweet"); // retrieve the data using keyName
        text.setText(tweet);
    }

}
