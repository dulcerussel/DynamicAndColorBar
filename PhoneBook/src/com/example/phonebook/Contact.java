package com.example.phonebook;

import android.net.Uri;

public class Contact {

	//define the attributes
	private int id;
	private Uri contactImage;
	private String contactName;
	private String contactPhone;
	
	public Contact(Uri contactImage, String contactName, String contactPhone) {
		super();
		this.contactImage = contactImage;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
	}

	public Contact(int id,Uri contactImage, String contactName, String contactPhone) {
		super();
		this.id=id;
		this.contactImage = contactImage;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
	}
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Uri getContactImage() {
		return contactImage;
	}

	public void setContactImage(Uri contactImage) {
		this.contactImage = contactImage;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
