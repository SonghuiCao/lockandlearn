package com.cs380.lockandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayFlashCards extends AppCompatActivity {

    public static final String DECK_NAME = "example.txt";

    TextView showFlashCard;

    //load function is called with onClick
    //will load hardcoded text file to
    public void load(View v){
        //initialize input stream
        FileInputStream fis = null;

        try {
            fis = openFileInput(DECK_NAME);
            InputStreamReader isr = new InputStreamReader(fis); //put input stream in stream reader.
            BufferedReader br = new BufferedReader(isr); //put stream reader into buffered reader.
            StringBuilder sb = new StringBuilder(); //initialize string builder for appending.

            String text;

            //as long as the buffered reader is not null append  next line to string builder
            while((text = br.readLine()) != null) { //put buffered reader into text string.
                sb.append(text).append("\n"); //append stringbuilder with text string.
            }
            showFlashCard.setText(sb.toString()); //set value of TextView "showFlashCard" to value of string builder
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try{
                    fis.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_flash_cards);

        showFlashCard = (TextView) findViewById(R.id.flashCardText); //put showFlashCard Textview into flashCardText view.

        Button play = (Button) findViewById(R.id.play); //initialize play button.
        Button selectDeck = (Button) findViewById(R.id.selectdeck);


        // on click
        play.setOnClickListener(new View.OnClickListener(){  //set onlicklistener for play button.

            public void onClick(View v){
                startActivity(new Intent (PlayFlashCards.this, FlashCardPopup.class)); //start flashcardpopup when clicked.
            }
        });

        selectDeck.setOnClickListener(new View.OnClickListener(){  //set onlicklistener for selectdeck button.

            public void onClick(View v){
                startActivity(new Intent (PlayFlashCards.this, SelectDeck.class)); //start selectdeck when clicked.
            }
        });


    }
}