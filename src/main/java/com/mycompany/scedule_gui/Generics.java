/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scedule_gui;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Generics {
    ImageIcon empty_icon;
    JLabel empty_Label=new JLabel();
    
           public String RunCmd(String Filename,String Commands) throws IOException
    {
        Runtime rt =Runtime.getRuntime();
        Process proc;
        proc =rt.exec(Filename+" "+Commands);
        BufferedReader buf =new BufferedReader(
                new InputStreamReader(proc.getInputStream())
        
        );
        String Line,Result="";
        while((Line=buf.readLine())!=null)
        {
            Result+=Line+"\n";
        }
        return Result;
    }
           
     public void table_full(String user,String pass,JTable ev_t,String command,JScrollPane sp,JLabel emp_lb)
    {    
        //ev_t.setVisible(true);
          DefaultTableModel ev_model=(DefaultTableModel)ev_t.getModel();
          ev_model.setRowCount(0);
         
          //String FileNme="event_scd_cpp\\Event_scd\\Debug\\Event_scd.exe";
          String FileNme="event_scd_cpp\\map_ev_scd\\Event_scheduele_by_map\\Debug\\Event_scheduele_by_map.exe";
          String ev_Args=command+" "+user+" "+pass;
          
          String ev_source = null;
               try {
                  ev_source=  RunCmd(FileNme, ev_Args);
                 
               } catch (IOException ex) {
                   Logger.getLogger(Generics.class.getName()).log(Level.SEVERE, null, ex);
               }
               System.out.println("data : "+ev_source+"end");

            String columns[]={"Name","Place","Date","From","To","Rimend me"};
          
          
         
          ev_model.setColumnIdentifiers(columns);
         
           String[] events=ev_source.split("\n");
           
           
        
       
        for (String event : events) {
            String[] r=event.split(",");
            ev_model.addRow(r);
        }
        if (ev_t.getValueAt(0, 0).toString().equals("")) {
            ev_model.setRowCount(0);
            sp.setVisible(false);
            emp_lb.setVisible(true);
            
           
        }
        else
        {
            emp_lb.setVisible(false);
             sp.setVisible(true);
             
        }

        
        

     

    }
             public void Scale_image(ImageIcon icon,JLabel label)
    {
        Image img=icon.getImage();
        Image immgScaled=img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledicon=new ImageIcon(immgScaled);
        label.setIcon(scaledicon);
        
    }
          
    
}
