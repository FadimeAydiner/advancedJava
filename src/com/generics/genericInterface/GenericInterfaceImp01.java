package com.generics.genericInterface;

//if we implement a GenericInterface our class must be Generic too
public class GenericInterfaceImp01<T> implements GenericInterface<T>{
    @Override
    public void setValue(T t) {

    }

    @Override
    public T getValue() {
        return null;
    }
}
