/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scedule_gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PasswordView;

/**
 *
 * @author user
 */
public class Events extends JFrame   {
    String dd;
    Toolkit toolkit=getToolkit();
    Dimension size=toolkit.getScreenSize();
    JPanel main_panel=new JPanel();
    JPanel side_panel=new JPanel();
    JPanel Status_panel=new JPanel();
    JPanel home_panel=new JPanel();
    JPanel Upcoming_pane=new JPanel();
    JPanel done_panel=new JPanel();
    JPanel credits=new JPanel();
    JPanel info_panel=new JPanel();
    JPanel home_area=new JPanel();
    JPanel up_area=new JPanel();
    JPanel done_area=new JPanel();
    JPanel credits_area=new JPanel();
    JTabbedPane container=new JTabbedPane();
    JLabel Hi_label=new JLabel("Good Morning ,");
    ImageIcon sun=new ImageIcon("Images\\sun.png");
    ImageIcon moon=new ImageIcon("Images\\moon.png");
    JLabel sun_moon_Label=new JLabel(sun);
    JLabel home_label=new JLabel("Seetings");
    JLabel upcoming_label=new JLabel("Home");
    JLabel done_label=new JLabel("Done Events");
    JLabel credits_label=new JLabel("Credits");
    JLabel events_scd=new JLabel("Events Scheduler");
    ImageIcon homeIcon=new ImageIcon("Images\\seetings.png");
    JLabel home_label_pic=new JLabel(homeIcon);
     ImageIcon upicon=new ImageIcon("Images\\home.png");
    JLabel up_label_pic=new JLabel(upicon);
     ImageIcon doneIcon=new ImageIcon("Images\\done.png");
    JLabel done_label_pic=new JLabel(doneIcon);
     ImageIcon creditsIcon=new ImageIcon("Images\\credits.png");
    JLabel credits_label_pic=new JLabel(creditsIcon);
    /////time and date
     Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    String time;
     SimpleDateFormat dayFormat;
     JLabel dayLabel;
    String day;
    
    SimpleDateFormat dateFormat;
     JLabel dateLabel;
    String date;
    
    JSeparator title_sp=new JSeparator();
    JLabel user_name=new JLabel();
    JLabel user_hi=new JLabel();
    Font vardina=new Font("Verdana",Font.PLAIN,20);
     Font ink=new Font("Ink Free",Font.PLAIN,20);
     ///trying
     JLabel h=new JLabel("HOME");
      JLabel u=new JLabel("upcoming");
       JLabel d=new JLabel("done");
        JLabel c=new JLabel("credits");
        Upcoming_area_class upcoming_area_class=new Upcoming_area_class();
        Done_area_class done_area_class=new Done_area_class();
//        Color dark_panels_color=new Color(64,43,100);//51 51 51
//         Color dark_panels_color_clicked=new Color(153,153,153);//153 135 153
          boolean dark_flag=false;
          String cu_user_name=new String();
           String cu_user_pass=new String();
           Generics g_code=new Generics();
           CREDITS_Pan c_r=new CREDITS_Pan();
           Settings_panel setting_panel=new Settings_panel();
           
           
           Color chossen_panels_mcolor;
           Color panels_main_color;
           //red mode colors
          Color r_infoColor=new Color(255,51,51);
          Color r_sideColor=new Color(153,0,0);
          Color r_side_panels=new Color(255,102,102);
          Color r_chossen_panels_color=new Color(255,153,153);
          Color r_main_color=new Color(255,204,204);
          
          //lavandr mode colors
         Color l_side=new Color(54,33,89);
         Color l_side_panels=new Color(85,55,118);
         Color l_chossen_panelColor=new Color(64,43,100);
         Color l_main_color=Color.white;
         Color l_infoColor=new Color(110,89,222);
         
         //dark mode colors
          Color d_side_color=new Color(0,0,0);
         Color d_side_panels=new Color(51,51,51);
         Color d_side_panels_chossen=new Color(153,153,153);
         Color d_info_clor=new Color(30,30,30);
         Color d_main_color=new Color(102,102,102);
         //green mode colors
         Color g_side_color=new Color(0,0,153);
         Color g_side_panels=new Color(153,153,255);
         Color g_side_panels_chossen=new Color(153,204,255);
         Color g_info_clor=new Color(51,51,255);
         Color g_main_color=new Color(204,204,255);
         
