/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;
import engine.Display;
/**
 *
 * @author michael
 */
public class Main {
    public static void main(String[] args){
        Display  display = new Display(800,600,"Software Rendering");
        
        while (true){
            display.SwapBuffers();
        }
    }
    
}
