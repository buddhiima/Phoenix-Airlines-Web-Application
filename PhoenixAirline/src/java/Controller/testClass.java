/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static java.lang.System.*;
import java.sql.Timestamp;


/**
 *
 * @author Buddhima
 */
public class testClass {
    
    public static void main(String[] args) {
    
        java.util.Date date = new java.util.Date();
        long time = date.getTime();
        Timestamp currentTimestamp = new Timestamp(time);


        String depart = "2021-08-23 16:00:00";
        Timestamp departTimeStamp = Timestamp.valueOf(depart);

        System.out.println("Depart time stamp "+departTimeStamp);
        System.out.println("Current time stamp "+currentTimestamp);
        
        System.out.println("Depart time stamp get time "+departTimeStamp.getTime());
        System.out.println("Current time stamp get time "+currentTimestamp.getTime());
        
        long msDiff = currentTimestamp.getTime() - departTimeStamp.getTime();
        
        System.out.println("Diff time stamp "+msDiff);
    
    }

}


        

