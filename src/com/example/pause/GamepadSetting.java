package com.example.pause;

import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.R.integer;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract.Root;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Space;
import android.widget.Switch;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GamepadSetting extends ListActivity{
	
	private ListView lv;
	private Switch mSwitch=null;
	private List<String> mData;
	private List<String> mKey;
	private PrefConfig mPrefConfig;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamepad_setting);
        
        mData=getData();
        mKey=initKey();
        //lv=(ListView)findViewById(R.id.list);
       // lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
        
        MyAdapter mAdapter=new MyAdapter(this);
        //lv.setAdapter(mAdapter);
        setListAdapter(mAdapter);
        // The activity is being created.
    }
	
	private List<String> getData(){
		List<String> data=new ArrayList<String>();
		
		data.add("switch gamepad");
		data.add("sound");
		data.add("vibrate");
		return data;
	}
	
	private List<String> initKey(){
		List<String> data=new ArrayList<String>();
		
		data.add("null");
		data.add("sound");
		data.add("vibrate");
		return data;
	}
	
	public class ViewHolder{
		public TextView info;
		public Switch viewSwitch;
	}
	
	public class MyAdapter extends BaseAdapter{
		private LayoutInflater mInflater;
		
		public MyAdapter(Context context){
			this.mInflater=LayoutInflater.from(context);
		}
		
		@Override
		public int getCount(){
			return mData.size();
		}
		
		@Override
		public Object getItem(int arg0){
			return null;
		}
		
		@Override
		public long getItemId(int arg0){
			return 0;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			ViewHolder holder=null;
			if(convertView==null){
				holder=new ViewHolder();
				
				convertView=mInflater.inflate(R.layout.list_item, null);
				holder.info=(TextView)convertView.findViewById(R.id.info);
				holder.viewSwitch=(Switch)convertView.findViewById(R.id.switch1);
				holder.viewSwitch.setTag(position);		
//				if(position==0)
//					holder.viewSwitch.setVisibility(View.INVISIBLE);
				mPrefConfig=new PrefConfig(getApplicationContext());
				switch (position) {			
				case 0:{
					holder.viewSwitch.setVisibility(View.INVISIBLE);
				}
					break;
				case 1:
				case 2:{
					if(mPrefConfig.checkKey((String)mKey.get(position))){
						holder.viewSwitch.setChecked(mPrefConfig.getBoolValue((String)mKey.get(position)));
					}else{
						holder.viewSwitch.setChecked(true);
						mPrefConfig.putValue((String)mKey.get(position), true);
					}
				}
				default:
					break;
				}
				convertView.setTag(holder);
				
				holder.info.setText((String)mData.get(position));	
				holder.viewSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					
					@Override
					public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
						// TODO Auto-generated method stub
						int tag=Integer.parseInt(buttonView.getTag().toString());
						Toast.makeText(getApplicationContext(), String.valueOf(tag),
							     Toast.LENGTH_SHORT).show();
						switch (tag) {
						case 1:		
						case 2:{		
							mPrefConfig.putValue((String)mKey.get(tag), isChecked);
						}
							break;
						default:
							break;
						}
					}
				});
			}else {
				holder=(ViewHolder)convertView.getTag();
			}
					
			return convertView;
		}
	}
	
	@Override
	protected void onListItemClick(ListView l,View v,int position,long id){
		Toast.makeText(getApplicationContext(), "position"+String.valueOf(position)+"id"+String.valueOf(id),
			     Toast.LENGTH_SHORT).show();
	}
}
