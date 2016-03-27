package com.example.notegallery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateFolder extends Activity {
	
	Button makeFolderBtn;
	EditText folderName;
	final ArrayList<String> allFolders = new ArrayList<String>();
	File mainDir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_folder);
		this.makeFolderBtn = (Button) findViewById(R.id.makeFolderBtn);
		this.folderName = (EditText) findViewById(R.id.folder_name);
		
				
		mainDir = new File(Environment.getExternalStorageDirectory().getPath()+"/NoteGallery");
		mainDir.mkdir();	
		
		try {
            FileOutputStream out = new FileOutputStream(mainDir);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		this.makeFolderBtn.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				String dirName = folderName.getText().toString();
				File insideDir = new File(Environment.getExternalStorageDirectory().getPath()+"/NoteGallery/"+dirName);
				insideDir.mkdir();
				folderName.setText("");
				Toast.makeText(getApplicationContext(), "Directory Created", Toast.LENGTH_LONG).show();
				startActivity(new Intent(CreateFolder.this, MainActivity.class));
		}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_folder, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
