package com.example.diego.paralimpicos2019v20;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

public class Ayudapopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ayudapopup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int  width= dm.widthPixels;
        int height =dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));
    }
}
