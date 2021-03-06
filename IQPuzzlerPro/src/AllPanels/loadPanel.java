/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllPanels;

import GameModel.GameSession;
import GameModel.Indeces;
import Generated.allGamesPanelHere;
import java.io.File;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skerd
 */
public class loadPanel extends javax.swing.JPanel {

    /**
     * Creates new form loadPanel
     */
    
    private String loadedLevel = "";
    
    public loadPanel() {
        initComponents();
        
        
        
        DefaultTableModel defTable = new DefaultTableModel() {
			private static final long serialVersionUID = -2333112545169239462L;
			
  		};

        Vector<String> columnNames = new Vector<String>(1,1);
  		       columnNames.add("Game");
        
        defTable.setColumnIdentifiers( columnNames );
        
        loadGameTable.setModel(defTable);
        
        
        
        
        int nrOfFiles = new File("SavedGames").listFiles().length;
        System.out.println(nrOfFiles  + " nr of files");
        
        Object[] allSavedGames =  new String[nrOfFiles];
        
        File folder = new File("SavedGames");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            System.out.println("File " + listOfFiles[i].getName());
            
            allSavedGames[i] = listOfFiles[i].getName();
            defTable.addRow(new Object[] { listOfFiles[i].getName() });
            
          }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        loadGameTable = new javax.swing.JTable();
        loadLabel = new javax.swing.JLabel();
        backToPlay = new javax.swing.JButton();
        loadGameBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 0));

        loadGameTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadGameTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(loadGameTable);

        loadLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        loadLabel.setForeground(new java.awt.Color(0, 0, 0));
        loadLabel.setText("Choose Game To Load:");

        backToPlay.setBackground(new java.awt.Color(255, 255, 153));
        backToPlay.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        backToPlay.setText("Back");
        backToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToPlayActionPerformed(evt);
            }
        });

        loadGameBtn.setBackground(new java.awt.Color(255, 255, 153));
        loadGameBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        loadGameBtn.setText("Load");
        loadGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(370, 370, 370))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(446, 446, 446))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loadGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backToPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(450, 450, 450))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(loadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loadGameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backToPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToPlayActionPerformed
        
        
        cs319.main.window.getContentPane().removeAll();

        playPanel play = new playPanel();
        cs319.main.window.add(play);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();

        System.out.println("Going back to play menu");     
          
    }//GEN-LAST:event_backToPlayActionPerformed

    private void loadGameTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadGameTableMouseClicked
        // TODO add your handling code here:
        int row = loadGameTable.getSelectedRow();
        String value = loadGameTable.getModel().getValueAt(row, 0).toString();
        
        System.out.println(value);
        loadedLevel = value;
    }//GEN-LAST:event_loadGameTableMouseClicked

    private void loadGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameBtnActionPerformed
        
        cs319.main.window.getContentPane().removeAll();
        
        
        int i = loadedLevel.indexOf("~")+1;
        int j = loadedLevel.lastIndexOf(".txt") ; 
        

        int tileType = Integer.parseInt( loadedLevel.substring( i,j ) );
        
        System.out.println(loadedLevel + " i: " + i + "  j: " + j);
        
        allGamesPanelHere play = new allGamesPanelHere(11, 5, tileType, Indeces.savedGame ,loadedLevel.substring(0, loadedLevel.lastIndexOf(".txt")));
                
        cs319.main.window.add(play);
        cs319.main.window.revalidate();
        cs319.main.window.repaint();

        System.out.println("Going back to play menu");
    }//GEN-LAST:event_loadGameBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToPlay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadGameBtn;
    private javax.swing.JTable loadGameTable;
    private javax.swing.JLabel loadLabel;
    // End of variables declaration//GEN-END:variables
}
