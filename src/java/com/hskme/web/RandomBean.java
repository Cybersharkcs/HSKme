/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hskme.web;

import java.util.Random;
/**
 *
 * @author root
 */

public class RandomBean {
    private static final Random RANDOM = new Random();

    public int getNextInt() {
        int random;
        do{
            random = RANDOM.nextInt(6);
        } while(random == 0);
        return random;
    }
}