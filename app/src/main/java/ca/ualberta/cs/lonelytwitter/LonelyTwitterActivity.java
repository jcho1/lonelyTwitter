package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.R.id.message;


public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

    private ArrayList<Tweet> tweetlist;
    private ArrayAdapter<Tweet> adapter;

    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                tweetlist.clear();
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				try {
					Tweet tweet = new NormalTweet(text);
					tweetlist.add(tweet);
                    adapter.notifyDataSetChanged();

                } catch (TweetTooLongException e) {
					e.printStackTrace();
				}

                saveInFile();
				//finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();

        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetlist);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
            tweetlist = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
            tweetlist = new ArrayList<Tweet>();
            throw new RuntimeException();
		} catch (IOException e) {
            throw new RuntimeException();
		}
		//return tweets.toArray(new String[tweets.size()]);

	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetlist, out);
            out.flush();

            fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
            throw new RuntimeException();
		}
	}

}