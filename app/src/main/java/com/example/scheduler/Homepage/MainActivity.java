package com.example.scheduler.Homepage;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.scheduler.Homepage.adapter.WordAdapter;
import com.example.scheduler.R;
import com.example.scheduler.db.Word;
import com.example.scheduler.db.WordDB;
import com.example.scheduler.db.WordDao;
import com.example.scheduler.schedule.Activity.ScheduleActivity;
import com.example.scheduler.schedule.viewmodel.WordViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final int ADDDATA=123;

    private WordViewModel mWordViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         RecyclerView mRecyclerView= findViewById(R.id.recyclerview);
         final WordAdapter mWordAdapter = new WordAdapter(this);
         mRecyclerView.setAdapter(mWordAdapter);
         mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        mWordViewModel= ViewModelProviders.of(this).get(WordViewModel.class);

        mWordViewModel.getAllWords().observe((LifecycleOwner) this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {

                mWordAdapter.setWords(words);

            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                             startActivityForResult(intent,ADDDATA);
//                             finish();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == ADDDATA ){

            String reply= data.getStringExtra(ScheduleActivity.WORD);
            Toast.makeText(this, reply , Toast.LENGTH_SHORT).show();


        }else {

            Toast.makeText(this,"No data Was Entered",Toast.LENGTH_SHORT).show();
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
