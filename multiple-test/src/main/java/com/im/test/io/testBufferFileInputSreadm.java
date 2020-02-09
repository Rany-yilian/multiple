package com.im.test.io;

import java.io.*;

public class testBufferFileInputSreadm {

    public static void main(String[] args){
        try {
            BufferedInputStream bfin = new BufferedInputStream(new FileInputStream("D:\\111.png"));
            BufferedOutputStream bfout = new BufferedOutputStream(new FileOutputStream("D:\\333.png"));
            int len =0;
            byte[] buf = new byte[1024];
            while ((len=bfin.read(buf))!=-1){
                bfout.write(buf,0,len);
            }
            bfin.close();
            bfout.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
