package com.example.scheduler.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Created by Olije Favour on 8/16/2019.
 * Copyright (c) 2019.
 */

@Dao
public interface WordDao {

    @Insert
    void insert(Word word );

    @Query("SELECT * FROM word_table")
    List<Word> getAllWord();

    @Query("DELETE FROM word_table")
    List<Word> deleteAllWords();

}
