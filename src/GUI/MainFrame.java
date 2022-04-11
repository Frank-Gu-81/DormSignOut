package GUI;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import GUI.StudentIDConfirm;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import dormsignout.Student;
import dormsignout.SignOutInfo;
import StaticClasses.InfoTableModel;
import javax.swing.JTable;
import java.io.File;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frank
 */
public class MainFrame extends javax.swing.JFrame {
    public static String[] studentData=new String[2];
    public static boolean isClicked=false;
    public static HashMap<String, String> studentVerification = new HashMap<String, String>();
    public String filePath;
    private ArrayList<SignOutInfo> students;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        students = new ArrayList<>();
    }
    
    /**
     * @features
     * 1. keep track of personal information
     *      sign out times
     *      whom are they usually going with
     *      where do they go often
     * 
     * @Main
     * after signOut button is clicked, the window changes to StudentIDConfirm
     * @StudentIDConfirm
     * StudentIDConfirm needs to have a method of importing new data(files)
     * After checkBotton is hit, check if the id is valid
     * if(valid)
     * {
     *      ask user to check whether their information is correct;
     *      if(correctInfo)
     *      {
     *          goes to SignOutPanel;
     *      }
     * }
     * else
     * {
     *      pop back to MainFrame;
     * }
     * @SignOutPanel
     * By using setter methods, all the information will be stored in SignOutInfo class
     * if(Submit Button is hit)
     * {
     *      upload it to email?
     *      //method
     *      refreshFrame;
     *      the window goes back to MainFrame
     * }
     */
    
    //6/2 new added
    private void editReturnTime(int student) {
        String estimateReturnTime = JOptionPane.showInputDialog(this,"Please enter new estimate return time for \n"
            + students.get(student).getStudentInfo().getFirstName() + ""
            + students.get(student).getStudentInfo().getLastName() + "");
        students.get(student).setTimeBack(estimateReturnTime);
        refreshPanels();
//        if (game >= 0) {
//            int newGoals = Integer.parseInt(
//                    JOptionPane.showInputDialog(this, "Enter goals scored\n"
//                    + "for " + players.get(athlete).getFirstName() + " "
//                    + players.get(athlete).getLastName(), players.get(athlete).getGoals(game)));
//
//            players.get(athlete).setGoals(game, newGoals);
//            refreshPanels();
//        }
    }
    
    public void load(String filePath) {
        
        // Reset data to allow data from file to populate data types
        
        try {
            // Load file and read info to RAM from file
            BufferedReader loadFile = new BufferedReader(new FileReader(
                    filePath));

            // Create a string to read in data from the file
            String input;
            
            
            Student cur;
            while ((input = loadFile.readLine()) != null) {
                String[] values = input.split(",");
                
                String firstName = values[0];
                String lastName = values[1];
                String id = values[2];
                String dorm = values[3];
                
                cur = new Student(firstName, lastName, id, dorm);
                
                while((input = loadFile.readLine()) != null && !(input.substring(0,2).equals("~~")))
                {
                    values = input.split(",");
                    
                    String placeGoing = values[0];
                    String goingWith = values[1];
                    String timeLeaving = values[2];
                    String timeBack = values[3];
                    String date = values[4];
                    String teacher = values[5];
                    String isBack = values[6];
                    //cur.addSignOut();
                    students.add(new SignOutInfo(goingWith, placeGoing, teacher, timeLeaving, timeBack, isBack, date, cur));
                    
                }
                
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error trying to "
                    + "load file: " + ex,
                    "Load Error",
                    JOptionPane.ERROR_MESSAGE);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        mainPanel = new javax.swing.JPanel();
        whoIsOutTable = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        signInButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        importNamesMenuItem = new javax.swing.JMenuItem();
        saveAsItem = new javax.swing.JMenuItem();
        SignOutHistory = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        editNames = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Leaving Time", "Estimate Return"
            }
        ));
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentTableMouseClicked(evt);
            }
        });
        whoIsOutTable.setViewportView(StudentTable);

        signInButton.setText("Sign In");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        signOutButton.setText("Sign Out");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(signInButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signOutButton)
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(whoIsOutTable, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(whoIsOutTable, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInButton)
                    .addComponent(signOutButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        fileMenu.setText("File");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        importNamesMenuItem.setText("Import names");
        importNamesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importNamesMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(importNamesMenuItem);

        saveAsItem.setText("Save as...");
        saveAsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsItem);

        SignOutHistory.setText("Sign Out History");
        SignOutHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutHistoryActionPerformed(evt);
            }
        });
        fileMenu.add(SignOutHistory);

        jMenuBar1.add(fileMenu);

        edit.setText("Edit");

        editNames.setText("Edit Names");
        editNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNamesActionPerformed(evt);
            }
        });
        edit.add(editNames);

        jMenuBar1.add(edit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        int index = StudentTable.getSelectedRow();
        studentSignIn(index);
        refreshPanels();
    }//GEN-LAST:event_signInButtonActionPerformed

    public void studentSignIn(int index) {
        students.remove(index);
    }
    
    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
        JDialog dialog = new JDialog(this, true);
