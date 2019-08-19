package com.example.scheduler.Homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheduler.R;
import com.example.scheduler.db.Word;

import java.util.List;

/**
 * Created by Olije Favour on 8/19/2019.
 * Copyright (c) 2019    All rights reserved.
 */



public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder>{

  private LayoutInflater mLayoutInflater;
    private List<Word> mWord;

    private WordAdapter(Context context ){

      mLayoutInflater = LayoutInflater.from(context);
  }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  mLayoutInflater.inflate(R.layout.recyclerview_item,parent,false);

       return  new WordViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
      if
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    void setWords(List<Word> word){
       mWord =word;
       notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView word = itemView.findViewById(R.id.word_textView);
        }
    }
}
