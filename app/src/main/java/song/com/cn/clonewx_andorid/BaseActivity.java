package song.com.cn.clonewx_andorid;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author: LXS
 * @Time: 2018/11/12 0012
 * @Explain: 基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //保持竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.color33333));
        }

        initView();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

    /**
     * 不带参数的跳转
     *
     * @param zlazz
     */
    public void goIntent(Class zlazz) {
        Intent intent = new Intent(this, zlazz);
        startActivity(intent);
    }

    /**
     * 带参数的跳转
     *
     * @param zlazz
     */
    public void goIntent(Bundle bundle, Class zlazz) {
        Intent intent = new Intent(this, zlazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 提示
     *
     * @param msg
     */
    public void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
