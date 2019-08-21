package com.example.scheduler.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by Olije Favour on 8/18/2019.
 * Copyright (c) 2019    All rights reserved.
 */


@Database(entities = Word.class,version = 1,exportSchema = false)
public abstract class WordDB extends RoomDatabase {

        private static volatile WordDB INSTANCE;

        public abstract WordDao getWordDoa();

         public static synchronized WordDB getDatabase(Application application){
            if(INSTANCE ==null ){
                INSTANCE = Room.databaseBuilder(application, WordDB.class, "word_Database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomDbCallBack)
                        .build();
            }

            return  INSTANCE;
        }


   private static  RoomDatabase.Callback roomDbCallBack= new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new InsertWordTask(INSTANCE).execute();
        }
    };

   private  static class InsertWordTask extends AsyncTask<Void,Void,Void> {

        WordDao mWordDoa;

        InsertWordTask(WordDB db){
            mWordDoa=db.getWordDoa();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mWordDoa.deleteAllWords();
            Word word = new Word("Hello");
            mWordDoa.insert(word);

            word = new Word("World");
            mWordDoa.insert(word);

            return null;
        }
    }



}

