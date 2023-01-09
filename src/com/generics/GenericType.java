package com.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//T-->Type
//N-->Numbers
//K-->Key
//V-->Value
public class GenericType<T> {
    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public static void main(String[] args) {
        //using generics 2 differnt data object
        GenericType<String> obj=new GenericType<>();
        obj.setType("Hello Generics");
        //obj.setType(34); we can set only String value here because of GenericType<String>

        GenericType<Integer> obj2=new GenericType<>();
        obj2.setType(65);

        List<String> stringList=new ArrayList<>();
        //stringList.add(34); ClassCastException verir
        stringList.add("ss");

        Map<Integer,String> map=new HashMap<>();
       // map.put("12",32);ClassCastException verir
        map.put(2,"ll");

    }
}
