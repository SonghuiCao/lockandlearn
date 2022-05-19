package com.cs380.lockandlearn;
import androidx.room.*;
import androidx.annotation.*;

import java.util.List;

@Entity(tableName = "deck_table")
public class Deck {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "deck")

    // We probably want to use a different data type here,
    // List is just placeholder for now.
    private List<String> mDeck;

    public Deck(@NonNull List<String> deck) {this.mDeck = deck;}
    public List<String> getDeck() {return this.mDeck;}
}
