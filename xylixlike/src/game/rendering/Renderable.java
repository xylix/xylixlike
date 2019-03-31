/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.rendering;

/**
 *
 * @author xylix
 */
public interface Renderable {
    String row(int y);
    String column(int x);
    Character tile(int x, int y);
}
