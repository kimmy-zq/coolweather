package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{
	
	/*
	 province建表语句
	
	 */
	public static final String CREATE_PROVINCE =  "create table Province ("   //将建表语句定义为常量
			+ "id integer primary key autoincrement , "   //id 为自增长主键
			+ "province_name text , " 			//	省名     "  
			+ "province_code text )";			//	省代号
	
	public static final String CREATE_CITY = "create table City ("
			+ "id integer primary key autoincrement , "
			+ "city_name text , "
			+ "city_code text , "
			+ "province_id integer) " ;		//	关联  省表的外键 
		
	public static final String CREATE_COUNTY = "create table COUNTY ("
			+ "id integer primary key autoincrement , "
			+ "COUNTY_name text , "
			+ "COUNTY_code text , "
			+ "city_id integer) " ;		//	关联  城市表的外键 
	
	
	public CoolWeatherOpenHelper(Context context , String name , CursorFactory factory , 
			int version) { 
				super(context, name, factory,version);		//因为这个Context参数需要导包没有这个类型
	}
	
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE) ; 			//创建省表 将建表语句定义为常量 在这个方法里面执行创建
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);		
	}
	
	public void onUpgrade(SQLiteDatabase db ,int oldVersion , int newVersion)
	{
		}
	
}
