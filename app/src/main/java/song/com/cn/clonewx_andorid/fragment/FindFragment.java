package song.com.cn.clonewx_andorid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.friend.FriendActivity;

/**
 * @author: LXS
 * @Time: 2018/11/13 0013
 * @Explain: 发现
 */

public class FindFragment extends Fragment {
    @BindView(R.id.friend_rl)
    RelativeLayout friendRl;
    @BindView(R.id.sao_yi_sao)
    LinearLayout saoYiSao;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.friend_rl, R.id.sao_yi_sao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.friend_rl:
                Intent intent = new Intent(getActivity(), FriendActivity.class);
                startActivity(intent);
                break;
            case R.id.sao_yi_sao:
                break;
        }
    }
}
