package song.com.cn.clonewx_andorid.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/11/15 0015.
 */

public class ToastUtils {
    private static Toast toast;

    /**
     * 提示
     *
     * @param msg
     */
    public static void showToast(String msg, Context context) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
