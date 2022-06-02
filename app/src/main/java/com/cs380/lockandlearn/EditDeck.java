package com.cs380.lockandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDeck extends AppCompatActivity {

    EditText editDeck;

    static String deckName="";
    ListView decknameslistview;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_deck);

        editDeck = findViewById(R.id.editdeck);
        decknameslistview = findViewById(R.id.selectdeck);

        String[] files = this.fileList(); //
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, files) ; //
        decknameslistview.setAdapter(arr);

        decknameslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = decknameslistview.getItemAtPosition(position).toString();

                FileInputStream fis = null; //initialize input stream
                try {
                    fis = openFileInput(item);
                    InputStreamReader isr = new InputStreamReader(fis); //put the file input stream into the reader
                    BufferedReader br = new BufferedReader(isr); //put stream reader into buffered reader
                    StringBuilder sb = new StringBuilder(); //initialize string builder
                    String text;


                    while((text = br.readLine()) != null) {
                        sb.append(text).append("\n");
                    }
                    editDeck.setText(sb.toString());
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
                deckName=item;
        }
        });
    }

        public void edit(View v) {

            //variable for file name, this can be made variable with edittext outputs to store more than 1 deck
            String text = editDeck.getText().toString();
            FileOutputStream fos = null;

            try {
                fos = openFileOutput(deckName, MODE_PRIVATE);
                ((FileOutputStream) fos).write(text.getBytes());

                editDeck.getText().clear();

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
