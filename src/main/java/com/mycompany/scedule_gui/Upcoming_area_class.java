package com.mycompany.scedule_gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */

public class Upcoming_area_class extends JPanel implements ItemListener{
    public  JLabel empty_lb=new JLabel();
    update_set up=new update_set();
    Generics g_code=new Generics();
    DefaultTableModel ev_model;
    ADD_set add_pane=new ADD_set();
    ImageIcon add_icon=new ImageIcon("Images\\ADD.png");
     ImageIcon add_btn_icon=new ImageIcon("Images\\btn_add_icon.png");
     //JButton addButton=new JButton("Add Event",add_btn_icon);
    JButton Add_Button=new JButton("Add Event",add_icon);
    JLabel add_btn=new JLabel(add_btn_icon);
     JTable jt=new JTable(0,0);
     public String t_data=null;
       ImageIcon refresh_icon=new ImageIcon("Images\\icons8_refresh_40px.png");
      JLabel refresh=new JLabel(refresh_icon);
      String[] sort_choices={"sort by start time","sort by reminder time"};
      //JComboBox sort_type=new JComboBox(sort_choices);
    
    
           JPopupMenu popMenu=new JPopupMenu();
        JMenuItem menuItem=null;
        JMenuItem menuItem2=null;
        String cu_user=new String();
        String cu_pass=new String();
        JScrollPane sp;
        JPanel panel;
        
