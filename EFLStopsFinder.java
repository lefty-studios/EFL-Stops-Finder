/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eflstopsfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Lefty
 */
public class EFLStopsFinder {
    
    public static int[] lineNumbers = null;
    public static int lineNumber = 0;
    public static void main(String[] args) throws IOException 
       {
           File dir = new File("C:/EFL");
           File[] directoryListing = dir.listFiles();
           if (directoryListing != null) {
               System.out.println("read");
            for (File child : directoryListing) {
             String[] words=null;  //Intialize the word Array
             FileReader fr = new FileReader(child);  //Creation of File Reader object
             BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
             String s;     
             PlayReader reader = new PlayReader();
             
             cleanupText(child);
             
              while((s=br.readLine())!=null)   //Reading Content from the file
             {  
                
                reader.readLine(s);
                lineNumber++;
             }

                fr.close();
                }
             }
           Player player = new Player();
           System.out.println(player.output());
       }

    public static void cleanupText(File file) throws IOException{
            String data = FileUtils.readFileToString(file);
            data = data.replace("	", ".");
            FileUtils.writeStringToFile(file, data);
             
            data = data.replace(" Tackle by ", "");
            FileUtils.writeStringToFile(file, data);
             
            data = data.replace("..", ".");
            FileUtils.writeStringToFile(file, data);
    
            
            }
  
             
    }
