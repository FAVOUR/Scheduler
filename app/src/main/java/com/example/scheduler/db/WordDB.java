package com.example.scheduler.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by Olije Favour on 8/18/2019.
 * Copyright (c) 2019    All rights reserved.
 */

// *Copyright (c) 2019  Itex Integrated Services  All rights reserved.

@Database(entities = Word.class,version = 1,exportSchema = false)
public abstract class WordDB extends RoomDatabase {

        private static volatile WordDB INSTANCE;

        public abstract WordDao getWordDoa();

         public static synchronized WordDB getDatabase(Application application){
            if(INSTANCE ==null ){
                INSTANCE = Room.databaseBuilder(application, WordDB.class, "word_Database")
                        .fallbackToDestructiveMigration()
                        .build();
            }

            return  INSTANCE;
        }

    }

