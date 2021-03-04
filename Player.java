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
public class Player {
    public static Players[] players = new Players[1];
    
    //public static String[][][] playerArr = new String[""][""][""];
    String[][][] playerArr = null;
    
    public Player(){
    
    }
    public void addStops(int i, String playerName){
        Players dummy = getPlayer(playerName);
        //System.out.println(dummy);
        if (i==3){
            dummy.addStop3();
        }
        if (i==4){
            dummy.addStop4();
        }
    }
    
    
    private Players getPlayer(String input){
        for (int i = 0; i < players.length; i++){
            if(players[i] != null){
                //System.out.println("player name is not null");
                //System.out.println(players[i].getName() + " vs input " +input);
                if(players[i].getName().contains(input)){
                   // System.out.println("found matching player");
                    return players[i];
                }
                if(i == (players.length-1) && !players[i].getName().contains(input)){
                   // System.out.println("player not found, creating new player");
                    return createNewPlayer(input);
                    //System.out.println("running through loop again");
                    //getPlayer(input);
                }
            }
            else{
                //System.out.println("looped through loop until we got to a null, creating new player");
                //return createNewPlayer(input);
                //System.out.println("running loop again");
                //getPlayer(input);
            }
        }
        return createNewPlayer(input);
    }
    private Players createNewPlayer(String input){
        Players newPlayer = new Players(input);
        //System.out.println(newPlayer);
        addPlayer(players.length, players, newPlayer);
        return newPlayer;
    }
    
    // Function to add x in arr 
    public static Players[] addPlayer(int n, Players arr[], Players x) 
    { 
        int i; 
  
        // create a new array of size n+1 
        arr = players;
        Players newarr[] = new Players[n + 1]; 
        if(arr[0] == null){
          arr[0] = x;  
          return arr;
        }
        // insert the elements from 
        // the old array into the new array 
        // insert all elements till n 
        // then insert x at n+1 
        for (i = 0; i < n; i++){
            newarr[i] = arr[i]; 
            //System.out.println(newarr[i]);
        }
        newarr[n] = x; 
        players = newarr;
        return newarr; 
    } 
    public String output (){
        String output = "Player Name, 3rd Down stops, 4th down stops, total stops \n"; 
        for (int i = 0; i < players.length; i++){
           if(players[i] != null){
           output =  output + players[i].getName() + ", " + players[i].getStops3() + ", " + players[i].getStops4() + ", " + players[i].getTotalStops() + "\n";  
           }
           //System.out.println(players[i]);
        }
        
        return output;
    }
}
