package com.cs380.lockandlearn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class SelectDeck extends AppCompatActivity {

    static String deckName;

    public static String getDeckName(){
        return deckName;
    }




    ListView decknameslistview;

    @SuppressLint("WrongViewCast")


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_deck);

       // Button play = (Button) findViewById(R.id.play); //initialize play button.



            String deckcards =
                    "What is the Capital city of Sweden? \n Stockholm. \n" +
                            "What is the Capital city of Finland? \n Helsinki. \n " +
                            "What is the Capital city of Norway? \n Oslo. \n " +
                            "What is the Capital city of Switzerland? \n Bern. \n" +
                            "What is the Capital city of Denmark? \n Copenhagen. \n" +
                            "What is the Capital city of Germany? \n Berlin. \n" +
                            "What is the capital city of France? \n Paris.\n" +
                            "What is the Capital city of Spain? \n Madrid. \n" +
                            "What is the Capital city of Portugal? \n Lisbon. \n" +
                            "What is the Capital city of Liechtenstein? \n Vaduz. \n" +
                            "What is the Capital city of Austria? \n Vienne. \n" +
                            "What is the Capital city of Bulgaria? \n Sofia. \n " +
                            "What is the Capital city of Croatia? \nZagreb.\n" +
                            "What is the Capital city of Estonia? \nTallin.\n" +
                            "What is the Capital city of Greece? \nAthens.\n" +
                            "What is the Capital city of Lithuania? \n Vilnius.\n" +
                            "What is the Capital city of Malta?\n Valletta.\n";
            FileOutputStream fos = null;

            try {
                fos = openFileOutput("countrycapitals.txt", MODE_PRIVATE);
                fos.write(deckcards.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            deckcards =

                    "Winner of Superbowl XXXIV (2000)? \n St. Louis Rams. \n " +
                            "Winner of Superbowl XXXV (2001)? \n Baltimore Ravens \n " +
                            "Winner of Superbowl XXXVI (2002)? \n New England Patriots. \n" +
                            "Winner of Superbowl XXXVII (2003)? \n Tampa Bay Buccaneers. \n" +
                            "Winner of Superbowl XXXVIII (2004)? \n New England Patriots. \n" +
                            "Winner of Superbowl XXXIX (2005)? \n New England Patriots.\n" +
                            "Winner of Superbowl XL (2006)? \n Pittsburg Steelers. \n" +
                            "Winner of Superbowl XLI (2007)? \n Indianapolis Colts. \n" +
                            "Winner of Superbowl XLII (2008)? \n New York Giants. \n" +
                            "Winner of Superbowl XLIII (2009)? \n Pittsburg Steelers. \n" +
                            "Winner of Superbowl XLIV (2010)? \n New Orleans Saints. \n " +
                            "Winner of Superbowl XLV (2011)? \nGreen Bay Packers.\n" +
                            "Winner of Superbowl XLVI (2012)? \nNew York Giants.\n" +
                            "Winner of Superbowl XLVII (2013)? \nBaltimore Ravens.\n" +
                            "Winner of Superbowl XLVIII (2014)? \n Seattle Seahawks.\n";

            fos = null;

            try {
                fos = openFileOutput("superbowlwinners.txt", MODE_PRIVATE);
                ((FileOutputStream) fos).write(deckcards.getBytes());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        //VERSION 2 creating formatted string for display in text view
        /*
        String[] files;
        files = this.fileList();
        //String[] files = {""};
        String dl = "";

        if(!(files.length >0)){
        }

        files= this.fileList();

        for (String file : files) {
            dl += file;
            dl += "\n";     //append
        }

        TextView decklist = findViewById(R.id.selectdeck);
        decklist.setText(dl);
        */

        //VERSION 3 use listview
        decknameslistview = findViewById(R.id.selectdeck);
        String[] files = this.fileList(); //

        //String[] files = {}; //for testing getfile() ListView interaction, hardcode a string[]

        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, files) ; //

        decknameslistview.setAdapter(arr);

        /////////
        String str = "oh boy";

        TextView deckname = (TextView) findViewById(R.id.deckname);
        deckname.setText(str);

        decknameslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String item = decknameslistview.getItemAtPosition(position).toString();
                deckName =item;//
                deckname.setText(item);

            }
        });

       /*
        play.setOnClickListener(new View.OnClickListener(){  //set onlicklistener for play button.

            public void onClick(View v){
                startActivity(new Intent(SelectDeck.this, FlashCardPopup.class)); //start flashcardpopup when clicked.
            }
        });
        */
    }

        /*
        public void onContentChanged() {
        super.onContentChanged();

        View empty = findViewById(R.id.empty);
        ListView decknameslistview = (ListView) findViewById(R.id.selectdeck);
        decknameslistview.setEmptyView(empty);
        }
        */

}
