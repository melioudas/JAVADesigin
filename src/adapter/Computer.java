package adapter;

import java.awt.event.WindowAdapter;
import java.io.*;

/**
 * 电脑  网线是usb接口的，插不上网线
 *
 * 实际运用举例：
 * 1.FileInputStream 字节流想一行行的读出字符流
 * 借助InputStreamReader 来完成适配 通过BufferReader来读取
 *
 * 2.连接SQLSERVER JDBC转成ODBC
 */
public class Computer {
      public void net(NetToUsb netToUsb){
          //上网的实现
          netToUsb.handleRquest();
      }

    public static void main(String[] args) {
          //电脑 ，网线 ，适配器
        Computer computer=new Computer();
        WangXian wangXian=new WangXian();
        Adapter adapter=new Adapter(wangXian);
        computer.net(adapter);
    }
}

