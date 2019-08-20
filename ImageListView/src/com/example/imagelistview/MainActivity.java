package com.example.imagelistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;


public class MainActivity extends Activity {
	//define the listview
	ListView lv;
	//define the data con
	ArrayList<Student> list = new ArrayList<Student>();
	//define the  adapter
	ItemAdapter adapter;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //instantiate the properties
        this.lv = (ListView) this.findViewById(R.id.listView1);
        //fill the container
        list.add(new Student(R.drawable.img1,"DURANO,Dennis","BS-CPE 3"));
        list.add(new Student(R.drawable.img2,"DULCE,Russel","BS-IT 4"));
        list.add(new Student(R.drawable.img3,"OGANG,Jomar","BS-CE 1"));
        list.add(new Student(R.drawable.img4,"HINOGUIN,Ethel","BS-HRM 2"));
        list.add(new Student(R.drawable.img5,"GAKO,Ana","BS-CJ 3"));
        this.adapter = new ItemAdapter(this,list);
        //attach the adapter
        this.lv.setAdapter(adapter);
    }

    
  
    
}
