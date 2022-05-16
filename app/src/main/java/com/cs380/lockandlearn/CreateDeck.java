package com.cs380.lockandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateDeck extends AppCompatActivity {

    public static final String DECK_NAME = "example.txt";

    EditText editCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_deck);

        editCard = findViewById(R.id.input_text);
    }
    public void load(View v){
        FileInputStream fis = null; //initialize input stream
        try {
            fis = openFileInput(DECK_NAME);
            InputStreamReader isr = new InputStreamReader(fis); //put the file input stream into the reader
            BufferedReader br = new BufferedReader(isr); //put stream reader into buffered reader
            StringBuilder sb = new StringBuilder(); //initialize string builder
            String text;

            //this can be changed to allow reading BY LINE to seperate "questions" and "answeres" and "cards"
            while((text = br.readLine()) != null) { //as long as the buffered reader isnt null append line to string builder
                sb.append(text).append("\n");
            }
            editCard.setText(sb.toString());
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
    public void save(View v) {

        //variable for file name, this can be made variable with edittext outputs to store more than 1 deck
        String text = editCard.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(DECK_NAME, MODE_PRIVATE);
            ((FileOutputStream) fos).write(text.getBytes());

            editCard.getText().clear();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}