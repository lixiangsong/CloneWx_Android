package song.com.cn.clonewx_andorid.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import de.greenrobot.event.EventBus;
import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.bean.MessageEvent;
import song.com.cn.clonewx_andorid.bean.PopupBean;
import song.com.cn.clonewx_andorid.utils.ToastUtils;

/**
 * Created by Administrator on 2018/11/15 0015.
 */

public class PopupWindowAdapter extends BaseQuickAdapter<PopupBean, BaseViewHolder> {
    public PopupWindowAdapter(List<PopupBean> data) {
        super(R.layout.view_long_onclick_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final PopupBean item) {
        //赋值，没什么好备注的
        helper.setText(R.id.name_tv, item.getName());
        ImageView imageView = helper.getView(R.id.image);
        imageView.setBackgroundResource(item.getImage());
        helper.getView(R.id.popup_ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast(item.getName(), mContext);
                EventBus.getDefault().post(new MessageEvent("popupWindow"));
            }
        });
    }
}
