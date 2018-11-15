package song.com.cn.clonewx_andorid.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.bean.ChatBean;
import song.com.cn.clonewx_andorid.widger.PopupWindowList;

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
    protected void convert(final BaseViewHolder helper, ChatBean item) {
        helper.setText(R.id.name_tv, item.getName());
        helper.setText(R.id.conten_tv, item.getContent());
        helper.setText(R.id.time, item.getTime());
        ImageView image = helper.getView(R.id.title_iv);
        image.setBackgroundResource(item.getPhoto());

        helper.getView(R.id.rl_onclick).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showPopWindows(v);
                return false;
            }
        });
    }

    private PopupWindowList mPopupWindowList;

    private void showPopWindows(View view) {
        final List<String> dataList = new ArrayList<>();
        dataList.add("标为未读");
        dataList.add("置顶聊天");
        dataList.add("删除该聊天");
        if (mPopupWindowList == null) {
            mPopupWindowList = new PopupWindowList(view.getContext());
        }
        mPopupWindowList.setAnchorView(view);
        mPopupWindowList.setItemData(dataList);
        mPopupWindowList.setModal(true);
        mPopupWindowList.show();
        mPopupWindowList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, dataList.get(position) + "", Toast.LENGTH_SHORT).show();
                mPopupWindowList.hide();
            }
        });
    }
}
