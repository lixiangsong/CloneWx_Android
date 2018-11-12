package song.com.cn.clonewx_andorid.activity;

import song.com.cn.clonewx_andorid.BaseActivity;
import song.com.cn.clonewx_andorid.R;
/**
 *
 * @author: LXS
 * @Time:  2018/11/12 0012
 * @Explain: 启动页 -------- 这里可以做很多事情，写demo 没事情做
 */
public class SplashActivity extends BaseActivity {

    @Override
    public void initView() {
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goIntent(MainActivity.class);
            }
        }).start();
    }

    @Override
    public void initData() {

    }
}
