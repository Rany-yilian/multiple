package com.im.test.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMerge {

    //按照男女分组，把年龄汇总
    /*public static void main(String[] args){
        //按照男女分组，把年龄汇总
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三","男",18));
        students.add(new Student("李四","男",19));
        students.add(new Student("花花","女",18));
        students.add(new Student("小红","女",45));

        Map<String,Integer> resultMap = new HashMap<>();
        //第一种方式
        /*for (Student student:students){
            Integer age = resultMap.get(student.getSex());
            if(age!=null){
                resultMap.put(student.getSex(),student.getAge()+age);
            }else{
                resultMap.put(student.getSex(),student.getAge());
            }
        }
        //第二种方式
        for (Student student:students){
            resultMap.merge(student.getSex(),student.getAge(),(a,b)->a+b);
        }
        printResult(resultMap);
    }*/

    public static void main(String[] args){
        //按照男女分组
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三","男",18));
        students.add(new Student("李四","男",20));
        students.add(new Student("韩梅梅","女",18));
        students.add(new Student("小红","女",45));

        //声明接收结果的 map
        Map<String, List<Student>> resultMap = new HashMap<>();
        //第一种方式
        /*for (Student student : students) {
            List<Student> s = resultMap.get(student.getSex());
            if(null == s){
                s = new ArrayList<>();
                resultMap.put(student.getSex(),s);
            }
            s.add(student);
        }*/
        //第二种方式
        for (Student student:students){
            List<Student> s = resultMap.computeIfAbsent(student.getSex(),k->new ArrayList<>());
            s.add(student);
        }
        System.out.println(resultMap);
    }

    private static void printResult(Map<String,Integer> map){
        for (Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println("key:"+e.getKey()+" value:"+e.getValue());
        }
    }
}
