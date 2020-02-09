package com.im.test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputStream {

    public static void main(String []args){
        try {
            FileInputStream fin = new FileInputStream("D:\\222.png");
            FileOutputStream fout = new FileOutputStream("D:\\111.png");
            int len=0;
            byte[] buff = new byte[1024];
            while ((len=fin.read(buff))!=-1){
                fout.write(buff,0,len);
            }
            fin.close();
            fout.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
