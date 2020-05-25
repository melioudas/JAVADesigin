package prototype;

import java.util.Date;

/**
 * 以视频拷贝为例
 * <p>
 * 1.实现cloneable接口
 * 2.重写clone方法
 */
public class Video implements Cloneable {
    //视频名称
    private String name;

    //视频日期
    private Date createDate;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Video() {

    }

    public Video(String name, Date createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
