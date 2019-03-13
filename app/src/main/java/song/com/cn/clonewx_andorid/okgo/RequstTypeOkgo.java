package song.com.cn.clonewx_andorid.okgo;

import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

/**
 * @author lxs
 * @Description:
 * @data 2019/1/5 0005
 */
public class RequstTypeOkgo {

    /**
     * 带缓存
     * 先使用缓存，不管存不存在，都请求网络
     *
     * @param context
     * @param url
     * @param httpParams
     */
    public static <T extends MessageInfo> void post(final Context context, String url, HttpParams httpParams, String cacheTag, final Class<T> clazz, final IRequestData<T> iRequestData) {
        OkGo.<T>post(url).tag(context).params(httpParams).cacheKey(cacheTag).cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST).execute(new JsonCallback<T>(clazz, context) {
            @Override
            public void onSuccess(Response<T> response) {
                T cls = response.body();
                if (cls.getCode() == 0) {
                    iRequestData.onSuccess(cls);
                } else if (cls.getCode() == 1009) {
                    //清空token
                }
            }

            @Override
            public void onCacheSuccess(Response<T> response) {
                super.onCacheSuccess(response);
                T cls = response.body();
                if (cls.getCode() == 0) {
                    iRequestData.onCacheSuccess(cls);
                }
            }

            @Override
            public void onError(Response<T> response) {
                super.onError(response);
            }
        });
    }

    /**
     * 不带缓存
     *
     * @param context
     * @param url
     * @param httpParams
     * @param tClass
     * @param iRequestData
     * @param <T>
     */
    public static <T extends MessageInfo> void postBeanNoCache(final Context context, String url, HttpParams httpParams, final Class<T> tClass, final IRequestDataNoCache<T> iRequestData) {
        OkGo.<T>post(url).tag(context).params(httpParams).execute(new JsonCallback<T>(tClass, context) {
            @Override
            public void onSuccess(Response<T> response) {
                T cls = response.body();
                if (cls.getCode() == 0) {
                    iRequestData.onSuccess(cls);
                } else if (cls.getCode() == 1009) {
                    //清空token
                }
            }

            @Override
            public void onError(Response<T> response) {
                super.onError(response);
            }
        });
    }


}
