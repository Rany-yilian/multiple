package com.im.test.func;

public class Student {
    private String name;
    private String sex;
    private int age;

    public Student(String name,String sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Student[sex="+sex+",name="+name+",age="+age+"]";
    }
}
