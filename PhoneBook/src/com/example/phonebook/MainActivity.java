package com.example.phonebook;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView lv;
	//data source
	ArrayList<Contact> list=new ArrayList<Contact>();
	//
	ContactAdapter adapter;
	private Uri imageUri;
	private String name;
	private String phone;
	DatabaseHelper db;
	AdapterView.AdapterContextMenuInfo info;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		//instantiate
		db=new DatabaseHelper(this);
		
		list=db.getAll();
		
		
		this.lv=(ListView) this.findViewById(R.id.listView1);
		this.adapter=new ContactAdapter(this,list);
		this.lv.setAdapter(adapter);
		
		this.registerForContextMenu(lv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent=new Intent(this,AddContact.class);
		this.startActivityForResult(intent, 0); // 0 request code for adding new record
				
		return super.onOptionsItemSelected(item);
	}

	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		this.getMenuInflater().inflate(R.menu.contextmenu, menu);
		info=(AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(list.get(info.position).getContactName());
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int id=item.getItemId();
		Contact c=list.get(info.position);
		String message="";
		switch(id){
		case R.id.call: break;
		case R.id.sms: break;
		case R.id.edit: 
			
			Intent intent=new Intent(this,AddContact.class);
			
			intent.putExtra("id", c.getId());
			intent.putExtra("image", c.getContactImage());
			intent.putExtra("name", c.getContactName());
			intent.putExtra("phone", c.getContactPhone());
			
			this.startActivityForResult(intent, 1); // 1 request code for adding new record
			
			
			break;
		case R.id.delete:
			int result=db.deleteRecord(c);
			message=(result>0)?"Contact Deleted":"Error Delete Contact";
			Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
			list.remove(info.position);
			adapter.notifyDataSetChanged();
		}
		return super.onContextItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==Activity.RESULT_OK){
			//
			Bundle b=data.getExtras();
			imageUri=b.getParcelable("myimage");
			name=b.getString("myname");
			phone=b.getString("myphone");
			//
			Contact contact=new Contact(imageUri,name,phone);
		
			if(requestCode==0){	//adding
				
				list.add(contact);
				
			}
			if(requestCode==1){	//editing
				//
				list.set(info.position, contact);
				
			}
			adapter.notifyDataSetChanged();
		}		
	}	
}
