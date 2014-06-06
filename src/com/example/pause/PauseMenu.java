package com.example.pause;

import android.widget.PopupWindow;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;
import android.text.style.SuperscriptSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;

public class PauseMenu extends PopupWindow{
	 private Button mBtnSet, mBtnStra, mBtnScreen,mBtnCancel;
     private View mMenuView;
     private GamepadSetting mGpSetting=null;
     private OnClickListener itemsOnClick=null;
     
     @SuppressLint("NewApi")
	public PauseMenu(Activity context) {
             super(context);
             LayoutInflater inflater = (LayoutInflater) context
                             .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             mMenuView = inflater.inflate(R.layout.pause_menu, null);
             //mSettingView = inflater.inflate(R.layout.gamepad_setting, null);
             mBtnSet = (Button) mMenuView.findViewById(R.id.btn_settings);
             mBtnStra = (Button) mMenuView.findViewById(R.id.btn_strategy);
             mBtnScreen = (Button) mMenuView.findViewById(R.id.btn_screenshot);
             mBtnCancel = (Button) mMenuView.findViewById(R.id.btn_cancel);
             
             itemsOnClick=new OnClickListener(){

           		@Override
           		public void onClick(View v) {
           			// TODO Auto-generated method stu
           			//dismiss();
           			switch (v.getId()) {
           			case R.id.btn_settings:{
           				Intent intent = new Intent(mMenuView.getContext(), GamepadSetting.class); 
           		        mMenuView.getContext().startActivity(intent); 
           				//dismiss();
           				//setContentView(new GamepadSetting(MainActivity.this)); 				         				           				
           				
           				Log.d("button", "set");
           			}
           				break;
           			case R.id.btn_strategy:{
           				Log.d("button", "strategy");
           			}
           				break;
           			case R.id.btn_screenshot:{
           				Log.d("button", "shot");
           			}
           				break;
           			case R.id.btn_cancel:{
           				Log.d("button", "cancel");
           				dismiss();
           			}
           				break;

           			default:
           				break;
           			}
           		} 	
              };
               
             //设置按钮监听
             mBtnSet.setOnClickListener(itemsOnClick);
             mBtnStra.setOnClickListener(itemsOnClick);
             mBtnScreen.setOnClickListener(itemsOnClick);
             mBtnCancel.setOnClickListener(itemsOnClick);
             
             //设置SelectPicPopupWindow的View
             this.setContentView(mMenuView);
             //设置SelectPicPopupWindow弹出窗体的宽
             this.setWidth(LayoutParams.FILL_PARENT);
             //设置SelectPicPopupWindow弹出窗体的高
             this.setHeight(LayoutParams.FILL_PARENT);
             //设置SelectPicPopupWindow弹出窗体可点击
             this.setFocusable(true);
             //设置SelectPicPopupWindow弹出窗体动画效果
             //this.setAnimationStyle(R.style.AnimBottom);
             //实例化一个ColorDrawable颜色为半透明
             ColorDrawable dw = new ColorDrawable(0xb0000000);
             //设置SelectPicPopupWindow弹出窗体的背景
             this.setBackgroundDrawable(dw);
             //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
//             mMenuView.setOnTouchListener(new OnTouchListener() {
//                     
//                     public boolean onTouch(View v, MotionEvent event) {
//                             
//                             int height = mMenuView.findViewById(R.id.pause_menu_layout).getTop();
//                             int y=(int) event.getY();
//                             if(event.getAction()==MotionEvent.ACTION_UP){
//                                     if(y<height){
//                                             dismiss();
//                                     }
//                             }                                
//                             return true;
//                     }
//             });

     }

	}
