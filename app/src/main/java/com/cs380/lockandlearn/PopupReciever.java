package com.cs380.lockandlearn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PopupReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Intent popupIntent = new Intent(PopupReciever.this, FlashCardPopup.class);
        //startActivity(popupIntent);
      //  Toast.makeText(context, "Lock Screen Closed Detected",Toast.LENGTH_LONG).show();
        context.startActivity(new Intent(context, FlashCardPopup.class));
    }
}