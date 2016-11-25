package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract.Contacts.Data;
import android.database.Cursor;


 class Dbdemo extends SQLiteOpenHelper {
	 SQLiteDatabase db;
	 public Dbdemo(Context c){
		 super(c, "MuDb", null, 1);
	 }
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String str="create table MyTB(username varchar(10),password varchar(10))";
		db.execSQL(str);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String str=("DROP TABLE IF EXSISTS");
		db.execSQL(str);
	}
    public void addData(String usn,String pwd){
    	db=this.getReadableDatabase();
    	ContentValues cv=new ContentValues();
    	cv.put("username", usn);
    	cv.put("password", pwd);
    	db.insert("MyTB",null,cv);
    }
    public void deleteAll(){
    	db=this.getWritableDatabase();
    	db.delete("MyTB", null, null);
    }
    public void partialDelete(String usn){
    	db=this.getWritableDatabase();
    	db.delete("MyTB", "username=?", new String[]{usn});
    	    	}
   
    public void deleteRow(long id)
    {
    	db=this.getWritableDatabase();
    	db.delete("MyTB", "rowID='"+id+"'", null);
    }
    public void update(String usn,String pwd){
    	db=this.getReadableDatabase();
    	ContentValues cv= new ContentValues();
    	
    	cv.put("password", pwd);
    	db.update("MyTB",cv, "username=?",new String[]{usn});
    	
    }
    public Cursor show()
    {
    	Cursor c;
    	db=this.getReadableDatabase();
    	c=db.query("MyTB", new String[]{"usn","pwd"}, null, null, null,null,null);
    	return c;
    }
   }
		 
	 
	


