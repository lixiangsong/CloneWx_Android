package song.com.cn.clonewx_andorid.okgo;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author lxs
 * @Description:
 * @data 2019/3/13 0013 下午 6:10
 */
public abstract class JsonCallback<T> extends AbsCallback<T> {
    private Type type;
    private Class<T> clazz;
    private DialogUtils dialog;
    private boolean noDialog;

    public JsonCallback(Type type, Context context) {
        this.type = type;
    }

    public JsonCallback(Class<T> clazz, Context context) {
        this.clazz = clazz;
        dialog = new DialogUtils(context);
    }

    public JsonCallback(Class<T> clazz, Context context, boolean noDialog) {
        this.clazz = clazz;
        this.noDialog = noDialog;
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        super.onStart(request);
        if (!noDialog && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onError(com.lzy.okgo.model.Response<T> response) {
        super.onError(response);
        if (!noDialog && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onFinish() {
        super.onFinish();
        if (!noDialog && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public T convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        T data = null;
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(body.charStream());
        if (type != null) data = gson.fromJson(jsonReader, type);
        if (clazz != null) data = gson.fromJson(jsonReader, clazz);
        return data;
    }
}
