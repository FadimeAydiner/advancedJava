package com.enums;
//declaring varibles using enum
public enum TransactionType {
    DEPOSIT(4),
    WITDRAW(5),
    TRANSFER(6),
    PAYMENT(3),
    OTHER(9);
    private final int trasactionCode;

    public int getTrasactionCode(){
        return trasactionCode;
    }
    private TransactionType(int trasactionCode) {
        this.trasactionCode = trasactionCode;
    }
}
