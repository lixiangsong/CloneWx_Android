package song.com.cn.clonewx_andorid.activity;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;

/**
 * @author: LXS
 * @Time: 2018/11/21 0021
 * @Explain: Application
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //极光推送
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
    }

    public static Context getApplication() {
        return context;
    }
}
