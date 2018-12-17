/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render;

import baidemo.Demo;
import java.awt.Color;
import model.Quai;
import movement.GameLoop;

/**
 *
 * @author IU
 */
public class Render implements Runnable{

    private Demo demo;
    private boolean isRender;
    private int timeRender;
    public Render(Demo demo){
        this.isRender = true;
        this.demo = demo;
        this.timeRender = 100;
    }
    public void add(Quai c){
        GameLoop.characters.add(c);
    }
    
    public void setTimeRender(int time){
        this.timeRender = time;
    }
    
    public void nen(){
        this.demo.getGraphics().setColor(Color.yellow);
        this.demo.getGraphics().fillRect(200,  200,  50, 30);
        this.demo.getGraphics().setColor(Color.blue);
        this.demo.getGraphics().fillRect(200,  300,  50, 30);
    }
    
    @Override
    public void run() {
        while(true){
            demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
            
            //nen();
            GameLoop.nv.render(this.demo.getGraphics());
            for(Quai c : GameLoop.characters){
                if(c==null)break;
                c.render(this.demo.getGraphics());
            }
             
            try{
                Thread.sleep(timeRender);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }   
}