//        dialog.add(new StudentIDConfirm());
        dialog.add(new SignOutPanel(this));
        dialog.pack();
        dialog.setVisible(true);       
        // TODO add your handling code here:
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileMenuActionPerformed

    private void importNamesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importNamesMenuItemActionPerformed
        // after clicking file, goes to directory
//        String dir = System.getProperty("user.dir");
//        dir += "StudentInfo.txt";
//        
//        load(dir);
        JDialog dialog = new JDialog(this, true);
        dialog.add(new ImportPanel(this));
        dialog.pack();
        dialog.setVisible(true);
        
        refreshPanels();
        // TODO add your handling code here:
    }//GEN-LAST:event_importNamesMenuItemActionPerformed

    public void refreshPanels() {
        drawMainPanel();
        //drawGoalPanel();
    }
    
    private void drawMainPanel() {
        // Get Roster Header
        String[] studentsHeader = {
            "First Name", "Last Name", "Leaving Time", "Estimate Return"
        };
        
//        System.out.println(studentsHeader.length);
//        System.out.println("~~~");
//        System.out.println(students.size());
//        System.out.println("~~~");
        // Get data for table
        String[][] signOutData = new String[students.size()][studentsHeader.length];
        // Populate table with data
        for (int x = 0; x < signOutData.length; x++) {
            // Athlete Info
            signOutData[x][0] = students.get(x).getStudentInfo().getFirstName();
            signOutData[x][1] = students.get(x).getStudentInfo().getLastName();
            signOutData[x][2] = students.get(x).getTimeLeaving();
            signOutData[x][3] = students.get(x).getTimeBack();
        }

        // Create JTable with all our data
        StudentTable.setModel(new InfoTableModel(signOutData, studentsHeader));

        StudentTable.getColumnModel().getColumn(0).setMinWidth(100);
        StudentTable.getColumnModel().getColumn(1).setMinWidth(25);
        StudentTable.getColumnModel().getColumn(2).setMinWidth(100);
    }
    
    public void addStudent(String friends, String location, String teacher, String timeLeaving, String timeBack, String isBack, String date, Student studentInfo) {
        students.add(new SignOutInfo(friends, location, teacher, timeLeaving, timeBack, isBack, date, studentInfo));
    }
    
    private void editNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editNamesActionPerformed

    private void saveAsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsItemActionPerformed
        JDialog dialog = new JDialog(this, true);
        dialog.add(new SavePanel(this));
        dialog.pack();
        dialog.setVisible(true);
        save();

        saveAsItem.setEnabled(true); 
        refreshPanels();
    }//GEN-LAST:event_saveAsItemActionPerformed

    private void SignOutHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOutHistoryActionPerformed

        JDialog dialog = new JDialog(this, true);
        dialog.add(new SearchHistory());
        dialog.pack();
        dialog.setVisible(true);
        
        refreshPanels();
        
    }//GEN-LAST:event_SignOutHistoryActionPerformed

    private void StudentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMouseClicked
