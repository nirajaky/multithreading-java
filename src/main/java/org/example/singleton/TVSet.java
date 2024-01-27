package org.example.singleton;

public class TVSet {
    private static volatile TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("TV Set Instance created");
    }

    public static TVSet getTvSetInstance() {
        if (tvSetInstance == null) {
            synchronized (TVSet.class) {
                if (tvSetInstance == null) {
                    tvSetInstance = new TVSet();
                }
            }
        }
        return tvSetInstance;
    }
}
