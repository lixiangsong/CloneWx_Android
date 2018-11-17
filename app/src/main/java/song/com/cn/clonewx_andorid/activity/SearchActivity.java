package song.com.cn.clonewx_andorid.activity;

import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import song.com.cn.clonewx_andorid.BaseActivity;
import song.com.cn.clonewx_andorid.R;

/**
 * @author: LXS
 * @Time: 2018/11/15 0015
 * @Explain: 搜索
 */
public class SearchActivity extends BaseActivity {


    @BindView(R.id.back)
    ImageView back;

    @Override
    public void initView() {
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
