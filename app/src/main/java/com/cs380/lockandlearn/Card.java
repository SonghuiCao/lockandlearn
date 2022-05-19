package com.cs380.lockandlearn;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Define Card data entities
@Entity(primaryKeys = {"cardID", "deckID"})
public class Card {
    @NonNull
    int cardID;

    @NonNull
    String deckID;

    @ColumnInfo
    public String question;

    @ColumnInfo
    public String answer;

    // Getter methods
    public String getQuestion() {return this.question;}
    public String getAnswer() {return this.answer;}
}
