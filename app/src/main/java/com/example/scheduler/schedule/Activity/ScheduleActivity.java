package com.example.scheduler.schedule.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.scheduler.R;

public class ScheduleActivity extends AppCompatActivity {
    TextView wordText;
    Button submitBtn;
    public final static String WORD="word_entered";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


          wordText=findViewById(R.id.wordText);
          submitBtn=findViewById(R.id.add_word);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent resultIntent = new Intent();
                String wordEntered = wordText.getText().toString().trim();
                if (wordEntered.isEmpty() || wordEntered == null) {
                    setResult(RESULT_CANCELED, resultIntent);
                } else {
                    resultIntent.putExtra(WORD, wordEntered);
                    setResult(RESULT_CANCELED, resultIntent);

                }
               //Helps end this activity and give room to the calling activity
                //Without this method the activity will never give  way
                finish();
            }
        });

    }
}
