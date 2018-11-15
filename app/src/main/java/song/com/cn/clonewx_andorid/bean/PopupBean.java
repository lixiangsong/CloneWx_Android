package song.com.cn.clonewx_andorid.bean;

/**
 * Created by Administrator on 2018/11/15 0015.
 */

public class PopupBean {
    private int image;
    private String name;

    public PopupBean() {
    }

    public PopupBean(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
