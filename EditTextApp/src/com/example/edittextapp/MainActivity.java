package com.example.edittextapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;


public class MainActivity extends Activity implements OnClickListener {

	
	//Property Declarations
	EditText txtName;
	Button btnOkay;
	TextView lblName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // instantiate the properties
        this.lblName = (EditText) this.findViewById(R.id.textView1);
        this.btnOkay = (Button) this.findViewById(R.id.button1);
        this.txtName = (EditText) this.findViewById(R.id.editText1);
        
        //delegate an event listener to the button
        //you cannot do this if button is not instantiated
        
        this.btnOkay.setOnClickListener(this);
    }

	@SuppressLint("ShowToast") @Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		//get
		String name = this.txtName.getText().toString();
		//if text is not typed
		 
		if(name.equals("")){
			Toast.makeText(this, "Input Name", Toast.LENGTH_SHORT);
		}else{
			//assign 
			this.lblName.setText(name);
			//clear the text field
			this.txtName.setText("");
			
			
		}
		
	}


    
}
