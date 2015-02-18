package com.example.subkintre;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "mydata.db";
	private static final int DATABASE_VERSION = 2;
	private static final String TABLE_NAME = "score";
	private static final String ID = "id";
	private static final String CREATED  = "created";
	private static final String KAISU = "kaisu";

	DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		String query = "create table " + TABLE_NAME + "(" +ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +CREATED + " text," +KAISU + " text);";
		db.execSQL(query);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("drop table if exists " + TABLE_NAME);
		onCreate(db);

	}


}
