package com.cs380.lockandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button playflashcardsbutton;
    private Button createflashcardsbutton;
    private Button settingsbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //new filter in main to look for USER_PRESENT signal
        //uses the same FlashCardPopup as the play popup.
        //  Object action;
        //  IntentFilter popupFilter = new IntentFilter("android.intent.action.USER_PRESENT");
        //  PopupReciever popupReciever = new PopupReciever();
        //  registerReceiver(popupReciever, popupFilter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playflashcardsbutton = findViewById(R.id.playflashcardsbutton);
        playflashcardsbutton.setOnClickListener(fc -> openPlayFC());

        createflashcardsbutton = findViewById(R.id.createflashcardsbutton);
        createflashcardsbutton.setOnClickListener(fc -> openCreateFC());

        settingsbutton = findViewById(R.id.settingsbutton);
        settingsbutton.setOnClickListener(fc -> openSettingsFC());


    }
    public void openCreateFC(){
        Intent intent = new Intent(this, CreateFlashCards.class);
        startActivity(intent);
    }
    public void openPlayFC(){
        Intent intent = new Intent(this, PlayFlashCards.class);
                startActivity(intent);
    }

    public void openSettingsFC(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}