package song.com.cn.clonewx_andorid.okgo;

public interface IRequestDataNoCache<T extends MessageInfo> {
    void onSuccess(T data);

    void onError(String err);

}
