package song.com.cn.clonewx_andorid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author: LXS
 * @Time: 2018/11/13 0013
 * @Explain:
 */

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public HomeFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
