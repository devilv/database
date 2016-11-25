package com.example.database;



import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import  android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

public class Firstpage extends Activity {

Button button1,button2,button3,button4,button5,button6;
EditText edt1,edt2,edt3,edt4;
ListView listview;
String usn,pwd;
Dbdemo d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstpage);
		 d=new Dbdemo(this);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		button3=(Button)findViewById(R.id.button3);
		button4=(Button)findViewById(R.id.button4);
		button5=(Button)findViewById(R.id.button5);
		button6=(Button)findViewById(R.id.button6);
		listview=(ListView)findViewById(R.id.listview);
		edt1=(EditText)findViewById(R.id.edt1);
		edt2=(EditText)findViewById(R.id.edt2);
		edt3=(EditText)findViewById(R.id.edt3);
		edt4=(EditText)findViewById(R.id.edt4);
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				usn=edt1.getText().toString();
				pwd=edt2.getText().toString();
				d.addData(usn,pwd);
				Toast toast= Toast.makeText(Firstpage.this,"data inserted",Toast.LENGTH_LONG);
				toast.show();
			}
		});
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				d.deleteAll();
				Toast toast= Toast.makeText(Firstpage.this,"data deleted",Toast.LENGTH_LONG);
				toast.show();
			}
		});
		button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				d.partialDelete(edt3.getText().toString());
				Toast toast= Toast.makeText(Firstpage.this,"username deleted",Toast.LENGTH_LONG);
				toast.show();
			}
		});
		button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pwd=edt4.getText().toString();
				//usn="varr";
				d.update(usn,pwd);
				Toast toast= Toast.makeText(Firstpage.this,"password updated",Toast.LENGTH_LONG);
				toast.show();
			}
		});
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor c=d.show();
				c.moveToFirst();
								
				for(int i=0;i<c.getCount();i++);
				String aa=c.getString(c.getColumnIndexOrThrow("username"));
				String bb=c.getString(c.getColumnIndexOrThrow("password"));
				
				 Toast.makeText(Firstpage.this,""+aa+bb,Toast.LENGTH_LONG).show();
				
				c.moveToNext();
				
			
			}
		});
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				d.deleteRow(1);
			}
		});
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

}
