package com.cs380.lockandlearn;
import androidx.room.*;
import androidx.annotation.*;

import java.util.List;

// Define Deck data entities
@Entity
public class Deck {
    @PrimaryKey
    @NonNull
    public String deckName;

    @ColumnInfo(name = "category")
    private String category;

    @ColumnInfo
    private int deckSize;

    // Constructor
    public Deck(@NonNull String deck, String category)
    {
        this.deckName = deckName;
        this.category = category;
    }

    // Getter methods
    public String getDeckName() {return this.deckName;}

    // public String getDeckCategory()
}
