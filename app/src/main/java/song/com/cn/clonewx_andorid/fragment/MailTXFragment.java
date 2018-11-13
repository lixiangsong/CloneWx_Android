package song.com.cn.clonewx_andorid.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.adapter.SortRightAdapter;
import song.com.cn.clonewx_andorid.bean.SortModel;
import song.com.cn.clonewx_andorid.utils.PinyinComparator;
import song.com.cn.clonewx_andorid.utils.PinyinUtils;
import song.com.cn.clonewx_andorid.widger.TitleItemDecoration;
import song.com.cn.clonewx_andorid.widger.WaveSideBar;
import android.support.v7.widget.DividerItemDecoration;
/**
 * @author: LXS
 * @Time: 2018/11/13 0013
 * @Explain: 通讯录
 */

public class MailTXFragment extends Fragment {

    @BindView(R.id.tongx_rc)
    RecyclerView tongxRc;
    @BindView(R.id.wave_side)
    WaveSideBar waveSide;
    Unbinder unbinder;
    private LinearLayoutManager manager;
    /**
     * 根据拼音来排列RecyclerView里面的数据类
     */
    private PinyinComparator mComparator;
    private SortRightAdapter mAdapter;
    private List<SortModel> mDateList;
    private TitleItemDecoration mDecoration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_mail, container, false);
        unbinder = ButterKnife.bind(this, view);
        initVew();
        return view;
    }

    private void initVew() {
        mComparator = new PinyinComparator();
        mDateList = filledData(getResources().getStringArray(R.array.date));

        // 根据a-z进行排序源数据
        Collections.sort(mDateList, mComparator);

        //RecyclerView设置manager
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        tongxRc.setLayoutManager(manager);
        mAdapter = new SortRightAdapter(mDateList);
        tongxRc.setAdapter(mAdapter);
        mDecoration = new TitleItemDecoration(getActivity(), mDateList);
        //如果add两个，那么按照先后顺序，依次渲染。
        tongxRc.addItemDecoration(mDecoration);

        tongxRc.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        //设置右侧SideBar触摸监听
        waveSide.setOnTouchLetterChangeListener(new WaveSideBar.OnTouchLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {
                //该字母首次出现的位置
                int position = mAdapter.getPositionForSection(letter.charAt(0));
                if (position != -1) {
                    manager.scrollToPositionWithOffset(position, 0);
                }
            }
        });

    }

    /**
     * 为RecyclerView填充数据
     *
     * @param date
     * @return
     */
    private List<SortModel> filledData(String[] date) {
        List<SortModel> mSortList = new ArrayList<>();

        for (int i = 0; i < date.length; i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                sortModel.setLetters(sortString.toUpperCase());
            } else {
                sortModel.setLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
