package wu.pra.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import wu.pra.myapplication.wu.pra.utils.HttpUtils;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils.getJsonData("北京");

       // HttpUtils.getJsonData("广州");

    }
}