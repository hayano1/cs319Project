/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllPanels;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author skerd
 */
public class optionsPanel extends javax.swing.JPanel {

    /**
     * Creates new form optionsPanel
     */
    public optionsPanel() {
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

        volumeLabel = new javax.swing.JLabel();
        musicLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        backBtn = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        musicBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 0));

        volumeLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        volumeLabel.setForeground(new java.awt.Color(0, 0, 0));
        volumeLabel.setText("Volume");

        musicLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        musicLabel1.setForeground(new java.awt.Color(0, 0, 0));
        musicLabel1.setText("Music");

        jSlider1.setBackground(new java.awt.Color(255, 255, 0));

        backBtn.setBackground(new java.awt.Color(255, 255, 153));
        backBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        ImageIcon icooon = new ImageIcon("Pictures/logo2.jpg");

        logoLabel.setIcon(icooon);

        musicBtn.setText("Off");
        musicBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(469, 469, 469)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(439, 439, 439))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(volumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(musicLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(musicBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(371, 371, 371))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(musicLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(musicBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volumeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        cs319.main.window.getContentPane().removeAll();

        mainMenu menu = new mainMenu();
        cs319.main.window.add(menu);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();

        System.out.println("Going back to mainnnnnn menu");
    }//GEN-LAST:event_backBtnActionPerformed

    private void musicBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicBtnActionPerformed
        
        if( ((JButton)evt.getSource()).getText().equals("Off")  ){
            System.out.println("ADASDASD");
            cs319.main.MGP.stop(cs319.main.bgMusic);
        }
        
    }//GEN-LAST:event_musicBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton musicBtn;
    private javax.swing.JLabel musicLabel1;
    private javax.swing.JLabel volumeLabel;
    // End of variables declaration//GEN-END:variables
}
