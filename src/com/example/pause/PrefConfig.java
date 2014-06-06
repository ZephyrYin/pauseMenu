package com.example.pause;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.MediaStore.Audio.Media;

public class PrefConfig {
	//private Context context;
	private SharedPreferences mSP;
	private SharedPreferences.Editor mEd;
	
	public PrefConfig(Context context){
		this.mSP=PreferenceManager.getDefaultSharedPreferences(context);
		this.mEd=mSP.edit();
	}
	
	public boolean checkKey(String key){
		return mSP.contains(key);
	}
	
	public boolean getBoolValue(String key){
		boolean value=false;
		return mSP.getBoolean(key, value);
	}
	
	public void putValue(String key,Boolean value){
		mEd.putBoolean(key, value);
		mEd.commit();
	}
	
	public void putValue(String key,Float value){
		mEd.putFloat(key, value);
		mEd.commit();
	}
	
	public void putValue(String key,int value){
		mEd.putInt(key, value);
		mEd.commit();
	}
	
	public void putValue(String key,long value){
		mEd.putLong(key, value);
		mEd.commit();
	}
	
	public void putValue(String key,String value){
		mEd.putString(key, value);
		mEd.commit();
	}
}
