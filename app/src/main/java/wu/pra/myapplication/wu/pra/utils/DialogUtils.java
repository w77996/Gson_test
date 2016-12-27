package wu.pra.myapplication.wu.pra.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2016/12/3.
 */
public class DialogUtils {

    public  Context context;
    public  ProgressDialog mProgressDialog;

    public DialogUtils(Context context){
        this.context =context;
    }

    public  void showProgressDialog(){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage("正在加载");
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        mProgressDialog.show();
    }
    public  void closeProgressDialog(){
        if(mProgressDialog!= null){
            mProgressDialog.dismiss();
        }
    }
}
