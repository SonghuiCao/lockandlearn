package com.cs380.lockandlearn;

import java.util.List;
import androidx.room.*;
import androidx.annotation.*;
import androidx.lifecycle.*;

public interface DeckDao {

    @Insert
    void insert(Deck deck);

    // SQLite method to clear decks
    @Query("DELETE FROM deck_table")  //No convenience annotation for deleting multiple entities
    void deleteAll();

    // SQLite method to list all decks
    @Query("SELECT * from deck_table ORDER BY deck ASC")
    LiveData<List<List<String>>> getAllDecks();

}
