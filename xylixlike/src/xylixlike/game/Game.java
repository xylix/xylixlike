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
    int height = 40;
    int width = 80;
    public Game() {

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); 
        int height = 80;
        int width = 40;
        Level level = new Level(height, width);
        System.out.println(level.currentState());
    }
    
}
