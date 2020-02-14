package com.example.customviewapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;


public class TextFieldComponent extends AppCompatEditText {

    private Drawable mClearButtonImage;

    public TextFieldComponent(Context context) {
        super(context);
        init();
    }

    public TextFieldComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextFieldComponent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        mClearButtonImage = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_clear_black_24dp1,null);
        setBackgroundColor(Color.YELLOW);

        // touch listener which detects whether the user tapped on the clear icon or not, also works with rtl languages.

        setOnTouchListener(new OnTouchListener() {
            @Override

            public boolean onTouch(View v, MotionEvent event) {
                if((getCompoundDrawablesRelative()[2]!= null)){
                    float clearButtonStart;
                    float clearButtonEnd;
                    boolean isClearButtonClicked= false;


                    if (getLayoutDirection() == LAYOUT_DIRECTION_RTL) {
                        clearButtonEnd = mClearButtonImage.getIntrinsicWidth() + getPaddingStart();
                        if (event.getX() < clearButtonEnd) {
                            isClearButtonClicked = true;
                        }
                    } else {

                        clearButtonStart = (getWidth() - getPaddingEnd()
                                - mClearButtonImage.getIntrinsicWidth());
                        if (event.getX() > clearButtonStart) {
                            isClearButtonClicked = true;
                        }
                    }
                    if (isClearButtonClicked) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            mClearButtonImage =
                                    ResourcesCompat.getDrawable(getResources(),
                                            R.drawable.ic_clear_black_24dp1, null);
                            showClearButton();
                        }
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            mClearButtonImage =
                                    ResourcesCompat.getDrawable(getResources(),
                                            R.drawable.lighter_clear_icon, null);
                            getText().clear();
                            hideClearButton();
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                return false;
            }


        });

        addTextChangedListener(new TextWatcher() {

            private Object MainActivity;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            showClearButton();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void showClearButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,mClearButtonImage,null);
    }
    private void hideClearButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,null);
    }
}
