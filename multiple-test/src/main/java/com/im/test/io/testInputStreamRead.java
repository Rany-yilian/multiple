package com.im.test.io;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class testInputStreamRead {

    public static void main(String[] args){
        try {
            //创建输入流对象
            BufferedReader r= new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("D:\\ccc.txt");
            char []chs = new char[1024];
            int len;
            while ((len=r.read(chs))!=-1){
                fw.write(chs,0,len);
                fw.flush();
            }
            r.close();
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
