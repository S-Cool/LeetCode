package com.interview.mape;

public class AB implements A, B {

    public static void main(String[] args) {
        A ab = new AB();
        ab.print();
    }

    @Override
    public void print() {
        A.super.print();
        B.super.print();
    }
}
