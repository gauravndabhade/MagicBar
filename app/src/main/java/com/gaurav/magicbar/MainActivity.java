package com.gaurav.magicbar;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements SeekBarFragment.FragmentCommunicationnListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonClick(int fontsize, String text) {
        TextviewFragment textFragment =
                (TextviewFragment) getSupportFragmentManager().findFragmentById(R.id.second_fragment);
        textFragment.changeTextProperties(fontsize, text);
    }
}
