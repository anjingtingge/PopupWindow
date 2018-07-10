package com.example.wangyajie.animation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView mybut,mybut1; // 定义按钮
    private PopupWindow popWin = null; // 弹出窗口
    private View popView = null; // 保存弹出窗口布局
    private boolean show=true;
    private TextView tv1,tv2,tv3;

    private MyBtnClicker myBtnClicker = new MyBtnClicker();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main); // 调用布局管理器
        mybut=findViewById(R.id.mybut);
        mybut.setOnClickListener(myBtnClicker);

        mybut1=findViewById(R.id.mybut1);
        mybut1.setOnClickListener(myBtnClicker);


//        LayoutInflater inflater = LayoutInflater.from(MainActivity.this); // 取得LayoutInflater对象
        popView=LayoutInflater.from(MainActivity.this).inflate(R.layout.cztest_popwin, null);
//        MainActivity.this.popView = inflater.inflate(
//                R.layout.cztest_popwin, null); // 读取布局管理器
    popWin = new PopupWindow(popView,
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true); // 实例化PopupWindow
        // 设置PopupWindow的弹出和消失效果
//        MainActivity.this.popWin
//                .setAnimationStyle(R.style.popupAnimation);

      popWin.setAnimationStyle(R.style.popupAnimation);
//获取id
//         contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.cztest_popwin, null);


        //设置各个控件的点击响应
       tv1 = (TextView)popView.findViewById(R.id.pop_computer);
      tv2 = (TextView)popView.findViewById(R.id.pop_financial);
       tv3 = (TextView)popView.findViewById(R.id.pop_manage);
        tv1.setOnClickListener(myBtnClicker);
        tv2.setOnClickListener(myBtnClicker);
        tv3.setOnClickListener(myBtnClicker);


    }



    private class MyBtnClicker implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mybut:
                    if (show==true)
                    {

//设置焦点false
             popWin.setFocusable(false);
              popWin.showAtLocation(view,Gravity.NO_GRAVITY, 0, 190); // 显示弹出窗口
//                        popWin.showAtLocation(View parent, int gravity, int x, int y)
                        show=false;
                    }
                    else
                        {
//                      popWin.setAnimationStyle(R.style.popupAnimation);
                      popWin.dismiss();
                        show=true;
                        }
                    break;

                case R.id.mybut1:
                    mybut1.setBackgroundColor(Color.BLUE);

                    break;
                case R.id.pop_computer:
//                    Toast.makeText(this,"clicked computer",Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "这是电脑", Toast.LENGTH_LONG).show();
                    break;
                case R.id.pop_financial:
//                    Toast.makeText(this,"clicked computer",Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "这是你好", Toast.LENGTH_LONG).show();
                    break;
                case R.id.pop_manage:
//                    Toast.makeText(this,"clicked computer",Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "这是哈哈", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

}