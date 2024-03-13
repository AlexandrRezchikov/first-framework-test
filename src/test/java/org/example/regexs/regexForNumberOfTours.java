package org.example.regexs;

public class regexForNumberOfTours {

    public static int regexForNumberOfTours(String count) {

        return Integer.parseInt(count.replaceAll("\\D", ""));
    }
}
