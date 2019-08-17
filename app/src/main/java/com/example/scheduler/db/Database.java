package com.example.scheduler.db;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Olije Favour on 8/17/2019.
 * Copyright (c) 2019  Itex Integrated Services  All rights reserved.
 */

@androidx.room.Database(entities = Word.class,version = 1)
 abstract class WordDataBase extends RoomDatabase {

    private static WordDataBase INSTANCE;

    abstract WordDao getWordDoa();

    private synchronized WordDataBase getinsatnce(Application application){
            if(INSTANCE ==null ){
        INSTANCE = Room.databaseBuilder(application, WordDataBase.class, "word_Database")
                              .fallbackToDestructiveMigration()
                               .build();
            }

            return  INSTANCE;
    }

}
