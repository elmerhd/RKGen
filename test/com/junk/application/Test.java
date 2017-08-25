package com.junk.application;

/**
 *
 * @author Elmerhd
 */
public class Test {
    public static void main(String[] args) {
        RandomKeyGenerator charGen = new RandomKeyGenerator();
        System.out.println(charGen.generateByPattern("[:intercom-:i-iiiii-XXXXX]"));
    }
}
