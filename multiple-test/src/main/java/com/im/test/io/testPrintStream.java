package com.im.test.io;

import java.io.*;

public class testPrintStream {

    public static void main(String[]args){
        try {
            /*BufferedReader br = new BufferedReader(new FileReader("D:\\user.txt"));
            PrintStream ps = new PrintStream("D:\\printcopy2.txt");
            String line;
            while ((line=br.readLine())!=null){
                ps.println(line);
            }
            br.close();
            ps.close();*/
            PrintStream p=new PrintStream(new FileOutputStream(new File("D:\\hello.txt")));
            String str="hello world";
            int i=5;
            double d=7.9;
            p.println(str);
            p.println(i);
            p.println(d);
            p.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
