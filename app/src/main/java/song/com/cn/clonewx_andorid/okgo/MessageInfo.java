package song.com.cn.clonewx_andorid.okgo;

import java.io.Serializable;

public class MessageInfo implements Serializable {
    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
