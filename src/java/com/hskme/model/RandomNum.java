/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hskme.model;

import java.util.Random;
/**
 *
 * @author root
 */

public class RandomNum {
    private int random;
    
    public int getNextInt() {
        do{
            random = new Random().nextInt(6);
        } while(random == 0);
        return random;
    }
}