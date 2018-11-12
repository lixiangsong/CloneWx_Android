package song.com.cn.clonewx_andorid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/11/12 0012.
 */

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

}
