package com.im.test.io;

import java.io.*;

public class testReadWriter {

    public static void main(String[] args) {
        try {
            //创建输入流对象
            FileReader fr = new FileReader("D:\\user.txt");
            //创建输出流对象
            FileWriter fw = new FileWriter("D:\\test.txt");
            //文本文件复制，一次读一个字符
            //cp(fr,fw);
            cp2(fr, fw);
            fr.close();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cp2(FileReader fr, FileWriter fw) {
        char chs[] = new char[1024];
        int len = 0;
        try{
            while ((len=fr.read(chs))!=-1){
                fw.write(chs,0,len);
            }
            fw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void cp(FileReader fr, FileWriter fw) {
        int ch;
        try {
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
