/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scedule_gui;

import java.awt.event.ActionListener;

/**
 *
 * @author user
 */

public class Main {
    

    public static void main(String[] args) {

         Loding_form form=new Loding_form();
           form.setVisible(true);
                     try {
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(50);
                form.precentage_label.setText(Integer.toString(i)+"%");
                if (i==10) {
                    form.Loding_label.setText("Set up Work Environment...");
                }
                
                 if (i==20) {
                    form.Loding_label.setText("Connecting data base...");
                }
                if (i==50) {
                    form.Loding_label.setText("Connection Successful !");
                }
                if (i==70) {
                    form.Loding_label.setText("Loading Events Data...");
                }
                 if (i==80) {
                    form.Loding_label.setText("Launching Application...");
                }

                
               form.loading_bar.setValue(i);
            }
        } catch (Exception e) {
        }
        form.dispose();
        Login_gui_form login=new Login_gui_form();
        login.setVisible(true);
        login.event_screen.setTime();



            
        

        
     
        
    }
    
}
