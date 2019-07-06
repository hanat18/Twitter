package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.codepath.apps.restclienttemplate.TweetAdapter;

public class ComposeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
    }

    public void onSubmit(View view){
        EditText etName = findViewById(R.id.composedText);

        // Prepare data intent
        Intent data = new Intent();

        // Pass relevant data back as a result
        data.putExtra("newTweet", etName.getText().toString());

        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response

        this.finish(); // closes the activity, pass data to parent
    }
}
