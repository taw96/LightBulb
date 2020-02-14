package com.example.customviewapp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;


import androidx.appcompat.widget.SwitchCompat;

public class SwitchComponent extends SwitchCompat {

    public SwitchComponent(Context context) {
        super(context);
        init();
    }

    public SwitchComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwitchComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setBackgroundColor(Color.YELLOW);
        setShowText(true);
        setTextOn("On");
        setTextOff("Off");
        setThumbResource(R.drawable.thumb1);
        setTrackResource(R.drawable.track);

    }

}
