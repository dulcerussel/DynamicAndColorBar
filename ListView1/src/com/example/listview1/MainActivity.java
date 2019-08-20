package com.example.listview1;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	//define the properties
	ListView lv;
	//data source
	ArrayList<String> list =  new ArrayList<String>();
	//adapter
	ArrayAdapter<String> adapter;
	//
	AlertDialog.Builder builder;
	AlertDialog dialog;
	//
	EditText txtName;
	
	//
	AdapterView.AdapterContextMenuInfo info;
	//
	boolean okay;
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        this.txtName = new EditText(this);
        this.txtName.setHint("NAME");
        this.txtName.setPadding(5, 5, 5, 5);
        
        //
        this.builder = new AlertDialog.Builder(this);
        this.builder.setTitle("ADD NAME");
        this.builder.setView(txtName);
        this.builder.setPositiveButton("OKAY", this);
        this.builder.setNegativeButton("CANCEL", this);
        
        //
        this.dialog = this.builder.create();
        
        
        //
        this.lv = (ListView) this.findViewById(R.id.listView1);
        this.adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //attach the adapter to the ListView
        
        this.lv.setAdapter(adapter);
        // delegate  the context menu
        this.registerForContextMenu(lv);
        
    }

    //create an option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    //assign event listener to the context menu
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id=item.getItemId();
		
		switch(id){
		case R.id.edit: 
		
				this.okay=true;
				this.txtName.setText(list.get(info.position));
				this.dialog.show();
				break;
		case R.id.delete: this.list.remove(info.position);
						  this.adapter.notifyDataSetChanged();
				
			
		}
		
		
		return super.onContextItemSelected(item);
	}
	
	//assign an event listener to the optino mneu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		this.dialog.show();
		return super.onOptionsItemSelected(item);
	}

	// used for creating context menu
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
		
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.contextmenu, menu);
		info = (AdapterContextMenuInfo) menuInfo;
		//display the name of the selected item
		String name =this.list.get(info.position);
		menu.setHeaderTitle(name);
		
		
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		
		//check which alert button is pressed
		switch(arg1){
		case DialogInterface.BUTTON_POSITIVE:
			//get the data from the textfield
			String s = this.txtName.getText().toString();
			//validate if there is data
			if(!s.equals("")){
				if(!this.okay)
					this.list.add(s);
					//update
				else
					this.list.set(info.position,s);
				this.adapter.notifyDataSetChanged();
					
			}else{
				Toast.makeText(this, "Fill Name", Toast.LENGTH_SHORT).show();
				this.okay=false;
			}
			
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			//close the dialog
			this.dialog.dismiss();

		}
		this.txtName.setText(""); //clear the textfield
		
	}
    
}
