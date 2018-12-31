/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllPanels;

import GameModel.Indeces;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author skerd
 */
public class selectLevelPanel extends javax.swing.JPanel {

    private int boardType;
    /**
     * Creates new form selectLevelPanel
     */
    public selectLevelPanel() {
        initComponents();
        
        ActionListener btns = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String btnName =  ((JButton) e.getSource() ).getText() ;
                    System.out.println("Clicked on normal: " +  ( (JButton) e.getSource() ).getText() );
                    
                   
                if( ((JButton) e.getSource() ).getBackground() == Color.GREEN || ((JButton) e.getSource() ).getBackground() == Color.PINK){
                    System.out.println( ((JButton) e.getSource() ).getBackground() );

                    JFrame frame = new JFrame();
                    Object[] options = {"Yes, replay",
                        "Go Back"};
                    int n = JOptionPane.showOptionDialog(frame,
                        "Do you want to replay the level?",
                        "Replay?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,     //do not use a custom Icon
                        options,  //the titles of buttons
                        options[0]); //default button title

                    System.out.println(n);

                    if( n == 0){
                        System.out.println("Quitting");
                        cs319.main.window.getContentPane().removeAll();

                        Generated.allGamesPanelHere game = null;

                        if( ((JButton) e.getSource() ).getBackground() == Color.GREEN   )
                            game = new Generated.allGamesPanelHere(11,5,0, Indeces.normalTileGame, btnName.substring(1) );
                        else
                            game = new Generated.allGamesPanelHere(11,5,1, Indeces.diamondTileGame, btnName.substring(1)  );
                        cs319.main.window.add(game);
                        cs319.main.window.revalidate();
                        cs319.main.window.repaint();  
                    }
                    else{
                        System.out.println("Continue");
                    }

                }
                else if( ((JButton) e.getSource() ).getBackground() == Color.RED || ((JButton) e.getSource() ).getBackground() == Color.MAGENTA){
                    System.out.println("Clicked on diamond: " +  ( (JButton) e.getSource() ).getText() );
                    
                    cs319.main.window.getContentPane().removeAll();
                   
                    Generated.allGamesPanelHere game = null;
                            
                    if( ((JButton) e.getSource() ).getBackground() == Color.RED   )
                        game = new Generated.allGamesPanelHere(11,5,0, Indeces.normalTileGame, btnName.substring(1) );
                    else
                        game = new Generated.allGamesPanelHere(11,5,1, Indeces.diamondTileGame, btnName.substring(1));

                    
                    cs319.main.window.add(game);
                    cs319.main.window.revalidate();
                    cs319.main.window.repaint();
                    
                }
               
                              
            }
            
        };
        
        
        
    try{
        
        File file = new File("Levels/board1LevelStatus.txt"); 
        @SuppressWarnings("resource")
        BufferedReader level = new BufferedReader(new FileReader(file)); 

        String line; 
        int btnWidth  = 170;
        int btnHeight = 170;
        int count = 1;
        
        while ((line = level.readLine()) != null) {
            JButton btn;
            if( line.substring(line.indexOf(" ")+1).equals("1")){
                btn = new JButton( "N" + line.substring(0, line.indexOf(" ")) );
                btn.setBackground(Color.GREEN);
                btn.setBounds(btnWidth, btnHeight, 120, 50);
                this.add(btn);
                btn.addActionListener(btns);
            }
            else{
                btn = new JButton( "N" + line.substring(0, line.indexOf(" ")) );
                btn.setBackground(Color.RED);
                btn.setBounds(btnWidth, btnHeight, 120, 50);
                this.add(btn);
                btn.addActionListener(btns);
            }
            
            if( count >6){
                btn.setEnabled(false);
                btn.setBackground(Color.GRAY);
            }
            
            btnWidth +=150;
            
            if( count == 6){
                btnHeight += 70;
                btnWidth = 170;
            }
            
            count++;
            
            

            System.out.println(line); 
        }
        
        
        btnWidth  = 170;
        btnHeight += 180;
        count = 1;
        
        file = new File("Levels/board2LevelStatus.txt"); 
        @SuppressWarnings("resource")
        BufferedReader level1 = new BufferedReader(new FileReader(file)); 
        
        while ((line = level1.readLine()) != null) {
            JButton btn;
            if( line.substring(line.indexOf(" ")).equals("1")){
                btn = new JButton( "D" +line.substring(0, line.indexOf(" ")) );
                btn.setBackground(Color.PINK);
                this.add(btn);
                btn.addActionListener(btns);
            }
            else{
                btn = new JButton( "D" + line.substring(0, line.indexOf(" ")) );
                btn.setBackground(Color.MAGENTA);
                btn.setBounds(btnWidth, btnHeight, 120, 50);
                this.add(btn);
                btn.addActionListener(btns);
            }
            
            
            if( count >6){
                btn.setEnabled(false);
                btn.setBackground(Color.GRAY);
            }
            
            btnWidth +=150;
            
            if( count == 6){
                btnHeight += 70;
                btnWidth = 170;
            }
            
            count++;
            

            System.out.println(line); 
        }
        
        
        
        
        
    }catch(IOException e){
        e.printStackTrace();
    }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        normalBoardLabel = new javax.swing.JLabel();
        normalBoardLabel1 = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 0));

        normalBoardLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        normalBoardLabel.setForeground(new java.awt.Color(0, 0, 0));
        normalBoardLabel.setText("Normal Board Levels:");

        normalBoardLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        normalBoardLabel1.setForeground(new java.awt.Color(0, 0, 0));
        normalBoardLabel1.setText("Diamond Board Levels:");

        backBtn1.setBackground(new java.awt.Color(255, 255, 153));
        backBtn1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        backBtn1.setForeground(new java.awt.Color(255, 255, 255));
        backBtn1.setText("Back");
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(normalBoardLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(normalBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(471, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(normalBoardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216)
                .addComponent(normalBoardLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed

        cs319.main.window.getContentPane().removeAll();

        newGamePanel newGame = new newGamePanel();
        cs319.main.window.add(newGame);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();

        System.out.println("Going back to main menu");
    }//GEN-LAST:event_backBtn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private javax.swing.JLabel normalBoardLabel;
    private javax.swing.JLabel normalBoardLabel1;
    // End of variables declaration//GEN-END:variables
}
