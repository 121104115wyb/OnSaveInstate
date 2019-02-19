package com.btzh.onsaveinstate;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * activity 的生命周期会随着屏幕的左右切换，进行改变
 * 当 手机的屏幕进行左右切换时，activity会销毁重新创建一个新的activity
 * 这时我们的当前的界面的数据就会丢失，怎么才能处理这种情况呢
 * 我们需要重载activity的onsaveInstanceState方法
 */
public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            String test = savedInstanceState.getString("test");
            String name = savedInstanceState.getString("name");
            Toast.makeText(this, "test is :" + test + "\n" + "name is :" + name, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onCreate: ");
        }
    }

    //把我们需要保存的数据保存在这里，然后在oncreate的方法中重新取出来就可以
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("test", "12345678");
        outState.putString("name", "wyb");
    }
}
