package com.frag.taotie;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
        Map<Number, String> queueMap = new ConcurrentHashMap<>(10);
        queueMap.put(1, "1");
        queueMap.put(2, "2");
        queueMap.put(4, "4");
        queueMap.put(8, "8");
        queueMap.put(16, "16");
        queueMap.put(32, "32");
        queueMap.put(64, "64");
        queueMap.put(128, "128");
        queueMap.put(256, "256");
        queueMap.put(512, "512");
        queueMap.put(1024, "1024");

        System.out.println(queueMap.get(2));
        System.out.println(queueMap.get(4));
        System.out.println(queueMap.get(8));
        System.out.println(queueMap.get(16));
        System.out.println(queueMap.get(32));
        System.out.println(queueMap.get(64));
        System.out.println(queueMap.get(128));
        System.out.println(queueMap.get(256));
        System.out.println(queueMap.get(512));
        System.out.println(queueMap.get(1024));

        System.out.println(1 << 4);
        Byte b = 10;
        System.out.println(b.equals(10));

        System.out.println(1 << 0);

        System.out.println(((Float)(10 * 0.75f)).intValue() + 1);

    }
}
