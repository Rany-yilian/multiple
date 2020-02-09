package com.im.test.io;

import java.io.*;

public class testOutputStreamWrite {

    public static void main(String[] args){
        try {
            //创建输入流
            BufferedReader br = new BufferedReader(new FileReader("D:\\user.txt"));

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String line;
            while ((line=br.readLine())!=null){
                bw.write(line);
                bw.write("\r\n");
            }
            br.close();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
