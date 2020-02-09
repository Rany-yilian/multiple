package com.im.test.io;

import java.io.*;

public class testPrintWriter {

    public static void main(String[] args){
        /*try {
            PrintWriter pw = new PrintWriter(new FileWriter("D:\\user.txt"),true);
            pw.write("测试打印流");
            pw.println("此句之后换行");
            pw.println("特有功能：自动换行和自动刷新");
            pw.println("利用构造器设置自动刷新");
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/
        //使用打印流复制文本文件
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\user.txt"));
            PrintWriter pw = new PrintWriter("D:\\printcopy.txt");
            String line;
            while ((line=br.readLine())!=null){
                pw.println(line);
            }
            br.close();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
