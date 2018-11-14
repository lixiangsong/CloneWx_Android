package song.com.cn.clonewx_andorid.bean;

public class SortModel {
    public SortModel() {
    }

    public SortModel(String name, String letters) {
        this.name = name;
        this.letters = letters;
    }

    private String name;
    private String letters;//显示拼音的首字母

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }
}
