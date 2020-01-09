package com.im.test.func;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

public class TestForEach {

    @Test
    public void test(){
        System.out.println("--------lamuda and list-----------------");
        List<String> list = Arrays.asList("aaaa","bbbb");

        //for循环
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        for (String str:list){
            System.out.println(str);
        }

        //迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("--------lamuda print list----------------");
        list.forEach(item->System.out.println(item));
        list.forEach(item->{
            if("aaaa".equals(item)){
                System.out.println("hello:"+item);
            }
        });
        list.forEach(System.out::println);
        System.out.println("----------stream--------------------------");
        list.stream().filter(s->s.contains("bbbb")).forEach(System.out::println);
        System.out.println("----------lamuda and map-----------------");

        Map<String,Integer> items = new HashMap<>();
        items.put("A",10);
        items.put("B",20);
        items.put("C",30);

        for (Map.Entry<String,Integer> entry:items.entrySet()){
            System.out.println("item:"+entry.getKey()+" count:"+entry.getValue());
        }
        System.out.println("-------lamuda---------");
        items.forEach((k,v)->System.out.println("item:"+k+" count:"+v));

        items.forEach((k,v)->{
            System.out.println("item:"+k+" count:"+v);
            if("C".equals(k)){
                System.out.println("hello C");
            }
        });


    }
}
