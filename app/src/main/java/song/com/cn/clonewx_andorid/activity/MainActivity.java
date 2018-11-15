package song.com.cn.clonewx_andorid.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import song.com.cn.clonewx_andorid.BaseActivity;
import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.adapter.HomeFragmentPagerAdapter;
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
        radioGroup.setOnCheckedChangeListener(this);

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
                        Log.d("MainActivity", "----------onPageSelected: " + position);
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
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.chat_rb:
                viewPage.setCurrentItem(0);
                Log.d("MainActivity", "----------onCheckedChanged: " + checkedId);
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
}