//oringinal version
//        if (evt.getClickCount() > 1) {
//            JDialog dialog = new JDialog(this, true);
//            dialog.add(new PersonHistory());
//            dialog.pack();
//            dialog.setVisible(true);
//        }
        if (evt.getClickCount() > 1) {
            int student = StudentTable.getSelectedRow();
            //int type = StudentTable.getSelectedColumn();

            editReturnTime(student);
        }
    }//GEN-LAST:event_StudentTableMouseClicked

    public void save() {
        // Output the numbers to a text file
        try {            
            PrintWriter writer = new PrintWriter(new File(filePath));
            //writer.println(numGames);

            // Write the number of games to the file
            //writer.println(numGames);
            
            // Loop through players and write their information to the file
            // Names on the first line, goals on the second line
            for (int n = 0; n < students.size(); n++) {
                writer.println(students.get(n).getStudentInfo().getFirstName() + ","
                        + students.get(n).getStudentInfo().getLastName() + ","
                        + students.get(n).getStudentInfo().getStudentID() + ","
                        + students.get(n).getStudentInfo().getDorm());
                        
                writer.println(
                        students.get(n).getLocation() + ","
                        + students.get(n).getFriends() + ","
                        + students.get(n).getTimeLeaving() + ","
                        + students.get(n).getTimeBack() + ","
                        + students.get(n).getDate() + ","
                        + students.get(n).getTeacher() + ","
                        + students.get(n).backOrNot());
//                for (int g = 0; g < students.size(); g++) {
//                    writer.print(players.get(n).getGoals(g) + ",");
//                }
                writer.println("~~");
                writer.println();
            }

            writer.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error trying to load file: " + ex,
                    "Load Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //new added
        studentVerification.put("20111", "Anna");
        studentVerification.put("20222", "Bob");
        studentVerification.put("20333", "Cathy");
        studentVerification.put("20444", "Doris");
        studentVerification.put("20555", "Emma");
        studentVerification.put("21186", "Frank");
        studentVerification.put("20777", "Grace");
        studentVerification.put("20888", "Hathaway");
        studentVerification.put("20999", "Irine");
        studentVerification.put("20266", "Carolyn");
        studentVerification.put("20121", "Katie");
        //new added end here
        
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //new added
        studentData[0]="";
        studentData[1]="";
        JFrame frame = new JFrame("Student Login");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
        while(!isClicked){
                frame.setSize(350, 200);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(studentVerification.get(studentData[0])==null){
                    JFrame f=new JFrame();  
                    JOptionPane.showMessageDialog(f,"No such student.");  
                    frame.dispose();
                }
                else{
                    frame.dispose();
                    new MainFrame().setVisible(true);
                }
                
            }
        });
        //new added end here
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    // new added
    private static String[] placeComponents(JPanel panel) {
        String[] result=new String[2];
        result[0]="";
        result[1]="";
        panel.setLayout(null);
        JLabel userLabel = new JLabel("Name:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);
        JLabel studentIDLabel = new JLabel("Student ID:");
        studentIDLabel.setBounds(10,50,80,25);
        panel.add(studentIDLabel);
        JTextField studentIDText = new JTextField(20);
        studentIDText.setBounds(100,50,165,25);
        panel.add(studentIDText);
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
         String name=userText.getText();
         String ID=studentIDText.getText();
         result[0]=ID;
         result[1]=name;
         studentData=result;
         isClicked=true;
        }
    });
    return result;
    }
    //new added end here

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem SignOutHistory;
    private javax.swing.JTable StudentTable;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem editNames;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem importNamesMenuItem;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem saveAsItem;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signOutButton;
    private javax.swing.JScrollPane whoIsOutTable;
    // End of variables declaration//GEN-END:variables
}
