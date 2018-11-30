
package com.weekmanager;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Calendar;


public class ComWeekmanager extends JFrame {
    JFrame gui = new JFrame();
    JLabel title = new JLabel("Week Calculator");
    JLabel start = new JLabel("Start: ");
    JLabel end = new JLabel("End: ");
    JPanel titleBar = new JPanel();
    JPanel panel = new JPanel();
    //Jpanel endpanel = new Jpanel();
    JSpinner years = new JSpinner();
    JComboBox months = new JComboBox(new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"});
    JComboBox dayList = new JComboBox(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,});
    JSpinner years2 = new JSpinner();
    JComboBox months2 = new JComboBox(new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"});
    JComboBox dayList2 = new JComboBox(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,});    
    Calendar cal = Calendar.getInstance();
    JPanel submitPane = new JPanel();
    JPanel workArea = new JPanel();
    JButton submit = new JButton(" Submit ");
    JTextField res = new JTextField("0 weeks",15);
    public ComWeekmanager() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        
        gui.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-100);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Weeks Calculator");
        gui.setLayout(new BorderLayout());
        title.setFont(new Font("consolas",Font.BOLD,20));
        titleBar.setLayout(new FlowLayout(FlowLayout.CENTER,5,35));
        titleBar.add(title);
        gui.add(titleBar,BorderLayout.NORTH);
        panel.setLayout(new GridLayout(2,4,50,50));
        panel.add(start);
        panel.add(years);
        panel.add(months);
        panel.add(dayList);
        panel.add(end);
        panel.add(years2);
        panel.add(months2);
        panel.add(dayList2);
        years.setValue(cal.get(Calendar.YEAR));
        years2.setValue(cal.get(Calendar.YEAR));
        workArea.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        workArea.add(panel);
        submitPane.add(submit);
        submitPane.add(res);
        res.setEditable(false);
        res.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        submitPane.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
        gui.add(workArea);
        gui.add(submitPane,BorderLayout.SOUTH);
        submit.addActionListener((ActionEvent e) -> {
             convert();
        });
        for(Component c:panel.getComponents()) {                                   
                c.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyChar()=='\n') {
                        convert();
                    }
                }
                
            });
        }
    }
    public static void main(String[] args)  {
        var week = new ComWeekmanager();
    }   

    public  void convert() {
         try {
                res.setText(WeekGetter.getWeeks(new int[] {(int)years.getValue(),months.getSelectedIndex(),(int)dayList.getSelectedItem()}, new int[]{(int)years2.getValue(),months2.getSelectedIndex(),(int)dayList2.getSelectedItem()})+" weeks     ");
            } catch (Exception ex) {
                res.setText(" Out of range");
            }

    }
}
