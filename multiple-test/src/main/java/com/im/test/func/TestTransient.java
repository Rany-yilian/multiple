package com.im.test.func;

import org.junit.Test;

import java.io.*;

public class TestTransient {

    @Test
    public void test(){
        User user = new User();
        user.setUsername("yilia");
        user.setPasswd("123456");

        System.out.println("read before serializable:");
        System.out.println("username:"+user.getUsername());
        System.out.println("passowrd:"+user.getPasswd());

        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/user.txt"));
            user = (User) is.readObject();
            is.close();
            System.out.println("\n after serializable");
            System.out.println("username:"+user.getUsername());
            System.out.println("pwd:"+user.getPasswd());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}

class User implements Serializable {

    private static final long serialVersionUID = 8294180014912103005L;

    private String username;

    private transient String passwd;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPasswd(){
        return passwd;
    }

    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
}
