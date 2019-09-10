package com.example.scheduler.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.scheduler.db.Word;
import com.example.scheduler.db.WordDB;
import com.example.scheduler.db.WordDao;

import java.util.List;


/**
 * Created by Olije Favour on 8/18/2019.
 * Copyright (c) 2019.
 */


public class WordRepository {
  private  WordDao wordDoa;
  private LiveData<List<Word>> allNotes;

    public WordRepository(Application application){

        WordDB wordDB=  WordDB.getDatabase(application);
        wordDoa = wordDB.getWordDoa();
        allNotes = wordDoa.getAllWord();
    }

    public void insert(Word word ){
        new WordAsyncTask(wordDoa).execute(word);
    }


    public LiveData<List<Word>> getAllNotes() {
        return allNotes;
    }

    class WordAsyncTask extends AsyncTask<Word,Void,Void>{

        WordDao wordDao;

        public WordAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {

             wordDao.insert(words[0]);

            return null;
        }
    }

}
