package song.com.cn.clonewx_andorid.friend;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import song.com.cn.clonewx_andorid.BaseActivity;
import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.bean.ChatBean;


/**
 * @author: LXS
 * @Time: 2018/11/15 0015
 * @Explain: 朋友圈
 */
public class FriendActivity extends BaseActivity {
    @BindView(R.id.back1_iv)
    ImageView back1Iv;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.back_iv)
    ImageView backIv;
    @BindView(R.id.hide_title_rl)
    RelativeLayout hideTitleRl;
    @BindView(R.id.image_white)
    ImageView imageWhite;
    @BindView(R.id.title_temp)
    ImageView titleTemp;
    @BindView(R.id.nested_view)
    NestedScrollView nestedView;
    @BindView(R.id.text_tv)
    TextView textTv;

    private FriendAdapter friendAdapter;
    private List<ChatBean> list = new ArrayList<>();
    private int scrolHeiht = 200;//滑动到什么地方高度，发生渐变

    @Override
    public void initView() {
        setContentView(R.layout.activity_friend);
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        list.add(new ChatBean());
        friendAdapter = new FriendAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(friendAdapter);
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);

        nestedView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                //判断滑动到一定高度才进行变化
                if (scrollY > scrolHeiht) {
                    //透明度，公式
                    float alpha = 1 - ((float) scrollY - scrolHeiht) / 100;
                    if (alpha > 0) {
                        //改变 alpha 值
                        back1Iv.setAlpha(alpha);
                        imageWhite.setAlpha(alpha);
                        hideTitleRl.setAlpha(1 - alpha);
                        textTv.setAlpha(1 - alpha);
                    } else {
                        hideTitleRl.setAlpha(1.0f);
                        textTv.setAlpha(1.0f);
                    }
                } else {
                    //完全显示 灰色背景图片
                    back1Iv.setAlpha(1.0f);
                    imageWhite.setAlpha(1.0f);
                    hideTitleRl.setAlpha(0f);
                }
            }
        });
    }

    @OnClick({R.id.back1_iv, R.id.back_iv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back1_iv:
                finish();
                break;
            case R.id.back_iv:
                finish();
                break;
        }
    }
}
