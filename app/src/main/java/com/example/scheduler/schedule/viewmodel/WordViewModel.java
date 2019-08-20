package com.example.scheduler.schedule.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.scheduler.db.Word;
import com.example.scheduler.model.repository.WordRepository;

import java.util.List;

/**
 * Created by Olije Favour on 8/18/2019.
 * Copyright (c) 2019    All rights reserved.
 */

// *Copyright (c) 2019  Itex Integrated Services  All rights reserved.


public class WordViewModel extends AndroidViewModel {

    private WordRepository mWordRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllNotes();
    }


    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public  void addword(Word word ){

         mWordRepository.insert(word);
    }


}
