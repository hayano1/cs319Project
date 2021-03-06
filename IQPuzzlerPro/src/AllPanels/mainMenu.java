/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllPanels;

import cs319.main;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author skerd
 */
public class mainMenu extends javax.swing.JPanel {

    /**
     * Creates new form mainMenu
     */
    public mainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionsBtn = new javax.swing.JButton();
        creditsBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        optionsBtn.setBackground(new java.awt.Color(255, 255, 153));
        optionsBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        optionsBtn.setForeground(new java.awt.Color(255, 255, 255));
        optionsBtn.setText("Options");
        optionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsBtnActionPerformed(evt);
            }
        });

        creditsBtn.setBackground(new java.awt.Color(255, 255, 153));
        creditsBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        creditsBtn.setForeground(new java.awt.Color(255, 255, 255));
        creditsBtn.setText("Credits");
        creditsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsBtnActionPerformed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 153));
        exitBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        playBtn.setBackground(new java.awt.Color(255, 255, 153));
        playBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        playBtn.setForeground(new java.awt.Color(255, 255, 255));
        playBtn.setText("Play");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });

        ImageIcon icooon = new ImageIcon("Pictures/logo2.jpg");

        logoLabel.setIcon(icooon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optionsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creditsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap(485, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void creditsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsBtnActionPerformed

        System.out.println("Credits");
        cs319.main.window.getContentPane().removeAll();

        creditsPanel credits = new creditsPanel();
        cs319.main.window.add(credits);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();

    }//GEN-LAST:event_creditsBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        Object[] options = {"Quit playing",
            "Continue!"};
        int n = JOptionPane.showOptionDialog(frame,
            "Do you want to close the game?",
            "Quit playing?",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[1]); //default button title

        System.out.println(n);

        if( n == 0){
            System.out.println("Quitting");
            //this.dispose();
            System.exit(0);
        }
        else{
            System.out.println("Continue");
        }

    }//GEN-LAST:event_exitBtnActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        // TODO add your handling code here:
       cs319.main.window.getContentPane().removeAll();
        
        playPanel play = new playPanel();
        cs319.main.window.add(play);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();
        
        System.out.println("Opening play panel");
    }//GEN-LAST:event_playBtnActionPerformed

    private void optionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsBtnActionPerformed
        
        cs319.main.window.getContentPane().removeAll();
        
        optionsPanel options = new optionsPanel();
        cs319.main.window.add(options);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();
        
        System.out.println("Opening options menu");
            
                
    }//GEN-LAST:event_optionsBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creditsBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton optionsBtn;
    private javax.swing.JButton playBtn;
    // End of variables declaration//GEN-END:variables
}
