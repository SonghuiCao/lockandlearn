package com.cs380.lockandlearn;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Deck.class, Card.class, DeckOfCards.class}, version = 1)
public abstract class DeckCardDatabase extends RoomDatabase {
    public abstract DeckCardDao deckCardDao();
}
