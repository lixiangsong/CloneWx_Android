package song.com.cn.clonewx_andorid.bean;

/**
 * @author: LXS
 * @Time: 2018/11/19 0019
 * @Explain: hashCode() , equals()
 */
public class PersonBean {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonBean that = (PersonBean) o;

        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
