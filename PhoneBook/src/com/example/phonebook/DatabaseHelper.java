package com.example.phonebook;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	final static String DB="db_contact";	//database name
	final static String CONTACT="tbl_contact";	//table name
	

	public DatabaseHelper(Context context) {
		super(context, DB, null, 1);
		// create the database
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		//create table(s)
		String sql="CREATE TABLE "+CONTACT+"(id integer primary key autoincrement,image varchar(50),name varchar(50),phone varchar(25))";
		arg0.execSQL(sql);
	}

	
	//add a new contact
	public long addContact(Contact contact){
		long result=0;
		//open a database for writing
		SQLiteDatabase db=this.getWritableDatabase();
		//we will use the recommended ORM (Object Relational Map), ContentValues
		ContentValues cv=new ContentValues();
			//load the data to the ORM
			//cv.put("id", contact.getId());
			cv.put("image", contact.getContactImage().toString());
			cv.put("name", contact.getContactName());
			cv.put("phone", contact.getContactPhone());
			//write the data to a specified table
			//NOTE: every new data added to the table, the record pointer moves one position forward
			result=db.insert(CONTACT, null, cv);
		return result;
	}
	
	//get all contact(s)
	public ArrayList<Contact>getAll(){
		ArrayList<Contact> list=new ArrayList<Contact>();
		//open database for reading
		SQLiteDatabase db=this.getReadableDatabase();
		//we will use the recommended ORM (Object Relational Map), Cursor
		Cursor c=db.query(CONTACT, null, null, null, null, null, "name");
			//reposition the record pointer to the first record
			c.moveToFirst();
			while(!c.isAfterLast()){
				//readind data
				int id=c.getInt(c.getColumnIndex("id"));
				String image=c.getString(c.getColumnIndex("image"));
				String name=c.getString(c.getColumnIndex("name"));
				String phone=c.getString(c.getColumnIndex("phone"));
				//create a Contact object to be written to the list
				Contact contact=new Contact(id,Uri.parse(image),name,phone);
				//add to list
				list.add(contact);
				//move the record pointer forward
				c.moveToNext();
			}
		return list;
	}
	
	//delete record
	public int deleteRecord(Contact contact){
		int result=0;
			SQLiteDatabase db=this.getWritableDatabase();
			result=db.delete(CONTACT, "id=?", new String[]{contact.getId()+""});
		return result;
	}
	
	//update a record
	public long updateRecord(Contact contact){
		long result=0;
		//open a database for writing
		SQLiteDatabase db=this.getWritableDatabase();
		//we will use the recommended ORM (Object Relational Map), ContentValues
		ContentValues cv=new ContentValues();
			//load the data to the ORM
			//cv.put("id", contact.getId());
			cv.put("image", contact.getContactImage().toString());
			cv.put("name", contact.getContactName());
			cv.put("phone", contact.getContactPhone());
			//write the data to a specified table
			//NOTE: every new data added to the table, the record pointer moves one position forward
			result=db.update(CONTACT, cv, "id=?", new String[]{contact.getId()+""});
		return result;
	}
	
	
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// update table(s)
	}

}
