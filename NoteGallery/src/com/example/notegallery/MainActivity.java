package com.example.notegallery;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	Button btnMakeDir;
	//EditText addDirName;
	static final String mainDir = "NoteGallery";
	FileOutputStream outputStream;
	private Context context;
//	ArrayAdapter<String> adapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnMakeDir = (Button) findViewById(R.id.btnMakeDir);
		CreateFolder foldersObj = new CreateFolder();
		
//		File[] folders = foldersObj.mainDir.listFiles();
//		String[] folderName2 = new String[folders.length];
//		
			
//		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,folderName2);
//		setListAdapter(adapter);
//		adapter.notifyDataSetChanged();	
		
//		for(int i = 0; i<folders.length; i++){
//			folderName2[i] = folders[i].getName();
//			Log.d("Name: ", folders[i].getName());
//		}	
		btnMakeDir.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, CreateFolder.class));
				
		}});
		
	}
	
	public Bitmap getbitmap(String path){
	    Bitmap imgthumBitmap=null;
	     try    
	     {

	         final int THUMBNAIL_SIZE = 64;

	         FileInputStream fis = new FileInputStream(path);
	          imgthumBitmap = BitmapFactory.decodeStream(fis);

	         imgthumBitmap = Bitmap.createScaledBitmap(imgthumBitmap,
	                THUMBNAIL_SIZE, THUMBNAIL_SIZE, false);

	        ByteArrayOutputStream bytearroutstream = new ByteArrayOutputStream(); 
	        imgthumBitmap.compress(Bitmap.CompressFormat.JPEG, 100,bytearroutstream);


	     }
	     catch(Exception ex) {

	     }
	     return imgthumBitmap;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
