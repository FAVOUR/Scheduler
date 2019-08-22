package com.example.scheduler.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Olije Favour on 8/15/2019.
 * Copyright (c) 2019.
 */

@Entity(tableName = "word_table")
public class Word {

    //You can either setup the Entity like so or.....
//  @PrimaryKey
//    @NonNull
//    public  int id;
//    public   String word;


//    like so....
      @PrimaryKey(autoGenerate = true)
      @NonNull
     private int id;
      @ColumnInfo(name = "word")
     private  String mWord;

    public Word(String word){

        this.id=id;
        mWord=word;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return mWord;
    }

}
