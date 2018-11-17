package song.com.cn.clonewx_andorid.friend;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.bean.ChatBean;

/**
 * @author: LXS
 * @Time: 2018/11/16 0016
 * @Explain: 朋友圈列表
 */
public class FriendAdapter extends BaseQuickAdapter<ChatBean, BaseViewHolder> {
    public FriendAdapter(List<ChatBean> data) {
        super(R.layout.item_friend, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatBean item) {

    }
}
