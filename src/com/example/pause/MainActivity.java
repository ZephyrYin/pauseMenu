package com.example.pause;

import javax.security.auth.PrivateCredentialPermission;

import android.R.attr;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button pauseButton=null;
	private PauseMenu mPauseMenu=null;
	private GamepadSetting mSettingView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
              
        pauseButton=(Button) findViewById(R.id.button1);
        
        pauseButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPauseMenu=new PauseMenu(MainActivity.this);
				mPauseMenu.showAtLocation(MainActivity.this.findViewById(R.id.container), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); 
			}
        	
        }); 
        
        
           
    }   
}
