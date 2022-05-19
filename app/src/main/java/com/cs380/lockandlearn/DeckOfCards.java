package com.cs380.lockandlearn;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class DeckOfCards {
    @Embedded public Deck deck;
    @Relation(
            parentColumn = "deckName",
            entityColumn = "userCreatorID"
    )
    public List<Card> cards;
}
