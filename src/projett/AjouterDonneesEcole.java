/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projett;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Fabrice
 */
public class AjouterDonneesEcole extends javax.swing.JFrame {

    /**
     * Creates new form AjterEcl
     */
    public AjouterDonneesEcole() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        insertionDonneesCombox();
    }
        //Déclaration des tableaux qui contiendront les données récupérées dans le fihier excel
        ArrayList<String> entetesList = new ArrayList<>();
        ArrayList<String> nomsList = new ArrayList<>();
        ArrayList<String> postNomsList = new ArrayList<>();
        ArrayList<String> prenomList = new ArrayList<>();
        ArrayList<String> sexeList = new ArrayList<>();
        ArrayList<Integer> agesList = new ArrayList<>();
        ArrayList<Integer> classeList = new ArrayList<>();
        ArrayList<Integer> numPermanantList = new ArrayList<>();
        ArrayList<Integer> codeRecupArrayList = new ArrayList<>();
        
        
        String codeGlobaleEc;
        String ecoleNom;
        Integer ecoleCode ;
        Integer RegionCode;
        //Model du tablea d'affichage des informations lorsqu'on choisi le fichier
        
        String element[] = {"Nom", "Post-Nom", "Prenom", "Sexe", "age", "Classe", "Numero permanant"};
        String[] ligne = new String[7];
        DefaultTableModel model = new DefaultTableModel(null, element);
        
        int ec = 0; 
        
        void insertionDonneesCombox(){
            
            try{
                Statement stm = connection.connectbd().createStatement();
                String requete = "SELECT * FROM region";
                ResultSet result = stm.executeQuery(requete);
                
                while(result.next()){
                   listeRegions.addItem("Code : " + result.getString("codeRegion") + " || Nom: " + result.getString("nomRegion"));
                   codeRecupArrayList.add(result.getInt("codeRegion"));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AjouterDonneesEcole.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
                
        public int  verifierDonnees(){

            try { 
                
                Statement stm = connection.connectbd().createStatement();
               

                String requete = "SELECT * FROM ecole";
                
                
                ResultSet result = stm.executeQuery(requete);
           
                //on vérifie si l'école n'existe pas déjà dans la base de données
                
               ;
                ArrayList<Integer> codeDatabase = new ArrayList<>(); 
                while(result.next()){
                    Integer codes = Integer.parseInt(result.getString("codeEcole"));
                    codeDatabase.add(codes); 
                    
                }
                
                if(codeDatabase.contains(ecoleCode)){
                   JOptionPane.showMessageDialog(null, "L'école saisie existe déjà");
                   
                } else if (ec == 0){
                    JOptionPane.showMessageDialog(null, "Veuillez Choisir une région");
                    return  1;
                } 
                return  0;
                 
            } catch (Exception e) {
                 return  1;
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

        FentreG = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        choiseFileBtn = new javax.swing.JButton();
        nomEcole = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codeEcole = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        afficheSchoolDataTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        nombreEleves = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        listeRegions = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FentreG.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setBackground(new java.awt.Color(178, 235, 242));
        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Ajouter les données globales d'une école");

        choiseFileBtn.setBackground(new java.awt.Color(204, 255, 204));
        choiseFileBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        choiseFileBtn.setText("Choisir le fichier excel ");
        choiseFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiseFileBtnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(178, 235, 242));
        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setText("Données des élèves");

        jLabel3.setBackground(new java.awt.Color(178, 235, 242));
        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setText("Nom de l'école ");

        jLabel4.setBackground(new java.awt.Color(178, 235, 242));
        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel4.setText("Code de l'écode");

        jLabel5.setBackground(new java.awt.Color(178, 235, 242));
        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel5.setText("Code de la région");

        codeEcole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeEcoleActionPerformed(evt);
            }
        });

        afficheSchoolDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Post -Nom", "Prenom", "Sexe", "age", "Classe", "Numero permanant"
            }
        ));
        afficheSchoolDataTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(afficheSchoolDataTable);

        jLabel6.setBackground(new java.awt.Color(178, 235, 242));
        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel6.setText("Nombre d'élèves");

        nombreEleves.setText("0");

        addBtn.setBackground(new java.awt.Color(0, 255, 0));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addBtn.setText("Ajouter");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        listeRegions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeRegionsActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projett/courbe-de-la-fleche-de-retour-pointant-vers-la-gauche.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FentreGLayout = new javax.swing.GroupLayout(FentreG);
        FentreG.setLayout(FentreGLayout);
        FentreGLayout.setHorizontalGroup(
            FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(FentreGLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(nomEcole)
                    .addComponent(jLabel5)
                    .addComponent(listeRegions, 0, 204, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiseFileBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(codeEcole, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreEleves, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FentreGLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        FentreGLayout.setVerticalGroup(
            FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FentreGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(34, 34, 34)
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomEcole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codeEcole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreEleves, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addBtn)
                    .addGroup(FentreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(choiseFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listeRegions)))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FentreG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FentreG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choiseFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiseFileBtnActionPerformed
        
         
        //ouveture du fichier
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setDialogTitle("Choisir le ficheir");
        openFileChooser.removeChoosableFileFilter(openFileChooser.getFileFilter());
        FileFilter filter = new FileNameExtensionFilter("Excel File(.xlsx)", "xlsx");
        openFileChooser.setFileFilter(filter);
        
          if(openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File inputFile = openFileChooser.getSelectedFile();
            try (FileInputStream in = new FileInputStream(inputFile)) {
                    XSSFWorkbook importedFile = new XSSFWorkbook(in);
                    XSSFSheet sheet1 = importedFile.getSheetAt(0); 
                    
                    Iterator<Row> rowIterator = sheet1.rowIterator();
                    while (rowIterator.hasNext()){
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                        while (cellIterator.hasNext()){
                            Cell cell = cellIterator.next();
                            if(row.getRowNum() == 0){
                                entetesList.add(cell.getStringCellValue());
                            } else {
                                if (cell.getColumnIndex() == 0) {
                                    nomsList.add(cell.getStringCellValue());
                                } else  if (cell.getColumnIndex() == 1 ){
                                    postNomsList.add(cell.getStringCellValue());
                                }else  if (cell.getColumnIndex() == 2 ){
                                    prenomList.add(cell.getStringCellValue());
                                }else  if (cell.getColumnIndex() == 3 ){
                                    sexeList.add(cell.getStringCellValue());
                                }else  if (cell.getColumnIndex() == 4 ){
                                    agesList.add((int)cell.getNumericCellValue());
                                }else  if (cell.getColumnIndex() == 5 ){
                                    classeList.add((int)cell.getNumericCellValue());
                                }else  if (cell.getColumnIndex() == 6 ){
                                    numPermanantList.add((int)cell.getNumericCellValue());
                                }
                            }
                        }
                        
                    }
                    in.close();
                    int nombresElevesEcole = nomsList.size();
                    nombreEleves.setText(String.valueOf(nombresElevesEcole));
        
                
                    
                    
                    int max = nomsList.size(); 
                    for (int i = 0; i<max - 1; i++){
                        ligne[0] = nomsList.get(i); 
                        ligne[1] = postNomsList.get(i);
                        ligne[2] = prenomList.get(i);
                        ligne[3] = sexeList.get(i);
                        ligne[4] = agesList.get(i).toString();
                        ligne[5] = classeList.get(i).toString();
                        ligne[6] = numPermanantList.get(i).toString();
                        
                        model.addRow(ligne);
                        
                    }
                    afficheSchoolDataTable.setModel(model);
                    
                    
                     
                    
            } catch (Exception e) {
                Logger.getLogger(AjouterDonneesEcole.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
    }//GEN-LAST:event_choiseFileBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int max = nomsList.size();
        if(nomEcole.getText().isEmpty() || codeEcole.getText().isEmpty() || Integer.parseInt(this.codeEcole.getText()) == 0 ){
           JOptionPane.showMessageDialog(null, "Veuillez remplir les champs et/eu denner des valeurs supérieurs à 0"); 
        } else {
            ecoleNom = nomEcole.getText();
           
            ecoleCode = Integer.parseInt(this.codeEcole.getText());
            //klezfkjnkzejl
            if(verifierDonnees() == 0){
                try {
               
                    
                         Statement stm = connection.connectbd().createStatement();
                        
                         String requete = "SELECT * FROM eleve";
                         ResultSet result = stm.executeQuery(requete);
                
                        //on vérifie si l'élève n'existe pas déjà dans la base de données
                        ArrayList<Integer> numeroPermanant = new ArrayList<>();
                        while(result.next()){
                            Integer numPerma = Integer.parseInt(result.getString("numeroPermanant"));
                            numeroPermanant.add(numPerma); 
                        }
                        
                    for (int i = 0; i < max; i++) {
                       if(!numeroPermanant.isEmpty() && numeroPermanant.contains(numeroPermanant.get(i))){
                        JOptionPane.showMessageDialog(null, "L'élève " + nomsList.get(i) +  " " + postNomsList.get(i)  + " "+ prenomList.get(i) + " déjà");
                        } else{ 
                            Statement requetStatement = connection.connectbd().createStatement();
                            String commandesSql = "insert into eleve(nom, postNom, prenom, sexe, age, classe, codeEcole, numeroPermanant)" +
                            "Values('" + nomsList.get(i) + "', '" + postNomsList.get(i)+ "', '" +
                            prenomList.get(i) + "',  '" + sexeList.get(i) + "',  '" + agesList.get(i) + 
                            "' ,'" + classeList.get(i) + "', '" + ecoleCode +  "' ,'" + numPermanantList.get(i) + "')";
                            requetStatement.executeUpdate(commandesSql);     
                    }
                        if( i == max -1){
                            JOptionPane.showMessageDialog(null, "Insertion réussie");
                        } 
                }  
                        
                
                           
                
             } catch (SQLException ex) {
                Logger.getLogger(AjouterDonneesEcole.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Statement requetStatement;
            try {
                requetStatement = connection.connectbd().createStatement();
                
                if (max == 0){
                    JOptionPane.showMessageDialog(null, "Veuillez choisir une fichier de donnée");
                } else if (ecoleNom.isEmpty() || ecoleCode == null  || ecoleCode == 0 || RegionCode == null || ecoleCode == 0 ){
                    JOptionPane.showMessageDialog(null, "Veuillez Reseigner des valeurs correctes");
                } else {
                    String commandesSql = "insert into ecole(nomEcole, nombreEleves, codeEcole, codeRegion)" +
                        "Values('" + ecoleNom + "', '" + max + "', '" +
                        ecoleCode + "',  '" + RegionCode  +"')";
                        requetStatement.executeUpdate(commandesSql);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AjouterDonneesEcole.class.getName()).log(Level.SEVERE, null, ex);
            }
           }else if (verifierDonnees() == 1){
               JOptionPane.showMessageDialog(null, "Veuillez recommencer");
           }
            
            
            
         
    
        
        }
           
    }//GEN-LAST:event_addBtnActionPerformed

    private void listeRegionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeRegionsActionPerformed
        
        
       if (!codeRecupArrayList.isEmpty()){
           RegionCode =  codeRecupArrayList.get(listeRegions.getSelectedIndex());
          // codeGlobaleEc = String.copyValueOf(codeRecupArrayList.get(listeRegions.getSelectedIndex()));
           ec = 1;   
       }
        
                
    }//GEN-LAST:event_listeRegionsActionPerformed

    private void codeEcoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeEcoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEcoleActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
        Accueil accueil = new  Accueil();
        accueil.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjouterDonneesEcole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterDonneesEcole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterDonneesEcole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterDonneesEcole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterDonneesEcole().setVisible(true);
            }
        });
      
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FentreG;
    private javax.swing.JButton addBtn;
    private javax.swing.JTable afficheSchoolDataTable;
    private javax.swing.JButton choiseFileBtn;
    private javax.swing.JTextField codeEcole;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listeRegions;
    private javax.swing.JTextField nomEcole;
    private javax.swing.JLabel nombreEleves;
    // End of variables declaration//GEN-END:variables
}
