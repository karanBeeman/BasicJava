package com.java.basics;

import java.util.ArrayList;
import java.util.List;

/* Wrapper class mainly used for autoboxing and autounboxing
       mainly works with collection framework, because collection
       framework only works with classes
 */
public class WrapperClass {

    public static int intValue = 10;


    public static void main(String[] args) {

        // boxing in 1.1 versions
        Integer boxing = new Integer(intValue);
        System.out.println("boxing : " +boxing);

        //Autoboxing later versions
        Integer autoBoxing = intValue;
        System.out.println("Autobxing : " +autoBoxing);

        //unboxing in 1.1 version
        int unboxing = autoBoxing.intValue();
        System.out.println("unboxing : " +unboxing);

        //AutoUnboxing later versions
        int autoUnboxing = autoBoxing;
        System.out.println("autoUnboxing : " + autoUnboxing);

        List<Integer> framework = new ArrayList<Integer>();
        framework.add(1); //autoboxing int value 1 with Integer class
        framework.add(2);

        System.out.println("collection framework" +framework);
    }

}