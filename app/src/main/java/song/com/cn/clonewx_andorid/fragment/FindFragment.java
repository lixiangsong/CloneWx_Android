package song.com.cn.clonewx_andorid.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import song.com.cn.clonewx_andorid.google.zxing.activity.CaptureActivity;
import song.com.cn.clonewx_andorid.google.zxing.view.Constant;
import song.com.cn.clonewx_andorid.utils.ToastUtils;

import static android.app.Activity.RESULT_OK;

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
                Intent intent2 = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent2, Constant.REQ_QR_CODE);
                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN);
            //将扫描出的信息显示出来
            ToastUtils.showToast("扫描结果 " + scanResult, getActivity());
            Log.d("FindFragment", "----------onActivityResult: " + scanResult);
        }
    }
}
