package com.example.customviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.customviewapp.R.id.lightBulb;

public class MainActivity extends AppCompatActivity {

    ImageView lightBulb;

    TextFieldComponent text;

    SwitchComponent switchComp;

    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightBulb = findViewById(R.id.lightBulb);

        text = findViewById(R.id.textFieldComponent);

        switchComp = findViewById(R.id.switchComponent);

        message = findViewById(R.id.message);

        message.setText(R.string.switchOnMessage);

        switchComp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "switched on", Toast.LENGTH_SHORT).show();
                    lightBulb.setImageResource(R.drawable.on);
                    message.setText(R.string.switchOffMessage);

                }else {
                    Toast.makeText(MainActivity.this, "switched off", Toast.LENGTH_SHORT).show();
                    lightBulb.setImageResource(R.drawable.off);
                    message.setText(R.string.switchOnMessage);

                }
            }
        });


        text.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if((text.getText().toString()).equals("הדלק")) {
                        switchComp.setChecked(true);
                        Toast.makeText(MainActivity.this, "מדליק", Toast.LENGTH_SHORT).show();
                        lightBulb.setImageResource(R.drawable.on);
                    }else if((text.getText().toString()).equals("כבה")){
                        switchComp.setChecked(false);
                        Toast.makeText(MainActivity.this, "מכבה", Toast.LENGTH_SHORT).show();
                            lightBulb.setImageResource(R.drawable.off);
                    }
                    return true;
                }
                return false;
            }
        });

        }
    }

