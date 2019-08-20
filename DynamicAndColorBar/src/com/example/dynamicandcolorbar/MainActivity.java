package com.example.dynamicandcolorbar;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {
	SeekBar skRed, skGreen,skBlue;
	TextView lblResult;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.skRed = (SeekBar) this.findViewById(R.id.seekBar1);
        this.skGreen = (SeekBar) this.findViewById(R.id.seekBar2);
        this.skBlue = (SeekBar) this.findViewById(R.id.seekBar3);
        
        this.lblResult = (TextView) this.findViewById(R.id.textView4);
        
        this.skRed.setOn
    }


  
    
}
