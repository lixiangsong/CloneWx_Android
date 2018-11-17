package song.com.cn.clonewx_andorid.activity;

import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import song.com.cn.clonewx_andorid.BaseActivity;
import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.adapter.HomeFragmentPagerAdapter;
import song.com.cn.clonewx_andorid.adapter.PopupWindowAdapter;
import song.com.cn.clonewx_andorid.bean.MessageEvent;
import song.com.cn.clonewx_andorid.bean.PopupBean;
import song.com.cn.clonewx_andorid.fragment.ChatFragment;
import song.com.cn.clonewx_andorid.fragment.FindFragment;
import song.com.cn.clonewx_andorid.fragment.MailTXFragment;
import song.com.cn.clonewx_andorid.fragment.MyFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.view_page)
    ViewPager viewPage;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @BindView(R.id.chat_rb)
    RadioButton chatRb;
    @BindView(R.id.mail_rb)
    RadioButton mailRb;
    @BindView(R.id.find_rb)
    RadioButton findRb;
    @BindView(R.id.my_rb)
    RadioButton myRb;
    @BindView(R.id.right_iv)
    ImageView rightIv;
    @BindView(R.id.search_iv)
    ImageView searchIv;
    private ChatFragment chatFragment;
    private MailTXFragment mailTXFragment;
    private FindFragment findFragment;
    private MyFragment myFragment;
    private List<Fragment> fragmentList = new ArrayList<>();
    private HomeFragmentPagerAdapter homeFragmentPagerAdapter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        radioGroup.setOnCheckedChangeListener(this);
        searchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goIntent(SearchActivity.class);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getX = (int) ev.getX();
        getY = (int) ev.getY();
        return super.dispatchTouchEvent(ev);
    }

    public static int getX;
    public static int getY;

    @Override
    public void initData() {
        chatFragment = new ChatFragment();
        mailTXFragment = new MailTXFragment();
        findFragment = new FindFragment();
        myFragment = new MyFragment();
        fragmentList.add(chatFragment);
        fragmentList.add(mailTXFragment);
        fragmentList.add(findFragment);
        fragmentList.add(myFragment);
        homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPage.setAdapter(homeFragmentPagerAdapter);

        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.chat_rb);
                        break;
                    case 1:
                        radioGroup.check(R.id.mail_rb);
                        break;
                    case 2:
                        radioGroup.check(R.id.find_rb);
                        break;
                    case 3:
                        radioGroup.check(R.id.my_rb);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //右上角加号按钮 数据
        popu.clear();
        popu.add(new PopupBean(R.mipmap.chat_add_ic, "发起群聊"));
        popu.add(new PopupBean(R.mipmap.add_ic_frend, "添加好友"));
        popu.add(new PopupBean(R.mipmap.ic_sao_yi_sao, "扫一扫"));
        popu.add(new PopupBean(R.mipmap.ic_youxiang, "帮助与反馈"));

        rightIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.chat_rb:
                viewPage.setCurrentItem(0);
                break;
            case R.id.mail_rb:
                viewPage.setCurrentItem(1);
                break;
            case R.id.find_rb:
                viewPage.setCurrentItem(2);
                break;
            case R.id.my_rb:
                viewPage.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    private List<PopupBean> popu = new ArrayList<>();
    private PopupWindow popupWindow;

    private void showPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.popup_window_item, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PopupWindowAdapter po = new PopupWindowAdapter(popu);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(po);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //测量view 注意这里，如果没有测量  ，下面的popupHeight高度为-2  ,因为LinearLayout.LayoutParams.WRAP_CONTENT这句自适应造成的
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
//        int[] location = new int[2];
        // 允许点击外部消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());//注意这里如果不设置，下面的setOutsideTouchable(true);允许点击外部消失会失效
        popupWindow.setOutsideTouchable(true);   //设置外部点击关闭ppw窗口
        popupWindow.setFocusable(true);
        // 获得位置 这里的v是目标控件，就是你要放在这个v的上面还是下面
//        rightIv.getLocationOnScreen(location);
        //这里就可自定义在上方和下方了 ，这种方式是为了确定在某个位置，某个控件的左边，右边，上边，下边都可以
        //因为ppw提供了在某个控件下方的方法，所以有些时候需要直接定位在下方时并不用上面的这个方法
        // TODO: 2018/11/15 0015  距离右边位置  后面再优化
        popupWindow.showAsDropDown(rightIv, -360, 0);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void dinsmid(MessageEvent mess) {
        if (mess.getName().equals("popupWindow")) {
            Log.d("MainActivity", "----------dinsmid: ");
            popupWindow.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
