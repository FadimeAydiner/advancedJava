package com.generics.bounding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GenericLowerBoundingAndWildCard {
    public static void main(String[] args) {
        List<Object> ol=new ArrayList<>();
        addElement(ol);
        List<Number> nl=new ArrayList<>();
        addElement(nl);

        List<Double> dl=new ArrayList<>();
        //addElement(dl); doble is not parent of Integer so its compilining
        //------printElement()-----
        List<String> stringList=new ArrayList<>();
        printElement(stringList);

        //------printObject()-----
        List<String> stringList1=new ArrayList<>();
       // printObject(stringList1); String olmasına rağmen object kabul ettiği için metod bunu kabul etmiyor
    }

    //super Integer-->It brings parent classes of Integer
    public static void addElement(List<? super Integer> list){
        //?-->Wildcard

        for(int i=1;i<=10;i++){
            list.add(i);
        }
    }
    //limition of wildcard
    public static void  printElement(List<?> listUnknown){
       // listUnknown.add("Java"); its complining because of ? (unknown data type),add method not accept
        //first we need to declare data type
        //listUnknown.add(null); null value will work

        for(Object i:listUnknown)
            System.out.println(i);


    }
    public static void printObject(List<Object> objectList ){

        for (Object o:objectList)
            System.out.println(o);
    }
}
