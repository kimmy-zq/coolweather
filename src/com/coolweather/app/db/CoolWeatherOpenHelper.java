package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{
	
	/*
	 province�������
	
	 */
	public static final String CREATE_PROVINCE =  "create table Province ("   //��������䶨��Ϊ����
			+ "id integer primary key autoincrement , "   //id Ϊ����������
			+ "province_name text , " 			//	ʡ��     "  
			+ "province_code text )";			//	ʡ����
	
	public static final String CREATE_CITY = "create table City ("
			+ "id integer primary key autoincrement , "
			+ "city_name text , "
			+ "city_code text , "
			+ "province_id integer) " ;		//	����  ʡ������ 
		
	public static final String CREATE_COUNTY = "create table COUNTY ("
			+ "id integer primary key autoincrement , "
			+ "COUNTY_name text , "
			+ "COUNTY_code text , "
			+ "city_id integer) " ;		//	����  ���б����� 
	
	
	public CoolWeatherOpenHelper(Context context , String name , CursorFactory factory , 
			int version) { 
				super(context, name, factory,version);		//��Ϊ���Context������Ҫ����û���������
	}
	
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE) ; 			//����ʡ�� ��������䶨��Ϊ���� �������������ִ�д���
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);		
	}
	
	public void onUpgrade(SQLiteDatabase db ,int oldVersion , int newVersion)
	{
		}
	
}
