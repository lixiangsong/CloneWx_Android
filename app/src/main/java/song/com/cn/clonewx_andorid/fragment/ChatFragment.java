package song.com.cn.clonewx_andorid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import song.com.cn.clonewx_andorid.R;

/**
 * @author: LXS
 * @Time: 2018/11/13 0013
 * @Explain: 聊天
 */

public class ChatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_chat, container, false);
        return view;
    }
}
