package com.im.test.func;

import java.util.function.Supplier;

public class TestSupplier {

    private int age;

    TestSupplier() {
        System.out.println("---初始化---");
    }

    public static void main(String[] args) {
        Supplier<TestSupplier> testSupplierSupplier = TestSupplier::new;
        System.out.println("-----------");
        testSupplierSupplier.get();
        testSupplierSupplier.get();
    }
}
