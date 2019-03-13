package song.com.cn.clonewx_andorid.okgo;

public interface IRequestData<T extends MessageInfo> {
    void onSuccess(T data);

    void onError(String err);

    void onCacheSuccess(T cachData);
}
