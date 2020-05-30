package prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * 原型模式（浅克隆）
 */
public class Sheep implements Cloneable, Serializable {//1997,英国的克隆羊，多利！
    private String sname;
    private Date birthday;

    public Sheep() {
    }

    public Sheep(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = super.clone();//直接调用Object对象的clone()方法！
        return object;

    }
}
