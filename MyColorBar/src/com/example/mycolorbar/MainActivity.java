package com.example.mycolorbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;


public class MainActivity extends Activity implements OnSeekBarChangeListener {
	SeekBar skRed,skGreen,skBlue;
	EditText txtRed, txtGreen, txtBlue;
	TextView lblResult;
	private int red;
	private int green;
	private int blue ;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtRed = (EditText) this.findViewById(R.id.editText1);
        this.txtGreen = (EditText) this.findViewById(R.id.editText2);
        this.txtBlue = (EditText) this.findViewById(R.id.editText3);
        
        this.skRed = (SeekBar) this.findViewById(R.id.seekBar1);
        this.skGreen = (SeekBar) this.findViewById(R.id.seekBar2);
        this.skBlue = (SeekBar) this.findViewById(R.id.seekBar3);
        
        this.lblResult = (TextView) this.findViewById(R.id.textView4);
        // add event listener
        this.skRed.setOnSeekBarChangeListener(this);
        this.skGreen.setOnSeekBarChangeListener(this);
        this.skBlue.setOnSeekBarChangeListener(this);
        
        // 
        this.txtRed.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				try{
				int redValue = Integer.parseInt(arg0.toString());
			
				
				
				red = redValue;
				
				
				
				skRed.setProgress(red);
				
				}catch(Exception e){}
				/*
				String redHex = String.format("%x",red);
				String greenHex = String.format("%x",green);
				String blueHex = String.format("%x",blue);
				
				lbl*/
				
				
			}}
        );
         this.txtGreen.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				try{
				int greenValue = Integer.parseInt(arg0.toString());
				green = greenValue;
				skGreen.setProgress(green);
				}catch(Exception e){}
			}});
         
         this.txtBlue.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				try{
				int blueValue = Integer.parseInt(arg0.toString());
				blue = blueValue;
				skBlue.setProgress(blue);
				}catch(Exception e){}
			}});
         
        
        
    }

	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		//check which seekbar is changed
		
		int id = arg0.getId();
		switch(id){
		case R.id.seekBar1: red = this.skRed.getProgress();
							this.txtRed.setText(red+"");
		break;
		
		case R.id.seekBar2 : green = this.skGreen.getProgress();
							this.txtGreen.setText(green+"");
		break;
		
		case R.id.seekBar3: blue = this.skBlue.getProgress();
								this.txtBlue.setText(blue+"");
		break;
		
		}
		
		this.lblResult.setBackgroundColor(Color.rgb(red, green, blue));
		String colorValue = String.format("#%X %X %X",red, green, blue);
		this.lblResult.setTextColor(Color.rgb(red-255, green-255, blue-255));
		this.lblResult.setText(colorValue);
		

		
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

    
  
    
}
