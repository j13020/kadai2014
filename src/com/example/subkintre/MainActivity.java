package com.example.subkintre;

import java.util.Calendar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int Count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DatabaseHelper Helper = new DatabaseHelper(this);
		final SQLiteDatabase db = Helper.getWritableDatabase();

		Button countbtn = (Button) findViewById(R.id.button1);
		countbtn.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO 自動生成されたメソッド・スタブ
				Count++;
				TextView countView = (TextView) findViewById(R.id.textView1);
				countView.setText(String.valueOf(Count));

			}

		});

		Button insertbtn = (Button) findViewById(R.id.button2);
		insertbtn.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO 自動生成されたメソッド・スタブ
				String created = Calendar.getInstance().getTime().toString();
				int kaisu = Count;
				ContentValues values = new ContentValues();
				values.put("created", created);
				values.put("kaisu", kaisu);
				long rowID = db.insert("score", "", values);
				if(rowID==-1){
					db.close();
					throw new SQLException("Failed to insert row");
				}db.close();

			}

		});

		Button nextbtn = (Button) findViewById(R.id.button3);

		nextbtn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(MainActivity.this, KirokuActivity.class);
				startActivity(intent);
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
