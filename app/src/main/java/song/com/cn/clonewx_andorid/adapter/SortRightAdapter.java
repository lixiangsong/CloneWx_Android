package song.com.cn.clonewx_andorid.adapter;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import song.com.cn.clonewx_andorid.R;
import song.com.cn.clonewx_andorid.bean.SortModel;

/**
 * @author: LXS
 * @Time: 2018/11/13 0013
 * @Explain:
 */
public class SortRightAdapter extends BaseQuickAdapter<SortModel, BaseViewHolder> {
    public SortRightAdapter(List<SortModel> data) {
        super(R.layout.item_name, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final SortModel item) {
        TextView tvName = helper.getView(R.id.tvName);
        tvName.setText(item.getName());

        helper.getView(R.id.item_ly).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < getItemCount(); i++) {
            String sortStr = mData.get(i).getLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}
