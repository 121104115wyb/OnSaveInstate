package com.btzh.onsaveinstate;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * activity 的生命周期会随着屏幕的左右切换，进行改变
 * 当 手机的屏幕进行左右切换时，activity会销毁重新创建一个新的activity
 * 这时我们的当前的界面的数据就会丢失，怎么才能处理这种情况呢
 * 我们需要重载activity的onsaveInstanceState方法
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("------>onCreate");
        if (savedInstanceState != null) {
            String test = savedInstanceState.getString("test");
            String name = savedInstanceState.getString("name");
            Toast.makeText(this, "test is :" + test + "\n" + "name is :" + name, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onCreate: ");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("------>onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("------>onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("------>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("------>onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("------>onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("------>onDestroy");
    }

    //把我们需要保存的数据保存在这里，然后在oncreate的方法中重新取出来就可以
    //该方法在检测到触摸系统的返回键时并不会执行，只有在activity跳转
    //屏幕旋转，点击home键时才会执行，并切执行在onpause()和onstop()生命周期之间
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("------>onSaveInstanceState");
        outState.putString("test", "12345678");
        outState.putString("name", "wyb");
    }


    /**
     * 数据恢复，只有在手机屏幕旋转并且activity重新创建后，才执行该方法，该方法
     * 是执行在activity的onstart和onresume中的
     * 当activity被正常杀死后，再次启动activity并不会执行该方法
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("------>onRestoreInstanceState");
    }



    public void textView(View view) {

        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}
