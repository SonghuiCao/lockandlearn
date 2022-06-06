package com.cs380.lockandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CreateDeck extends AppCompatActivity{

    public static final String DECK_NAME = "example.txt";
    static String deckName="";

    //EditText editCard;
    EditText titleedittext;
    EditText answeredittext;
    EditText questionedittext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_deck);

       // editCard = findViewById(R.id.input_text);
        titleedittext = findViewById(R.id.input_deck_name);
        answeredittext = findViewById(R.id.input_answer);
        questionedittext = findViewById(R.id.input_question);

        deckName = titleedittext.getText().toString();

    }

    //VERSION 3 editing and therefore loading is moved to a different page.
    /*
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
           questionedittext.setText(sb.toString());
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

    public String getDeckName(EditText title){
      deckName = title.getText().toString();
      deckName += ".txt";
      titleedittext.setVisibility(View.INVISIBLE);
      return deckName;
    }
     */


    public void save(View v) {

        //variable for file name, this can be made variable with edittext outputs to store more than 1 deck
        String text = questionedittext.getText().toString();
        text += "\n";
        text += answeredittext.getText().toString();
        text += "\n";

        deckName = titleedittext.getText().toString();
        deckName += ".txt";


        FileOutputStream fos = null;
            try {

            fos = openFileOutput(deckName, MODE_APPEND);
            ((FileOutputStream) fos).write(text.getBytes());

            questionedittext.getText().clear();
            answeredittext.getText().clear();
            titleedittext.setVisibility(View.INVISIBLE);


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
    /*
    public void save(View v) throws FileNotFoundException{

        String text = questionedittext.getText().toString();
        text += "\n";
        text += answeredittext.getText().toString();

        deckName = titleedittext.getText().toString();
        deckName += ".txt";

        try {
                FileOutputStream fos = new FileOutputStream(deckName,true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
                outputStreamWriter.write(text);
                outputStreamWriter.close();
        }catch (IOException e) {
                Log.e("Exception", "File write failed: " + e.toString());
        }
                questionedittext.getText().clear();
                answeredittext.getText().clear();
                titleedittext.setVisibility(View.INVISIBLE);
    }
    */

}