            //Empty_icons

    
    public Upcoming_area_class()
    {
       
        this.setLayout(null);
        
//        String data[][]={{}}; 
//    String column[]={"ID","NAME","SALARY"};         
//    JTable taple=new JTable(data,column);    
//    
//            
//    JScrollPane sp=new JScrollPane(taple);    
//    sp.setBounds(0, 50, 600, 300);
//    this.add(sp);
     refresh.setBounds(590,10,40,40);
       panel=this;
//     sort_type.setBounds(30,10,150,30);
//     sort_type.addItemListener(this);
//      add(sort_type);
      add(refresh);
         //System.out.println(t_data);
          jt.setBounds(50,40,650,350);     
         jt.setBackground(Color.white);
         jt.setDefaultEditor(Object.class, null);
         sp=new JScrollPane(jt);    
        sp.getViewport().setBackground(Color.white);
        sp.getViewport().setBorder(null);
        jt.getTableHeader().setBackground(new Color(110,89,222));
        jt.setForeground(new Color(110,89,222));
        jt.getTableHeader().setForeground(Color.white);  
        jt.setSelectionBackground(new Color(85,65,118));
         jt.setSelectionForeground(Color.WHITE);
        jt.setRowHeight(25);
        
         sp.setBounds(20, 50, 650, 300);
        Add_Button.setBounds(240, 400, 214, 46);
        sp.setBackground(Color.red);
        empty_lb.setBounds(175,60,400,350);
        
        add(sp);
        add(empty_lb);
        
        //set_taple();
        //sp.setVisible(false);
        Add_Button.setForeground(Color.white);
        Add_Button.setFont(new Font("Segoe UI", 1, 24));

        

   // Add_Button.setBounds(50, 380, 120, 30);
    //Add_Button.setBackground(Color.BLUE);
  //Add_Button.setForeground(Color.WHITE);
       // add(Add_Button);
                     refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                g_code.table_full(cu_user, cu_pass, jt, "/Display",sp,empty_lb);
            }
        });
       
              Add_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_btn_MousePressed(evt);
            }
        });
        add(Add_Button);
        createPopmenu(this);
            jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tapleMouseReleased(evt);
            }
        });
             add_pane.table=jt;
             up.table=jt;
    }
            
    private void add_btn_MousePressed(java.awt.event.MouseEvent evt) { 
       add_pane.set_user(cu_user, cu_pass);
        add_pane.show();
        
           
    }    
     private void createPopmenu(JPanel panel)
     {
         
        menuItem=new JMenuItem(
                "Update Event",new ImageIcon("Images\\icons8_update_20px.png")
        );
        menuItem.getAccessibleContext().setAccessibleDescription("Update Event");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              DefaultTableModel ev_model=(DefaultTableModel)jt.getModel();
              String name=ev_model.getValueAt(jt.getSelectedRow(), 0).toString();
              String place=ev_model.getValueAt(jt.getSelectedRow(), 1).toString();
              String Date=ev_model.getValueAt(jt.getSelectedRow(), 2).toString();
              String[] splited_date=Date.split("/");
              String s_time=ev_model.getValueAt(jt.getSelectedRow(), 3).toString();
              String[] splited_strime=s_time.split(":");
              String e_time=ev_model.getValueAt(jt.getSelectedRow(), 4).toString();
              String[] splited_etime=e_time.split(":");
              String r_time=ev_model.getValueAt(jt.getSelectedRow(), 5).toString();
               String[] splited_rtime=r_time.split(":");
               
              up.event_name_tx.setText(name);
              up.Place.setText(place);
              up.Days_start_cm.setSelectedItem(splited_date[0]);
              up.month_start_cm.setSelectedItem(splited_date[1]);
              up.year_cm.setSelectedItem(splited_date[2]);
              up.hour_start.setSelectedItem(splited_strime[0]);
              up.min_start.setSelectedItem(splited_strime[1]);
              up.hour_end.setSelectedItem(splited_etime[0]);
              up.min_end.setSelectedItem(splited_etime[1]);
              up.old_ev_name=name;
              up.key=splited_date[2]+splited_date[1]+splited_date[0]+splited_rtime[0]+splited_rtime[1];
              up.setVisible(true);
              int rem_time=(Integer.parseInt(splited_rtime[0])*60)+(Integer.parseInt(splited_rtime[1]));
              int start_time=(Integer.parseInt(splited_strime[0])*60)+(Integer.parseInt(splited_strime[1]));
              int reminder=start_time-rem_time;
                System.err.println("Reminder : "+reminder);
                if (reminder==0) {
                    up.Reminder_cm.setSelectedIndex(0);
                }
                else if (reminder==5) {
                    up.Reminder_cm.setSelectedIndex(1);
                }
                 else if (reminder==15) {
                    up.Reminder_cm.setSelectedIndex(2);
                }
                else if (reminder==30) {
                    up.Reminder_cm.setSelectedIndex(3);
                }
                else if (reminder==60) {
                    up.Reminder_cm.setSelectedIndex(4);
                }
                else if (reminder==120) {
                    up.Reminder_cm.setSelectedIndex(5);
                }
              
            }
        });
        popMenu.add(menuItem);
       menuItem2=new JMenuItem(
                "Delete Event",new ImageIcon("Images\\icons8_trash_can_20px.png")
               
        );
        menuItem2.getAccessibleContext().setAccessibleDescription("delete Event");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 DefaultTableModel ev_model=(DefaultTableModel)jt.getModel();
                String name=ev_model.getValueAt(jt.getSelectedRow(), 0).toString();
               String Date=ev_model.getValueAt(jt.getSelectedRow(), 2).toString();
              String[] splited_date=Date.split("/");
              String s_time=ev_model.getValueAt(jt.getSelectedRow(), 3).toString();
              String[] splited_strime=s_time.split(":");
                String r_time=ev_model.getValueAt(jt.getSelectedRow(), 5).toString();
               String[] splited_rtime=r_time.split(":");
              String key=splited_date[2]+splited_date[1]+splited_date[0]+splited_rtime[0]+splited_rtime[1];
                System.out.println("key : "+key);
               String[] btn_op={"Delete it","Cancel"};
               String meesage="Event "+"\""+name+"\""+" will permently deleted .";
               int choice= JOptionPane.showOptionDialog(null, meesage, "Delete Event", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Images\\icons8_trash_can_20px.png"), btn_op, 1);
               
                if (choice==0) {
                 String FileNme="event_scd_cpp\\map_ev_scd\\Event_scheduele_by_map\\Debug\\Event_scheduele_by_map.exe";
                 
                 String Args="/Delete"+" "+cu_user+" "+cu_pass+" "+key ;
                 System.out.println(Args);
                try {
                   String r= g_code.RunCmd(FileNme, Args);
                    System.out.println("|"+r+"|");
                    g_code.table_full(cu_user, cu_pass, jt, "/Display",sp,empty_lb);
                } catch (IOException ex) {
                    Logger.getLogger(Upcoming_area_class.class.getName()).log(Level.SEVERE, null, ex);
                }
                }

            }
        });
         popMenu.add(menuItem2);
                
     }
        private void tapleMouseReleased(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        if(evt.isPopupTrigger()){
        popMenu.show(this,evt.getX(), evt.getY());
        }
    } 
             public void set_user(String user,String pass)
     {
         this.cu_user=user;
         
         this.cu_pass=pass;
     }
             public void set_taple()
             {
                 if (jt.getRowCount()==0) {
                     sp.setVisible(false);
                 }
                 else
                 {
                     sp.setVisible(true);
                     
                 }
                 
             }

    @Override
    public void itemStateChanged(ItemEvent e) {
//        if (e.getStateChange()==ItemEvent.SELECTED) {
//            if ((String)e.getItem()=="sort by start time") {
//                g_code.table_full(cu_user, cu_pass, jt, "/Display",sp,empty_lb);
//            }
//            else if ((String)e.getItem()=="sort by reminder time") {
//                g_code.table_full(cu_user, cu_pass, jt, "/sort_reminder",sp,empty_lb);
//            }
//        }
    }
     
    }


    

