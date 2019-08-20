package com.example.phonebook;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContact extends Activity implements OnClickListener {

	ImageView iv;
	EditText txtName,txtPhone;
	Button btnCancel,btnOkey;
	private Uri imageUri;
	private String name;
	private String phone;
	DatabaseHelper db;
	//
	int flag=0; 	//if flag 0 adding else editing
	private int id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.contactlayout);
		
		db=new DatabaseHelper(this);
		
		this.iv=(ImageView) this.findViewById(R.id.imageview1);
		this.txtName=(EditText) this.findViewById(R.id.contactname);
		this.txtPhone=(EditText) this.findViewById(R.id.contactphone);
		this.btnCancel=(Button) this.findViewById(R.id.cancel);
		this.btnOkey=(Button) this.findViewById(R.id.okey);
		
		//add event listener
		this.iv.setOnClickListener(this);
		this.btnCancel.setOnClickListener(this);
		this.btnOkey.setOnClickListener(this);
		
		//watch for editable data from MainAcity
		Bundle b=this.getIntent().getExtras();
		if(b!=null){
			id=b.getInt("id");
			imageUri=b.getParcelable("image");
			name=b.getString("name");
			phone=b.getString("phone");
			flag=1;	//set to editing
			
			this.iv.setImageURI(imageUri);
			this.txtName.setText(name);
			this.txtPhone.setText(phone);
			
		}
	}

	@Override
	public void onClick(View arg0) {
		//check which button is clicked
		int id=arg0.getId();
		switch(id){
		case R.id.imageview1: //pick an image from the gallery
			//create an intent
			Intent n=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			//execute the intent
			this.startActivityForResult(n, 100);
			
			break;
		case R.id.okey: //retrieve all encoded text and image and send it back to main
			
			name=this.txtName.getText().toString();
			phone=this.txtPhone.getText().toString();
			//check for validation
			if(imageUri!=null && !name.equals("") && !phone.equals("")){
			
				//blind intent
				Intent intent=new Intent();
				//set the cargo
				intent.putExtra("myimage", this.imageUri);
				intent.putExtra("myname", this.name);
				intent.putExtra("myphone", this.phone);
				
				if(flag==0){
					//write data to database
					long result=db.addContact(new Contact(imageUri,name,phone));
					
					String message=(result>0)?"New Contact Added":"Error Adding Contact";
					Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
				}
				else{
					//write data to database
					long result=db.updateRecord(new Contact(this.id,imageUri,name,phone));
					
					String message=(result>0)?"Record Updated":"Error Updating Contact";
					Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
				}
				
				
				//send the data back to MainActivity
				this.setResult(Activity.RESULT_OK, intent);
				
			}			
			
		case R.id.cancel: //terminate this activity
			this.finish();
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {		
		super.onActivityResult(requestCode, resultCode, data);
		//check if no problem in the intent call
		if(resultCode==Activity.RESULT_OK){
			//check which request is invoked
			if(requestCode==100){
				
				imageUri=data.getData();
				this.iv.setImageURI(imageUri);
			}
		}
	}
}
