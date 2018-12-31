/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllPanels;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author skerd
 */
public class storyPanel extends javax.swing.JPanel {

    /**
     * Creates new form storyPanel
     */
    
    private String storyTitleString;

    
    public storyPanel(String storyTitlee) {
        storyTitleString = storyTitlee;
        
        ArrayList<String> stories = new ArrayList<>();

        
        initComponents();
        
        
        MouseListener mss = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                if( ((JButton)e.getSource()).isEnabled() ){
                    String btnName = ((JButton)e.getSource()).getText();
                    String pic =  btnName.substring(  btnName.lastIndexOf(":")+1 ).replace(" ", "");
                    System.out.println("Hoverd over " + pic );
                    System.out.println("Stories/" + storyTitleString.replace(" ", "")  + "/" + pic + ".jpg");
                    ImageIcon icooon = new ImageIcon("Stories/" + storyTitleString.replace(" ", "")  + "/" + pic + ".jpg");

                    storyCover.setIcon(icooon);

                    storyDescription.setText( stories.get(  Integer.parseInt( pic) -1 ));

                    repaint();
                }
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ImageIcon icooon = new ImageIcon("Stories/" + storyTitleString.replace(" ", "")  + "/cover.jpg");

                storyCover.setIcon(icooon);
                storyDescription.setText(storyTitleString );
            }
            
        };
        
        ActionListener btns = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String btnName =  ((JButton) e.getSource() ).getText() ;
                
 
                if( ((JButton) e.getSource() ).getBackground() == Color.GREEN ){
                    System.out.println( ((JButton) e.getSource() ).getBackground() );

                    JFrame frame = new JFrame();
                    Object[] options = {"Yes, replay",
                        "Go Back"};
                    int n = JOptionPane.showOptionDialog(frame,
                        "Do you want to replay this chapter?",
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

                        game = new Generated.allGamesPanelHere(11,5,0, "Story", btnName.substring(1) );
                           
                        cs319.main.window.add(game);
                        cs319.main.window.revalidate();
                        cs319.main.window.repaint();  
                    }
                    else{
                        System.out.println("Continue");
                    }

                }
                else if( ((JButton) e.getSource() ).getBackground() == Color.MAGENTA ){

                    cs319.main.window.getContentPane().removeAll();
                   
                    Generated.allGamesPanelHere game = null;  
                    game = new Generated.allGamesPanelHere(11,5,0,"Story" ,"1" );
                    
                    cs319.main.window.add(game);
                    cs319.main.window.revalidate();
                    cs319.main.window.repaint();
                    
                }
               
                              
            }
            
        };
        
        
        try{
            
            File file1 = new File("Stories/" + storyTitleString.replace(" ", "")  + "/currProgress.txt"); 
            @SuppressWarnings("resource")
            BufferedReader level1 = new BufferedReader(new FileReader(file1)); 
            
            
            int currChapter = Integer.parseInt( level1.readLine() );
            int maxChapter = Integer.parseInt( level1.readLine() );
            
            File file = new File("Stories/" + storyTitleString.replace(" ", "")  + "/story.txt"); 
            @SuppressWarnings("resource")
            BufferedReader level = new BufferedReader(new FileReader(file)); 

            
            
            String line; 
            int btnWidth  = 170;
            int btnHeight = 170;
            int count = 1;

            while ((line = level.readLine()) != null) {
                JButton btn;

                btn = new JButton( "Chapter: " + count );
                btn.setBackground(Color.MAGENTA);
                btnPanel.add(btn);
                btn.addActionListener(btns);
                btn.addMouseListener(mss);

                if( count < currChapter){
                    btn.setBackground(Color.GREEN);
                }

                if( count > maxChapter){
                    btn.setEnabled(false);
                    btn.setBackground(Color.GRAY);
                }
                
                btn.setBounds(btnWidth, btnHeight, 120, 50);

                btnWidth +=150;

                if( count % 3 == 0){
                    btnHeight += 70;
                    btnWidth = 170;
                }

                count++;

                stories.add(line);
                System.out.println(line);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
                
        
        ImageIcon icooon = new ImageIcon("Stories/" + storyTitleString.replace(" ", "")  + "/cover.jpg");

        storyCover.setIcon(icooon);
        
        storyTitle.setText(storyTitleString);
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        storyCover = new javax.swing.JLabel();
        asdfasdf = new javax.swing.JScrollPane();
        storyDescription = new javax.swing.JTextPane();
        btnPanel = new javax.swing.JPanel();
        storyTitle = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 0));
        setForeground(new java.awt.Color(255, 255, 0));

        jPanel1.setMaximumSize(new java.awt.Dimension(453, 619));
        jPanel1.setMinimumSize(new java.awt.Dimension(453, 619));

        storyCover.setMaximumSize(new java.awt.Dimension(340, 316));
        storyCover.setMinimumSize(new java.awt.Dimension(340, 316));

        storyDescription.setEditable(false);
        storyDescription.setContentType("text/html\n"); // NOI18N
        asdfasdf.setViewportView(storyDescription);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(asdfasdf, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(storyCover, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(storyCover, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(asdfasdf, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPanel.setBackground(new java.awt.Color(255, 255, 0));

        storyTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        storyTitle.setForeground(new java.awt.Color(0, 0, 0));
        storyTitle.setText("jLabel1");

        backBtn1.setBackground(new java.awt.Color(255, 255, 153));
        backBtn1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        backBtn1.setForeground(new java.awt.Color(255, 255, 255));
        backBtn1.setText("Back");
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(storyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(storyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed

        cs319.main.window.getContentPane().removeAll();

        allStorisPanel newGame = new allStorisPanel();
        cs319.main.window.add(newGame);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();

        System.out.println("Going back to main menu");
    }//GEN-LAST:event_backBtn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane asdfasdf;
    private javax.swing.JButton backBtn1;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel storyCover;
    private javax.swing.JTextPane storyDescription;
    private javax.swing.JLabel storyTitle;
    // End of variables declaration//GEN-END:variables
}
