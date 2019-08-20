package com.example.imagelistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

	//define user
	
	Context context;
	
	//define data container
	ArrayList<Student> list;
	//define the layout container
	LayoutInflater inflater;
	
	//create a constructor
	public ItemAdapter(Context context, ArrayList<Student> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater= LayoutInflater.from(context);
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
		// TODO Auto-generated method stub
		
		StudentHolder holder=null;
		if(arg1==null){
			arg1=this.inflater.inflate(R.layout.itemlayout, null);
			holder=new StudentHolder();
			holder.iv= (ImageView) arg1.findViewById(R.id.imageView1);
			holder.name= (TextView) arg1.findViewById(R.id.textView1);
			holder.course = (TextView) arg1.findViewById(R.id.textView2);
			//delegate the design to the view
			arg1.setTag(holder);
			
		}else holder=(StudentHolder) arg1.getTag();
		//combine the data
		holder.iv.setImageResource(list.get(arg0).getImage());
		holder.name.setText(list.get(arg0).getName());
		holder.course.setText(list.get(arg0).getCourse());
		
		
		
		return arg1;
	}
	
	//create static item holder
	
	static class StudentHolder{
		ImageView iv;
		TextView name,course;
		
		
		
	}

}
