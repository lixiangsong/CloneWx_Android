package song.com.cn.clonewx_andorid.activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2018/11/16 0016.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getApplication() {
        return context;
    }
}
