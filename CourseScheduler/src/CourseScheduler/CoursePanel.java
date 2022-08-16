/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseScheduler;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Roshan
 */
public class CoursePanel extends javax.swing.JLayeredPane {
    // Declaring a new Color object
    Color initialBoxColor; 
    
    // Code for drag-and-drop from class
    private Point mouseWBox;
    private Course inputCourse;
    
    /**
     * Constructor for the CoursePanel object, which displays the data about each course
     * @param inputCourse 
     */
    public CoursePanel(Course inputCourse) {
        this.inputCourse = inputCourse;
        initComponents();
        this.setOpaque(true);
        initialBoxColor = this.getBackground();
        
        // Creating event listeners for the CoursePanel
        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            /*
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                myMouseDragged(evt);
            }
            */
        });
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myMouseEntered(evt);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myMouseExited(evt);
            }
            
            /*
            public void mousePressed(java.awt.event.MouseEvent evt) {
                myMousePressed(evt);
            }
            */
        });
        
        courseInfoSetter();
    }

    
    private void myMouseDragged(java.awt.event.MouseEvent evt) {
        this.moveToFront(this);
        Point mouseLocation = evt.getLocationOnScreen();
        Point windowLocation = this.getParent().getLocationOnScreen();
        this.setLocation(new Point(mouseLocation.x - windowLocation.x  - mouseWBox.x, mouseLocation.y - windowLocation.y - mouseWBox.y));
        
    }
    
    
    private void myMousePressed(java.awt.event.MouseEvent evt) {
        this.moveToFront(this);
        mouseWBox = evt.getPoint();
    }
    
    
    
    private void myMouseEntered(java.awt.event.MouseEvent evt) {
        this.moveToFront(this);
        Color currentColor = this.getBackground();
        this.setBackground(new Color((int) (currentColor.getRed() * 0.75), (int) (currentColor.getGreen() * 0.50), (int) (currentColor.getBlue() * 0.5)));
    }
    
    private void myMouseExited(java.awt.event.MouseEvent evt) {
        this.setBackground(initialBoxColor);
    }
    
    /**
     * Method that sets the information of each CoursePanel to the information contained within the input Course object
     */
    private void courseInfoSetter(){
        courseNameLabel.setText(inputCourse.getCourseTitle());
        crnLabel.setText("" + inputCourse.getCrn());
        daysLabel.setText("Days: " + inputCourse.getDays());
        locationLabel.setText("Location : " + inputCourse.getLocation());
        timeLabel.setText("Time: " + inputCourse.getStartTime() + "-" + inputCourse.getEndTime());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        courseNameLabel = new javax.swing.JLabel();
        crnLabel = new javax.swing.JLabel();
        COURSE_NAME_DESCRIPTION = new javax.swing.JLabel();
        daysLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(25, 100, 200));

        courseNameLabel.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        courseNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        courseNameLabel.setText("jLabel1");

        crnLabel.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 12)); // NOI18N
        crnLabel.setForeground(new java.awt.Color(255, 255, 255));
        crnLabel.setText("jLabel1");

        COURSE_NAME_DESCRIPTION.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        COURSE_NAME_DESCRIPTION.setForeground(new java.awt.Color(255, 255, 255));
        COURSE_NAME_DESCRIPTION.setText("Course Info:");

        daysLabel.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        daysLabel.setForeground(new java.awt.Color(255, 255, 255));
        daysLabel.setText("Days: ");

        locationLabel.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(255, 255, 255));
        locationLabel.setText("Location: ");

        timeLabel.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setText("Time:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(locationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(COURSE_NAME_DESCRIPTION)
                        .addGap(18, 18, 18)
                        .addComponent(crnLabel)
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(daysLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(COURSE_NAME_DESCRIPTION)
                    .addComponent(crnLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(daysLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(locationLabel)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel COURSE_NAME_DESCRIPTION;
    private javax.swing.JLabel courseNameLabel;
    private javax.swing.JLabel crnLabel;
    private javax.swing.JLabel daysLabel;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
