package com.enums;

public class EnumTest {
    public static void main(String[] args) {
        benefitOfEnum();
    }

    //method to see benefits of enum
    public static void benefitOfEnum(){
        System.out.println("--------constantMethod-------");
        constantMethod(1);
        constantMethod(2);
        constantMethod(3);
        constantMethod(4);
        constantMethod(188);//it is not complining but it is doing unnessary task

        System.out.println("--------enumMethod-------");
        enumMethod(TransactionType.DEPOSIT);
        enumMethod(TransactionType.WITDRAW);
        enumMethod(TransactionType.PAYMENT);
        enumMethod(TransactionType.TRANSFER);
        enumMethod(TransactionType.OTHER);
       // enumMethod(TransactionType.DENEME);COMPİLE time error verir. enum da tanımsız bir şey çağıramayız


        //enum methods
        System.out.println("--------enum methods-------");
        System.out.println(TransactionType.values()[3]);
        //values() gives all values in array format

        for(TransactionType tt:TransactionType.values())
        {   System.out.println(tt.name().toString());
            System.out.println(tt.ordinal());//will give index/ordinal of constant
        }
    }

    //two methods to see why we need enums
    private static void constantMethod(int i){
        if(i==TransctionTypeConstant.DEPOSIT)
            System.out.println("Money is depositing..");
        else if(i==TransctionTypeConstant.WITDRAW)
            System.out.println("Money is witdrawing..");
        else if(i==TransctionTypeConstant.TRANSFER)
            System.out.println("Money is transfering..");
        else if(i==TransctionTypeConstant.PAYMENT)
            System.out.println("Money is paid..");
        else if(i==TransctionTypeConstant.OTHER)
            System.out.println("Some other transaction..");
    }

    //method for enum
    private static void enumMethod(TransactionType tt){
        if(tt==TransactionType.DEPOSIT)
            System.out.println("Money is depositing..");
        else if(tt==TransactionType.WITDRAW)
            System.out.println("Money is witdrawing..");
        else if(tt==TransactionType.TRANSFER)
            System.out.println("Money is transfering..");
        else if(tt==TransactionType.PAYMENT)
            System.out.println("Money is paid..");
        else if(tt==TransactionType.OTHER)
            System.out.println("Some other transaction..");

        switch(tt){
            case DEPOSIT -> System.out.println("Money is depositing..");
            case WITDRAW ->  System.out.println("Money is witdrawing..");
            case PAYMENT ->   System.out.println("Money is paid..");
            case TRANSFER ->  System.out.println("Money is transfering..");
            case OTHER ->  System.out.println("Some other transaction..");
        }


}}
