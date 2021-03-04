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
public class PlayReader {
    //private int i = 0;
    
    public PlayReader(){

    }
   
    public void readLine(String input){
        boolean isPass = false;
        int down = 3;
        int distance = 10;
        int playResult = 0;
        Player player = new Player();
                        
        String playerName = "";
        
        String[] words=null;
        words=input.split("\\.");
        
        if(input.contains("TOUCHDOWN")){
            //System.out.println("touchdown, returning");
            return;
        }
        if(input.contains("INTERCEPTION")){
            /*
            String[] w=null;
            w = words[6].split(" ");
            for (int i = 0; i < words.length; i++){
                //System.out.println(i+" "+words[i]);
                //System.out.println(playerName); 
            }
             for (int j = 0; j < w.length; j++){
                    System.out.println("j " + j+" "+w[j]);                                
                }
                if(w.length < 5){
                    System.out.println(input);
                    return;
                }
                else{
                    playerName = w[3] + " "+ w[4];
                }
            player.addStops(3,playerName);
*/
            return;
        }
        if(input.contains("Punt")){
            //do something for interceptions
            //System.out.println("punt, returning");
            return;
        }
        
        if(input.contains("Penalty")){
            return;
        }
        if(input.contains("dropped")){
            return;
        }
        if(input.contains("incomplete")){
            return;
        }
        if(input.contains("FG")){
            //do something for interceptions
            //System.out.println("FG, returning");
            return;
        }
        if(input.contains("Timeout")){
            return;
        }
        if(input.contains("Rush")){
            isPass = false;
        }
        if(input.contains("Pass")){
            isPass = true;
        }
        
        //System.out.println(input);
         for (String word : words){
             //System.out.println(word);
            if (word.contains("3rd")||word.contains("4th")){
                if(input.contains("SACKED")){
                    String[] w=null;
                    //System.out.println(input);
                    for (int i = 0; i < words.length; i++){
                        //System.out.println(i+" "+words[i]);
                        w = words[5].split(" ");
                        //playerName = w[3] + " "+ w[4];

                        //System.out.println(playerName);
                    }
                    playerName = w[4] + ", " + w[3].charAt(0);
                    player.addStops(3,playerName);
                    return;
                }
                down = 3;
                
                if(isPass ==false){
                    //System.out.println(input);
                    if(words.length >= 7){
                        playerName = words[6];
                    }
                    
                        //System.out.println("player " + words[6]);
                    
                    //System.out.println("found a 3rd or 4th down that is not a punt or a kick");
                    //System.out.println(word);
                    for (int i = 0; i < words.length; i++){
                        //System.out.println(i+" "+words[i]);
                        String[] w=null;
                        String[] v = null;
                        if(words[2] != null){
                            v= words[2].split(" ");
                            //System.out.println(words[i]);
                            
                            //System.out.println("distance is " + v[2]);
                            if(words[2].contains("Goal")){
                                //System.out.println(w[2]);
                                //System.out.println("v2 is " + v[2]);
                                distance = 10; //THIS IS BAD
                            }
                            else{
                                //System.out.println("v2 is " + v[2]);
                                distance = Integer.parseInt(v[2]);
                            }
                            for (int j = 0; j < v.length; j++){
                                System.out.println("distance" + j+" "+v[j]);
                            }
                        }
                        if(words.length >= 6){
                            w= words[5].split(" ");
                            //System.out.println(words[5]);
                           // System.out.println("play went for " + w[2]);
                            if (words[5].contains("for a short gain")){
                                playResult = 0;
                            }
                            else{
                                //System.out.println("w2 is " + w[2]);
                                playResult = Integer.parseInt(w[2]);
                            }
                        }
                        else{
                            //System.out.println("there was not a words[5], printing input " + input);
                            for (int j = 0; j < words.length; j++){
                                //System.out.println("j " + j+" "+words[j]);                                
                            }
                            return;
                        }
                    }
                    //System.out.println(down + " and " + distance + " ended with " + playResult + " yards, tackle by " + playerName);
                    //now time for the logic
                    if(playResult < distance){
                        //we have a stop
                       //System.out.println("input for stop  \n" + input);
                      //  player.addStops(3,playerName);
                      player.addStops(3,playerName);
                    }
                }
                
                if(isPass ==true){
                    
                    //System.out.println(input);
                    //System.out.println("player " + words[6]);
                    //System.out.println("found a 3rd or 4th down that is not a punt or a kick");
                    //System.out.println(word);
                    if (input.contains("Broken up")){
                        String[] w=null;
                            String[] v = null;
                            if(words[7] != null){
                                v= words[7].split(" ");
                                    
                                for (int j = 0; j < v.length; j++){
                                    //System.out.println(" " + j+" "+v[j]);
                                    
                                }
                                String dummy = v[4] + " "+ v[5];
                                //System.out.println(dummy);
                                player.addStops(3,dummy);
                            }
                    }
                    else{
                    
                        for (int i = 0; i < words.length; i++){
                            //System.out.println(i+" "+words[i]);
                            String[] w=null;
                            String[] v = null;
                            if(words[2] != null){
                                v= words[2].split(" ");
                                //System.out.println(i +" " +words[i]);

                                //System.out.println("distance is " + v[2]);
                                if(words[2].contains("Goal")){
                                    //System.out.println(w[2]);
                                    //System.out.println("v2 is " + v[2]);
                                    distance = 10;
                                }
                                else{
                                    //System.out.println("v2 is " + v[2]);
                                    distance = Integer.parseInt(v[2]);
                                }
                                for (int j = 0; j < v.length; j++){
                                    //System.out.println("distance" + j+" "+v[j]);
                                }
                            }
                            if(words[6] != null){
                                w= words[6].split(" ");
                                //System.out.println(words[5]);
                               // System.out.println("play went for " + w[2]);
                                if (words[6].contains("for a short gain")){
                                    playResult = 0;
                                }
                                else{
                                    //System.out.println("w2 is " + w[2]);
                                    playResult = Integer.parseInt(w[2]);
                                }
                                
                                
                                
                                
                                for (int j = 0; j < w.length; j++){
                                    //System.out.println("j " + j+" "+w[j]);                                
                                }
                            }
                                if(words.length < 8){
                                    //play is a touchdown
                                    return;
                                }
                                else{
                                    playerName = words[7];
                                }
                        }
                    }            
                    //System.out.println(down + " and " + distance + " ended with " + playResult + " yards, tackle by " + playerName);
                    if(playResult < distance){
                        //we have a stop
                        //System.out.println("input for stop  \n" + input);
                        player.addStops(3,playerName);
                    }
                }
                
            }  
        }
    }
}