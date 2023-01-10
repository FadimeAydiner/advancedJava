package com.generics.genericMethod;

public class GenericMethodDemo {
    public static void main(String[] args) {
        GenericMethodDemo obj1=new GenericMethodDemo();
        Integer[] intArr={2,5,7,99,4};
        Double[] doubArr={6.7,8.9,3.5};

        obj1.print(intArr);
        obj1.print(doubArr);


    }

    public <T> void print(T[] arr){
        for(T t:arr)
            System.out.println(t);
    }
}
