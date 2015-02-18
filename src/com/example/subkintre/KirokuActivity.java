package com.example.subkintre;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class KirokuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kiroku);

		DatabaseHelper Helper = new DatabaseHelper(getApplicationContext());
		SQLiteDatabase db = Helper.getReadableDatabase();
		ListView listView = (ListView) findViewById(R.id.listView1);

		try{
		Cursor c = db.rawQuery("Select*From score Order By id desc", null);
		c.moveToFirst();
			if(c.getCount() > 0){
				Integer[] data = new Integer[c.getCount()];
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
				for(int cnt = 0; cnt < c.getCount(); cnt++){
					data[cnt]=c.getInt(0);
					adapter.add("ID:"+c.getString(0)+"\n実施日時:"+c.getString(1)+",\n回数:"+c.getString(2)+"回");
					c.moveToNext();
					listView.setAdapter(adapter);
				}
			}else listView.setAdapter(null);
		}finally{
			db.close();
		}

		Button nextbtn = (Button) findViewById(R.id.button1);

		nextbtn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent(KirokuActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kiroku, menu);
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
