package com.mygdx.game.Layouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mygdx.game.NetworkConnection;
import com.mygdx.game.R;

public class suchen extends NetworkConnection {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suchen);
        super.connect(false);
    }
    public void onButtonClickSuchenZurück(View v){
        Intent intent = new Intent(getApplicationContext(), startscreen.class);
        startActivity(intent);
    }
}
