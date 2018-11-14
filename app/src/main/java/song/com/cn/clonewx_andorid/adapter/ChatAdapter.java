package song.com.cn.clonewx_andorid.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.bean.ChatBean;

/**
 * @author: LXS
 * @Time: 2018/11/14 0014
 * @Explain: 聊天列表项
 */

public class ChatAdapter extends BaseQuickAdapter<ChatBean, BaseViewHolder> {

    public ChatAdapter(List<ChatBean> data) {
        super(R.layout.item_chat_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatBean item) {
        helper.setText(R.id.name_tv,item.getName());
        helper.setText(R.id.conten_tv,item.getContent());
        helper.setText(R.id.time,item.getTime());
        ImageView image=helper.getView(R.id.title_iv);
        image.setBackgroundResource(item.getPhoto());
    }
}
