package song.com.cn.clonewx_andorid.bean;

/**
 * @author: LXS
 * @Time: 2018/11/14 0014
 * @Explain: 聊天界面
 */
public class ChatBean {
    private String name;
    private int id;
    private int photo;
    private String time;
    private String content;

    public ChatBean() {
    }

    public ChatBean(String name, int photo, String time, String content) {
        this.name = name;
        this.photo = photo;
        this.time = time;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
