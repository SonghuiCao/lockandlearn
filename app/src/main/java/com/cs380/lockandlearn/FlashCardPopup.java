package com.cs380.lockandlearn;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlashCardPopup extends Activity {

    public static final String DECK_NAME = "example.txt";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcardwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

/*
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
            printCard.setText(sb.toString()); //set value of TextView "printCard" to value of string builder
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
*/
        FileInputStream fis = null;
        try {
            fis = openFileInput(DECK_NAME);
            InputStreamReader isr = new InputStreamReader(fis); //put input stream in stream reader.
            BufferedReader br = new BufferedReader(isr); //put stream reader into buffered reader.
            StringBuilder sb = new StringBuilder(); //initialize string builder for appending.

            String question = getString(R.string.question);
            question += "\n\n";
            question += br.readLine();

            String answer = getString(R.string.answer);
            answer += "\n\n";
            answer += br.readLine();

            TextView questionTV = (TextView) findViewById(R.id.question);
            questionTV.setText(question);
            TextView answerTV = (TextView) findViewById(R.id.answer);
            answerTV.setText(answer);

            // questionTV.setText(sb.toString());
            //  answerTV.setText(sb.toString());


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


        //setting flashcard size and converting to int
        double width = dm.widthPixels*0.9;
        double height = dm.heightPixels*0.3;
        int w = (int)width;
        int h = (int)height;

        getWindow().setLayout(w, h);  //create the window


        RelativeLayout popupLayout = (RelativeLayout) findViewById(R.id.popuplayout);
        popupLayout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //make textView question invisible
                TextView questionView = FlashCardPopup.this.findViewById(R.id.question);
                questionView.setVisibility(View.INVISIBLE);

                //make textview answer visible
                TextView answerView = FlashCardPopup.this.findViewById(R.id.answer);
                answerView.setVisibility(View.VISIBLE);
            }
        });


    }

}
