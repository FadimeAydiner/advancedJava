package com.generics.bounding;

import com.generics.genericMethod.GenericMethodDemo;

public class GenericUpperBounding <T extends Number>{
//setting boundry from upper-->It is now subclass of Number

    private T[] numberArray;

    public GenericUpperBounding(T[] numberArray) {
        this.numberArray = numberArray;
    }
    //method to find avarage of array of numbers
    public double getAvarage(){
        double sum=0;
        for(T t:numberArray)
        {
            sum+=t.doubleValue();//converts elements to double data type

        }
        double avg=sum/numberArray.length;
        return avg;
    }

    public static void main(String[] args) {
        Integer[] intArr={2,4,5,68,8};
        GenericUpperBounding<Integer> obj1=new GenericUpperBounding<>(intArr);

        System.out.println(obj1.getAvarage());
        Double[] doubArr={6.7,8.9,3.5};
        GenericUpperBounding<Double> obj2=new GenericUpperBounding<>(doubArr);
        System.out.println(obj2.getAvarage());

        //bu sınıf içinde sadece Number sınıfı içinde olanlar çalışır

    }
}