         //////icons
    ImageIcon lav_date_icon=new ImageIcon("Images\\lav_date.png");
    ImageIcon lav_time_icon=new ImageIcon("Images\\lav_time.png");
    ImageIcon lav_loc_icon=new ImageIcon("Images\\lav_loc.png");
    ImageIcon lav_rem_icon=new ImageIcon("Images\\lav_bell.png");
    ImageIcon[]lav_arr={lav_date_icon,lav_time_icon,lav_loc_icon,lav_rem_icon};
    ImageIcon red_date_icon=new ImageIcon("Images\\red_date.png");
    ImageIcon red_time_icon=new ImageIcon("Images\\red_time.png");
    ImageIcon red_loc_icon=new ImageIcon("Images\\red_loc.png");
    ImageIcon red_rem_icon=new ImageIcon("Images\\red_bell.png");
    ImageIcon[]red_arr={red_date_icon,red_time_icon,red_loc_icon,red_rem_icon};
     ImageIcon blue_date_icon=new ImageIcon("Images\\blue_date.png");
    ImageIcon blue_time_icon=new ImageIcon("Images\\blue_time.png");
    ImageIcon blue_loc_icon=new ImageIcon("Images\\blue_loc.png");
    ImageIcon blue_rem_icon=new ImageIcon("Images\\blue_bell.png");
    ImageIcon[]blue_arr={blue_date_icon,blue_time_icon,blue_loc_icon,blue_rem_icon};
    ImageIcon dark_date_icon=new ImageIcon("Images\\gray_date.png");
    ImageIcon dark_time_icon=new ImageIcon("Images\\gray_time.png");
    ImageIcon dark_loc_icon=new ImageIcon("Images\\gray_loc.png");
    ImageIcon dark_rem_icon=new ImageIcon("Images\\gray_bell.png");
    ImageIcon[]dark_arr={dark_date_icon,dark_time_icon,dark_loc_icon,dark_rem_icon};
    
    //Empty_icons
    ImageIcon lav_empty=new ImageIcon("empty_pics\\lav_empty.png");
    ImageIcon red_empty=new ImageIcon("empty_pics\\red_empty.png");
    ImageIcon blue_empty=new ImageIcon("empty_pics\\blue_empty.png");
    ImageIcon dark_empty=new ImageIcon("empty_pics\\dark_empty.png");
    
      Notifiction_frame notifiction=new Notifiction_frame();
      
