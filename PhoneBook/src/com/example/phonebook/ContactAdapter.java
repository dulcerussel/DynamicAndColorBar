package com.example.phonebook;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter {
	
	
	Context context;
	ArrayList<Contact> list;
	LayoutInflater inflater;
	
	

	public ContactAdapter(Context context, ArrayList<Contact> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		ContactHandler handler=null;
		if(arg1==null){
			arg1=inflater.inflate(R.layout.itemlayout, null);
			handler=new ContactHandler();
			handler.iv=(ImageView) arg1.findViewById(R.id.imageview1);
			handler.name=(TextView) arg1.findViewById(R.id.textView1);
			handler.phone=(TextView) arg1.findViewById(R.id.textView2);
			arg1.setTag(handler);
		}else handler=(ContactHandler) arg1.getTag();
		
		handler.iv.setImageURI(list.get(arg0).getContactImage());
		handler.name.setText(list.get(arg0).getContactName());
		handler.phone.setText(list.get(arg0).getContactPhone());
		
		
		return arg1;
	}

	static class ContactHandler{
		ImageView iv;
		TextView name,phone;
	}
	
}
