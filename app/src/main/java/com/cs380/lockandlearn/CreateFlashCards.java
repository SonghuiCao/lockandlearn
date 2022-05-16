package com.cs380.lockandlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateFlashCards extends AppCompatActivity {

    private Button createdeckbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_flash_cards);


        createdeckbutton = (Button) findViewById(R.id.createdeck);
        createdeckbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openCreateDeck();
            }

        });
    }
    public void openCreateDeck(){
        Intent intent = new Intent(this, CreateDeck.class);
        startActivity(intent);
    }
}