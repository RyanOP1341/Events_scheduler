package com.mycompany.scedule_gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.BorderFactory.createEmptyBorder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Done_area_class extends JPanel  {
    Generics g_code=new Generics();
     ImageIcon clear_btn_icon=new ImageIcon("Images\\Clear_icon.png");
      JButton clear_btn=new JButton("Clear",clear_btn_icon);
      JTable jt=new JTable(0,0);
      ImageIcon refresh_icon=new ImageIcon("Images\\icons8_refresh_40px.png");
      JLabel refresh=new JLabel(refresh_icon);
      String c_user=new String();
      String c_pass=new String();
       JScrollPane sp;
       JPanel panel;
       JLabel empty_lb=new JLabel();

      public Done_area_class()
      {
          this.setLayout(null);
          panel=this;
   
    jt.setBounds(50,40,650,350);       
    jt.setDefaultEditor(Object.class, null);
     sp=new JScrollPane(jt);
        jt.getTableHeader().setBackground(new Color(110,89,222));
        jt.setForeground(new Color(110,89,222));
        jt.getTableHeader().setForeground(Color.white);  
        jt.setRowHeight(25);
         jt.setSelectionBackground(new Color(64,43,100));
         jt.setSelectionForeground(Color.WHITE);
          refresh.setBounds(590,10,40,40);
      add(refresh);
    sp.getViewport().setBackground(Color.white);
    jt.setBorder(null);
    sp.getVerticalScrollBar().setBorder(null);
sp.getHorizontalScrollBar().setBorder(null);
sp.setBorder(null);
        sp.setBounds(20, 50, 650, 300);
        clear_btn.setBounds(240, 400, 214, 46);
        
        clear_btn.setForeground(Color.white);
        clear_btn.setFont(new Font("Segoe UI", 1, 24));
       empty_lb.setBounds(175,60,400,350);
       add(sp);
       add(empty_lb);

   // Add_Button.setBounds(50, 380, 120, 30);
    //Add_Button.setBackground(Color.BLUE);
  //Add_Button.setForeground(Color.WHITE);
       // add(Add_Button);
              refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                g_code.table_full(c_user, c_pass, jt, "/Display_done",sp,empty_lb);
            }
        });
              
               clear_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                            String[] btn_op={"Clear","Cancel"};
               String meesage="You cannot retrieve this data again , Clear ?";
               int choice= JOptionPane.showOptionDialog(null, meesage, "Delete Event", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images\\icons8_trash_can_20px.png"), btn_op, 1);
               
                if (choice==0) {
                    String FileNme="event_scd_cpp\\Event_scd\\Debug\\Event_scd.exe";
                 String Args="/Clear_history"+" "+c_user+" "+c_pass;
                try {
                    g_code.RunCmd(FileNme, Args);
                } catch (IOException ex) {
                    Logger.getLogger(Done_area_class.class.getName()).log(Level.SEVERE, null, ex);
                }
                  g_code.table_full(c_user, c_pass, jt, "/Clear_history",sp,empty_lb);
                }

            }
        });
              
        this.add(clear_btn);
      }

   

    
    
}
