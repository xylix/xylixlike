/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xylixlike.game;

import java.util.Scanner;

/**
 *
 * @author xylix
 */
public class Game {
    public Game() {

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int width = 40;
        int height = 20;
        Level level = new Level(width, height);
        System.out.println(level.currentState());
    }
    
}
