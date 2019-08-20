package com.example.userlogin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;


public class MainActivity extends Activity implements OnClickListener {

	
	//login information
	final static String USERNAME="admin";
	final static String PASSWORD="user123";
	
	EditText txtUsername,pwdPassword;
	Button btnLogin;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //instantiate the UI elements
        this.txtUsername=(EditText) this.findViewById(R.id.EditText01);
        this.pwdPassword=(EditText) this.findViewById(R.id.editText1);
        this.btnLogin=(Button) this.findViewById(R.id.button1);
        //assign a click listener
        this.btnLogin.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String username = this.txtUsername.getText().toString();
		String password = this.pwdPassword.getText().toString();
		if(username.equals(USERNAME) && password.equals(PASSWORD)){
			Toast.makeText(this, "LOGIN ACCEPTED!", Toast.LENGTH_SHORT).show();
			
		}else{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Error");
			builder.setMessage("INVALID USER");
			builder.setNeutralButton("Okey",null);
			// 
			AlertDialog dialog = builder.create();
				dialog.show();
		}
		//clear the fields
		
		this.txtUsername.setText("");
		this.pwdPassword.setText("");
		//set the cursor position to the user name
		this.txtUsername.requestFocus();
			
			
			
	}

    
    
    
}
