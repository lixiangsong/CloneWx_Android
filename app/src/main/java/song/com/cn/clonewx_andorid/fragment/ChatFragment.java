package song.com.cn.clonewx_andorid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.adapter.ChatAdapter;
import song.com.cn.clonewx_andorid.bean.ChatBean;
import song.com.cn.clonewx_andorid.utils.DateUtil;

/**
 * @author: LXS
 * @Time: 2018/11/13 0013
 * @Explain: 聊天
 */

public class ChatFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    private ChatAdapter chatAdapter;
    private List<ChatBean> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_chat, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        chatAdapter = new ChatAdapter(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(chatAdapter);
        initDate();
    }

    private void initDate() {
        list.add(new ChatBean("小六子", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis()), "在吗?"));
        list.add(new ChatBean("张三", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 100), "你好，老刘子"));
        list.add(new ChatBean("订阅号", R.mipmap.dingyue, DateUtil.stampToDate(System.currentTimeMillis() - 1200), "CSDN:科技创新"));
        list.add(new ChatBean("张三", R.mipmap.aaaaa, DateUtil.stampToDate(System.currentTimeMillis() - 400), "哈喽"));
        list.add(new ChatBean("花和尚", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis() - 50), "在吗?"));
        list.add(new ChatBean("小美", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 700), "你好，老刘子"));
        list.add(new ChatBean("帅哥哥", R.mipmap.aaaaa, DateUtil.stampToDate(System.currentTimeMillis() - 10), "哈喽"));
        list.add(new ChatBean("黑猫警长", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis() - 2000), "在吗?"));
        list.add(new ChatBean("土豪", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 2300), "你好，老刘子"));
        list.add(new ChatBean("奥特曼", R.mipmap.aaaaa, DateUtil.stampToDate(System.currentTimeMillis() - 323222), "哈喽"));
        list.add(new ChatBean("神器", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis() - 3421200), "在吗?"));
        list.add(new ChatBean("张三", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 6124562), "你好，老刘子"));
        list.add(new ChatBean("小美", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 700), "你好，老刘子"));
        list.add(new ChatBean("帅哥哥", R.mipmap.aaaaa, DateUtil.stampToDate(System.currentTimeMillis() - 10), "哈喽"));
        list.add(new ChatBean("黑猫警长", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis() - 2000), "在吗?"));
        list.add(new ChatBean("土豪", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 2300), "你好，老刘子"));
        list.add(new ChatBean("奥特曼", R.mipmap.aaaaa, DateUtil.stampToDate(System.currentTimeMillis() - 3222), "哈喽"));
        list.add(new ChatBean("神器", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis() - 555421200), "在吗?"));
        list.add(new ChatBean("张三", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 4562), "你好，老刘子"));
        list.add(new ChatBean("张三", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 6124562), "你好，老刘子"));
        list.add(new ChatBean("小美", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 700), "你好，老刘子"));
        list.add(new ChatBean("帅哥哥", R.mipmap.aaaaa, DateUtil.stampToDate(System.currentTimeMillis() - 10), "哈喽"));
        list.add(new ChatBean("黑猫警长", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis() - 2000), "在吗?"));
        list.add(new ChatBean("土豪", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 2300), "你好，老刘子"));
        list.add(new ChatBean("奥特曼", R.mipmap.aaaaa, DateUtil.stampToDate(System.currentTimeMillis() - 3222), "哈喽"));
        list.add(new ChatBean("神器", R.mipmap.dmsi, DateUtil.stampToDate(System.currentTimeMillis() - 555421200), "在吗?"));
        list.add(new ChatBean("张三", R.mipmap.axm, DateUtil.stampToDate(System.currentTimeMillis() - 4562), "你好，老刘子"));
        chatAdapter.setNewData(list);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
