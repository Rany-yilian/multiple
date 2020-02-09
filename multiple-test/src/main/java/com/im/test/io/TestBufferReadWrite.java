package com.im.test.io;

import com.typesafe.config.ConfigException;

import java.io.*;

public class TestBufferReadWrite {

    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\user.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\fu.txt"));

            char [] chs = new char[1024];
            int len=0;
            while ((len=br.read(chs))!=-1){
                bw.write(chs,0,len);
            }
            br.close();
            bw.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
