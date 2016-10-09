package com.vince.ndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        set("hello world from JniTestApp");
        textView.setText(get());
    }


    public static void methodCalledByJni(String msgFromJni) {
        Log.d(TAG, "methodCalledByJni, msg: " + msgFromJni);
    }


    /**
     * A native method that is implemented by the 'jni-test' native library,
     * which is packaged with this application.
     */
    public native void set(String str);
    public native String get();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("jni-test");
    }
}