    public Events()
    {
        System.out.println(dd);
        this.setTitle("Events Scheduele");
        this.setSize(1000,700);
        this.setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setAlwaysOnTop(rootPaneCheckingEnabled);
        this.setLayout(null);
        main_panel.setLayout(null);
         side_panel.setLayout(null);
         home_panel.setLayout(null);
         Upcoming_pane.setLayout(null);
         done_panel.setLayout(null);
         credits.setLayout(null);
         Status_panel.setLayout(null);
         info_panel.setLayout(null);
         setting_panel.e=this;
         //Dark and light mode
        
        //light_mode();
       set_mode(l_infoColor, l_side, l_side_panels, l_chossen_panelColor, l_main_color,lav_arr,lav_empty);

         upcoming_area_class.cu_user=cu_user_name;
         upcoming_area_class.cu_pass=cu_user_pass;
       
         //System.out.println(upcoming_area_class.cu_pass);
         //createPopmenu(this);
        //panel settings
        main_panel.setBounds(0, 0, 1000, 700);
        side_panel.setBounds(0, 0, 300, 700);
        //side_panel.setBackground(new Color(54,33,89));
        home_panel.setBounds(0, 300, 300, 50);//0, 180, 300, 50
        Upcoming_pane.setBounds(0, 180, 300, 50);//0, 240, 300, 50
        done_panel.setBounds(0, 240, 300, 50);//0, 300, 300, 50
        credits.setBounds(0, 360, 300, 50);//0, 360, 300, 50
//        home_panel.setBackground(new Color(85,55,118));
//        Upcoming_pane.setBackground(new Color(85,55,118));
//        done_panel.setBackground(new Color(85,55,118));
//        credits.setBackground(new Color(85,55,118));
        Status_panel.setBounds(300,30,700,150);//300,50,700,150
//        Status_panel.setBackground(new Color(110,89,222));
        info_panel.setLayout(null);
        //info_panel.setBackground(new Color(110,89,222));//85,65,118
        info_panel.setBounds(300,0,700,30);
        container.setBounds(298,150,700,520);//300,180,700,480
        home_area.add(h);
        //up_area.add(u);
        done_area.add(d);
        credits_area.add(c);
       
        container.add("upcoming",upcoming_area_class);
        container.add("done",done_area_class);
         container.add("Home",setting_panel);
        container.add("credits",c_r);
        //ading
        this.add(main_panel);
        main_panel.add(this.side_panel);
        main_panel.add(this.Status_panel);
        main_panel.add(container);
        side_panel.add(home_panel);
        side_panel.add(Upcoming_pane);
        side_panel.add(done_panel);
        side_panel.add(credits);
        
        //Labels
        // set_time_interval();
        home_label.setBounds(70, 10, 100, 30);
       user_name.setBounds(15, 5, 200, 20);
       user_name.setFont(vardina);
       user_name.setForeground(Color.white);
       Hi_label.setBounds(5, 20, 270, 100);
       Hi_label.setForeground(Color.white);
       Hi_label.setFont(new Font("Verdana",Font.PLAIN,30));
       user_hi.setBounds(240,20,270,100);
        user_hi.setForeground(Color.white);
       user_hi.setFont(new Font("Verdana",Font.PLAIN,30));
       sun_moon_Label.setBounds(400,20,100,100);
       
       Status_panel.add(sun_moon_Label);
       
       
        home_label_pic.setBounds(20, 10, 30, 30);
        up_label_pic.setBounds(20, 10, 30, 30);
        done_label_pic.setBounds(20, 10, 30, 30);
        credits_label_pic.setBounds(20, 10, 30, 30);
        home_label.setForeground(Color.WHITE);
        upcoming_label.setBounds(70, 10, 100, 30);
        upcoming_label.setForeground(Color.WHITE);
        done_label.setBounds(70,10,100,30);
        done_label.setForeground(Color.WHITE);
        credits_label.setBounds(70, 10, 100, 30);
        credits_label.setForeground(Color.WHITE);
        events_scd.setBounds(10,40,200,50);
        events_scd.setFont(new Font("Segoe UI", 1, 24));
        //////date and time label
        timeFormat=new SimpleDateFormat("HH:mm");
        timeLabel=new JLabel();
        timeLabel.setFont(vardina);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(600, 5, 150, 20);
        
        dayFormat=new SimpleDateFormat("EEEE");
        dayLabel=new JLabel();
        dayLabel.setFont(vardina);
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setBounds(230, 5, 150, 20);
        
        dateFormat=new SimpleDateFormat("EEE,d MMM yyyy");
        dateLabel=new JLabel();
        dateLabel.setFont(vardina);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBounds(10, 5, 200, 20);
        
      
        
        title_sp.setBounds(10, 92, 250, 20);
        events_scd.setForeground(Color.WHITE);
        title_sp.setBackground(Color.WHITE);
        home_panel.add(home_label);
         home_panel.add(home_label_pic);
         Upcoming_pane.add(up_label_pic);
         done_panel.add(done_label_pic);
         credits.add(credits_label_pic);
        Upcoming_pane.add(upcoming_label);
        main_panel.add(info_panel);
        done_panel.add(done_label);
        credits.add(credits_label);
        side_panel.add(events_scd);
        Status_panel.add(Hi_label);
        Status_panel.add(user_hi);
        side_panel.add(title_sp);
        //info_panel.add(user_name);
        info_panel.add(timeLabel);
        //info_panel.add(dayLabel);
        info_panel.add(dateLabel);
        
        ///events
         home_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_homeMousePressed(evt);
            }});
            Upcoming_pane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_upMousePressed(evt);
            }});
            done_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_doneMousePressed(evt);
            }});
            credits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ceditsMousePressed(evt);
            }});
            
            setting_panel.lavendr_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
               set_mode(l_infoColor, l_side, l_side_panels, l_chossen_panelColor, l_main_color,lav_arr,lav_empty);
            }
        });
         
                    setting_panel.red_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
         set_mode(r_infoColor, r_sideColor, r_side_panels, r_chossen_panels_color, r_main_color,red_arr,red_empty);

            }
        });
                    
                   setting_panel.blue_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
         
                  set_mode(g_info_clor, g_side_color, g_side_panels, g_side_panels_chossen, g_main_color,blue_arr,blue_empty);
            }
        });
        
                    setting_panel.dark_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
              
               set_mode(d_info_clor, d_side_color, d_side_panels, d_side_panels_chossen, d_main_color,dark_arr,dark_empty);
            }
        });

      
        
      
  
    }
   
     public  void setTime()
    {
         while(true)
        {
        time=timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(time);
        day=dayFormat.format(Calendar.getInstance().getTime());
        dayLabel.setText(day);
        date=dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);
         set_time_interval();
             try {
                 send_notifiction();
             } catch (ParseException ex) {
                 Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
             }

        
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      private void btn_homeMousePressed(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        setColor(home_panel);
        resetColor(Upcoming_pane);
         resetColor(done_panel);
          resetColor(credits);
          container.setSelectedIndex(2);
    }    
        private void btn_upMousePressed(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        setColor(Upcoming_pane);
        resetColor(home_panel);
         resetColor(done_panel);
          resetColor(credits);
           container.setSelectedIndex(0);
           upcoming_area_class.set_user(cu_user_name, cu_user_pass);
          
    }  
        private void btn_doneMousePressed(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        setColor(done_panel);
        resetColor(Upcoming_pane);
         resetColor(home_panel);
          resetColor(credits);
           container.setSelectedIndex(1);
    }  
      private void btn_ceditsMousePressed(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        setColor(credits);
        resetColor(Upcoming_pane);
         resetColor(done_panel);
          resetColor(home_panel);
           container.setSelectedIndex(3);
    }  
      private 
     void setColor(JPanel panel)
     {
        panel.setBackground(chossen_panels_mcolor);
//         if (!dark_flag) {
//              panel.setBackground(new Color(153,153,153));
//         }
//         else
//         {
//         panel.setBackground(new Color(85,65,118));//main
//         }
     }
     void resetColor(JPanel panel)
     {
         panel.setBackground(panels_main_color);
         
//         if (!dark_flag) {
//             panel.setBackground(new Color(51,51,51));
//         }else{
//         panel.setBackground(new Color(64,43,100));
//         }
     }
     public void set_time_interval()
     {
         SimpleDateFormat ctime=new SimpleDateFormat("a");
         String time=ctime.format(Calendar.getInstance().getTime());
         if (time=="AM") {
             
              Hi_label.setText("Good Morning ,");
              sun_moon_Label.setIcon(sun);
             
         }
         else if(time.equals("PM"))
         {
              Hi_label.setText("Good Evening ,");
              sun_moon_Label.setIcon(moon);
         }
         
          
         
     }
     public void set_user(String user,String pass,String user_data)
     {
         this.cu_user_name=user;
         this.user_hi.setText(user);
         this.cu_user_pass=pass;
         this.upcoming_area_class.cu_user=user;
         this.upcoming_area_class.cu_pass=pass;
         this.done_area_class.c_pass=pass;
         this.done_area_class.c_user=user;
         this.upcoming_area_class.up.current_user=user;
         this.upcoming_area_class.up.cureent_password=pass;
        this.g_code.table_full(user, pass, upcoming_area_class.jt,"/Display",upcoming_area_class.sp,upcoming_area_class.empty_lb);
         this.g_code.table_full(user, pass, done_area_class.jt,"/Display_done",done_area_class.sp,done_area_class.empty_lb);
         this.upcoming_area_class.up.sp=this.upcoming_area_class.sp;
         this.upcoming_area_class.add_pane.sp=this.upcoming_area_class.sp;
         this.upcoming_area_class.up.empty_lb=this.upcoming_area_class.empty_lb;
         this.upcoming_area_class.add_pane.empty_lb=upcoming_area_class.empty_lb;
         
     }

     

      public void set_mode(Color info,Color side,Color side_panels,Color chossen_panel,Color main_color,ImageIcon[]icon_arr,ImageIcon empty_ic)
      {
          //colors
          chossen_panels_mcolor=chossen_panel;
          panels_main_color=side_panels;
          side_panel.setBackground(side);
         home_panel.setBackground(side_panels);
          Upcoming_pane.setBackground(side_panels);
           done_panel.setBackground(side_panels);
            credits.setBackground(side_panels);
            Status_panel.setBackground(info);
            info_panel.setBackground(info);
            upcoming_area_class.setBackground(main_color);
            done_area_class.setBackground(main_color);
            home_area.setBackground(main_color);
            c_r.setBackground(main_color);
            home_area.setBackground(main_color);
            credits_area.setBackground(main_color);
            upcoming_area_class.jt.getTableHeader().setBackground(info);
            upcoming_area_class.jt.setForeground(info);
            upcoming_area_class.jt.setSelectionBackground(side);
            done_area_class.jt.getTableHeader().setBackground(info);
            done_area_class.jt.setForeground(info);
            done_area_class.jt.setSelectionBackground(side);
            upcoming_area_class.sp.getViewport().setBackground(main_color);
            done_area_class.sp.getViewport().setBackground(main_color);
            setting_panel.setBackground(main_color);
            
            c_r.dev1.setForeground(info);
            c_r.dev2.setForeground(info);
            c_r.dev3.setForeground(info);
            c_r.dev4.setForeground(info);
            c_r.dev6.setForeground(info);
            c_r.dev7.setForeground(info);
            c_r.dev8.setForeground(info);
            c_r.main_label.setForeground(info);
            
            c_r.main_sep.setForeground(side);
            c_r.jLabel11.setForeground(side);
            c_r.jLabel13.setForeground(side);
            c_r.jLabel15.setForeground(side);
            c_r.jLabel17.setForeground(side);
            c_r.jLabel3.setForeground(side);
            c_r.jLabel4.setForeground(side);
            c_r.jLabel9.setForeground(side);
            c_r.jSeparator10.setForeground(side_panels);
            c_r.jSeparator11.setForeground(side_panels);
            c_r.jSeparator12.setForeground(side_panels);
            c_r.jSeparator13.setForeground(side_panels);
            c_r.jSeparator14.setForeground(side_panels);
            c_r.jSeparator8.setForeground(side_panels);
            c_r.jSeparator9.setForeground(side_panels);
            c_r. main_sep.setBorder(javax.swing.BorderFactory.createLineBorder(side, 20));
            c_r.ending_statement.setForeground(side_panels);

             upcoming_area_class.Add_Button.setBackground(side);
             done_area_class.clear_btn.setBackground(side);
             
             
             setting_panel.theme_sep.setBorder(javax.swing.BorderFactory.createLineBorder(side, 20));
             setting_panel.Log_out.setBackground(side);
             setting_panel.jSeparator5.setForeground(side);
             setting_panel.jSeparator6.setForeground(side);
             setting_panel.jSeparator7.setForeground(side);
             setting_panel.jSeparator8.setForeground(side);
             setting_panel.main_panel.setBackground(main_color);
             setting_panel.themes_lb.setForeground(info);
             //Add_panel
             upcoming_area_class.add_pane.head_panel.setBackground(side);
             upcoming_area_class.add_pane.Add_button.setBackground(side);
             upcoming_area_class.add_pane.date_lb.setIcon(icon_arr[0]);
             upcoming_area_class.add_pane.Time_label.setIcon(icon_arr[1]);
             upcoming_area_class.add_pane.loc_lb.setIcon(icon_arr[2]);
             upcoming_area_class.add_pane.rem_lb.setIcon(icon_arr[3]);
             upcoming_area_class.add_pane.event_name_tx.setForeground(info);
              upcoming_area_class.add_pane.Place.setForeground(info);
               upcoming_area_class.add_pane.Days_start_cm.setForeground(info);
              upcoming_area_class.add_pane.month_start_cm.setForeground(info);
              upcoming_area_class.add_pane.year_cm.setForeground(info);
              upcoming_area_class.add_pane.hour_start.setForeground(info);
              upcoming_area_class.add_pane.hour_end.setForeground(info);
              upcoming_area_class.add_pane.min_start.setForeground(info);
              upcoming_area_class.add_pane.min_end.setForeground(info);
              upcoming_area_class.add_pane.Reminder_cm.setForeground(info);
              upcoming_area_class.add_pane.jLabel2.setForeground(side);
              upcoming_area_class.add_pane.jLabel3.setForeground(side);
              upcoming_area_class.add_pane.jLabel9.setForeground(side);
               upcoming_area_class.add_pane.jLabel11.setForeground(side);
              upcoming_area_class.add_pane.jLabel12.setForeground(side);
              upcoming_area_class.add_pane.jLabel13.setForeground(side);
              upcoming_area_class.add_pane.jLabel9.setForeground(side);
              upcoming_area_class.add_pane.jSeparator1.setForeground(side);
              upcoming_area_class.add_pane.jSeparator2.setForeground(side);
              upcoming_area_class.up.font_color=side;
               upcoming_area_class.add_pane.font_color=side;
            //Update_panel
             upcoming_area_class.up.head_panel.setBackground(side);
             upcoming_area_class.up.update_button.setBackground(side);
             upcoming_area_class.up.date_lb.setIcon(icon_arr[0]);
             upcoming_area_class.up.Time_label.setIcon(icon_arr[1]);
             upcoming_area_class.up.loc_lb.setIcon(icon_arr[2]);
             upcoming_area_class.up.rem_lb.setIcon(icon_arr[3]);
             upcoming_area_class.up.event_name_tx.setForeground(info);
              upcoming_area_class.up.Place.setForeground(info);
               upcoming_area_class.up.Days_start_cm.setForeground(info);
              upcoming_area_class.up.month_start_cm.setForeground(info);
              upcoming_area_class.up.year_cm.setForeground(info);
              upcoming_area_class.up.hour_start.setForeground(info);
              upcoming_area_class.up.hour_end.setForeground(info);
              upcoming_area_class.up.min_start.setForeground(info);
              upcoming_area_class.up.min_end.setForeground(info);
              upcoming_area_class.up.Reminder_cm.setForeground(info);
              upcoming_area_class.up.jLabel2.setForeground(side);
              upcoming_area_class.up.jLabel3.setForeground(side);
              upcoming_area_class.up.jLabel9.setForeground(side);
               upcoming_area_class.up.jLabel11.setForeground(side);
              upcoming_area_class.up.jLabel12.setForeground(side);
              upcoming_area_class.up.jLabel13.setForeground(side);
              upcoming_area_class.up.jLabel9.setForeground(side);
              upcoming_area_class.up.jSeparator1.setForeground(side);
              upcoming_area_class.up.jSeparator2.setForeground(side);
//              upcoming_area_class.sort_type.setBackground(main_color);
//              upcoming_area_class.sort_type.setForeground(info);
//                     Image img=empty_ic.getImage();
//                     Image immgScaled=img.getScaledInstance(upcoming_area_class.empty_lb.getWidth(), upcoming_area_class.empty_lb.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon scaledicon=new ImageIcon(immgScaled);
//                    upcoming_area_class.empty_lb.setIcon(empty_ic);
            g_code.Scale_image(empty_ic, upcoming_area_class.empty_lb);
            g_code.Scale_image(empty_ic, done_area_class.empty_lb);
            
            notifiction.head_panel.setBackground(info);
            
            
              
             
                  
      }


public void send_notifiction() throws ParseException
{
    for (int i = 0; i < upcoming_area_class.jt.getRowCount(); i++) {
         DefaultTableModel ev_model=(DefaultTableModel)upcoming_area_class.jt.getModel();
          String name=ev_model.getValueAt(i, 0).toString();
         String event_date_s=ev_model.getValueAt(i, 2).toString();
         String r_time=ev_model.getValueAt(i, 5).toString();
         SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy HH:mm");
         String ev_date_s=event_date_s+" "+r_time;
         Date event_date= date.parse(ev_date_s);
         System.out.println("string date : "+ev_date_s);
         System.out.println("Date : "+event_date);
         String sys_date_s=date.format(Calendar.getInstance().getTime());
          Date sys_date= date.parse(sys_date_s);
           System.out.println("sys Date : "+sys_date);
           if (sys_date.compareTo(event_date)==0) {
                notifiction.notifiction(name);
               System.out.println("Sucess..................");
               
            
        }
           else{
               System.out.println("Wrong dates.......");
           }
         
    }
}



    

}
