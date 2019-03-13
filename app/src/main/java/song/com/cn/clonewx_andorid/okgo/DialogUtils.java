package song.com.cn.clonewx_andorid.okgo;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import song.com.cn.clonewx_andorid.R;

/**
 * @author lxs
 * @Description:
 * @data 2019/3/13 0013 下午 6:12
 */
public class DialogUtils extends Dialog {
//    /**
//     * 弹框在屏幕中间
//     *
//     * @param context
//     * @param layout
//     * @param style
//     */
//    public DialogUtils(Context context, View layout, int style, boolean isBottom) {
//        super(context, style);
//        setContentView(layout);
//        Window window = getWindow();
//
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        if (isBottom) {
//            window.setWindowAnimations(R.style.anim_menu_bottom);
//            params.width = WindowManager.LayoutParams.MATCH_PARENT;
//            params.gravity = Gravity.BOTTOM; // 紧贴底部
//        } else {
//            params.gravity = Gravity.CENTER;
//        }
//        setCanceledOnTouchOutside(false);
//        //设置点击返回键不消失
//        setCancelable(false);
//        window.setAttributes(params);
//    }

    public DialogUtils(Context context) {
        super(context, R.style.DialogTheme);
        View layoutView = getLayoutInflater().inflate(R.layout.network_dialog_layout, null);
        setContentView(layoutView);
        Window window = getWindow();

        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.CENTER;
        setCanceledOnTouchOutside(false);
        window.setAttributes(params);
        setCancelable(false);
    }

//    /**
//     * 通用弹出框
//     *
//     * @param context
//     * @param gravitys
//     */
//    public DialogUtils(Context context, View layout, int gravitys) {
//        super(context, R.style.DialogTheme);
//
//        setContentView(layout);
//        Window window = getWindow();
//
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.gravity = gravitys;
//        setCanceledOnTouchOutside(false);
//        window.setAttributes(params);
//        setCancelable(false);
//    }
}
