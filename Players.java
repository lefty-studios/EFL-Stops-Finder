/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eflstopsfinder;

/**
 *
 * @author Lefty
 */
public class Players {
    private int id;
    public String name = "";
    private int stops3 = 0;
    private int stops4 = 0;
    
    public Players(){
        this.name = "";
        stops3 = 0;
        stops4 = 0;
    }
    public Players(String name){
        this.name = name;
        stops3 = 0;
        stops4 = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }  
    public void addStop3(){
        stops3++;
        System.out.println("Stops for " + getName() + " is " + stops3);
    }
    public void addStop4(){
        stops4++;
    }
    public int getStops3(){
        return stops3;
    }
    public int getStops4(){
        return stops4;
    }
    public int getTotalStops(){
        return stops3 + stops4;
    }
}
