package com.generics;

public class GenericTypeWithTwoParameters<S,U> {
private S s;
private U u;

    public GenericTypeWithTwoParameters(S s, U u) {
        this.s = s;
        this.u = u;
    }

    public S getS() {
        return s;
    }

    public void setS(S s) {
        this.s = s;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public static void main(String[] args) {
        GenericTypeWithTwoParameters<String,Integer> obj1=new GenericTypeWithTwoParameters<>("12",12);
        GenericTypeWithTwoParameters<Integer,String> obj2=new GenericTypeWithTwoParameters<>(12,"ss12");
        System.out.println(obj1.getS());
        System.out.println(obj2.getS());
    }
}
