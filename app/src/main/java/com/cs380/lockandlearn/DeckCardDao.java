package com.cs380.lockandlearn;

import java.util.List;
import androidx.room.*;
import androidx.annotation.*;
import androidx.lifecycle.*;

public interface DeckCardDao {

    @Insert
    void insert(Deck deck);

    // SQLite method to clear decks
    @Query("DELETE FROM deck")  //No convenience annotation for deleting multiple entities
    void deleteAll();

    // SQLite method to list all decks
    @Query("SELECT * from deck ORDER BY deckName ASC")
    LiveData<List<List<String>>> getAllDecks();

    // Query the relation DeckCard to return a list of all cards in a deck
    @Transaction
    @Query("SELECT * FROM Deck")
    public List<DeckOfCards>
}
