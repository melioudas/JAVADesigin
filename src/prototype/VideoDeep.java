package prototype;

import java.util.Date;

/**
 * 深拷贝实验
 * <p>
 * 1.实现cloneable接口
 * 2.重写clone方法
 * 3.将属性中的值写到clone方法中
 */
public class VideoDeep implements Cloneable {
    //视频名称
    private String name;

    //视频日期
    private Date createDate;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        VideoDeep v = (VideoDeep) obj;
        v.setCreateDate((Date) this.createDate.clone());
        return obj;
    }

    public VideoDeep() {

    }

    public VideoDeep(String name, Date createDate) {
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
        return "VideoDeep{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
