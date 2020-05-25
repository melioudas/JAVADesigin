package prototype;


import java.util.Date;

/**
 * 拷贝视频
 */
public class Bilibili {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        Video v1 = new Video("魔术", date);

        Video v2 = (Video) v1.clone();
        System.out.println("v1 :" + v1.hashCode() + "   " + v1);
        System.out.println("v2 :" + v2.hashCode() + "   " + v2);
        System.out.println("浅拷贝来一把");
        //当前是浅拷贝验证一把  当修改v1引用的date时,v2的date也会随之修改，此乃浅拷贝
        date.setTime(123456789);

        System.out.println("v1 :" + v1.hashCode() + "   " + v1);
        System.out.println("v2 :" + v2.hashCode() + "   " + v2);


        //--------------------VideoDeep--------------------------

        System.out.println("深拷贝来一把");
        Date date1 = new Date();
        VideoDeep vv1 = new VideoDeep("魔术vv1", date1);
        VideoDeep vv2 = (VideoDeep) vv1.clone();

        //当前是浅拷贝验证一把  当修改v1引用的date时,v2的date也会随之修改，此乃浅拷贝
        date1.setTime(123456789);
        System.out.println("vv1 :" + vv1.hashCode() + "   " + vv1);
        System.out.println("vv2 :" + vv2.hashCode() + "   " + vv2);

    }
}
