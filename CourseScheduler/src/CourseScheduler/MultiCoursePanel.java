/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseScheduler;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Roshan
 */


public class MultiCoursePanel extends javax.swing.JPanel {
    // Declaring and Instantiating some variables
    private ArrayList<CoursePanel> coursesInMultiPanel = new ArrayList<>();
    Color initialBoxColor; 
    Point mouseWBox;
    String days;
    
    /**
     * Constructor for the MultiCoursePanel object, which houses multiple CoursePanel objects
     * @param course 
     */
    public MultiCoursePanel(Course course) {
        initComponents();
        days = course.getDays();
        
        // Uncomment these lines from this class and change "extends javax.swing.JPanel" to "extends javax.swing.JLayeredPane" above if you would like to use a JLayeredPane instead of a JPanel
        //this.moveToFront(this);
        
        // Creating new mouse event listeners for each MultiCoursePanel
        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                // Connecting the event listener to the event handler
                myMouseDragged(evt);
            }
            
        });
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myMouseEntered(evt);
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myMouseExited(evt);
            }
            
            
            public void mousePressed(java.awt.event.MouseEvent evt) {
                myMousePressed(evt);
            }
            
        });
        
        /*
        http://www.cafeaulait.org/course/week8/07.html
        This link above helped me understand how to change the spacing of the CoursePanels    
        */
        // Detecting how many days that the course takes place on and creating the necessary number of CoursePanels
        switch (days) {
            case "MWF":
                this.setLayout(new FlowLayout(FlowLayout.CENTER, 250, 0));
                    for (int i = 0; i <= 2; i++) {
                        CoursePanel courseToDisplay = new CoursePanel(course);
                        //courseToDisplay.setLocation(144 + (364 * i), 0); 
                        this.add(courseToDisplay);
                    }
                
                break;
            
            case "TR":
                this.setLayout(new FlowLayout(FlowLayout.LEFT, 250, 0));
                this.setLocation(400, 0);
                    for (int i = 0; i <= 1; i++) {
                        CoursePanel courseToDisplay = new CoursePanel(course);
                        this.add(courseToDisplay);   
                    }
                break;
            
            case "MTWRF":
                this.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
                
                    for (int i = 0; i <= 4; i++) {
                        CoursePanel courseToDisplay = new CoursePanel(course);
                        this.add(courseToDisplay);   
                    }
                break;
            case "MW":
                this.setLayout(new FlowLayout(FlowLayout.LEADING, 250, 0));
                    for (int i = 0; i <= 1; i++) {
                        CoursePanel courseToDisplay = new CoursePanel(course);
                        this.add(courseToDisplay);                        
                    }
                break;
        }
        
        
    }
    
    /**
     * Event handler for Mouse Dragged
     * @param evt 
     */
    private void myMouseDragged(java.awt.event.MouseEvent evt) {
        //this.moveToFront(this);
        Point mouseLocation = evt.getLocationOnScreen();
        Point windowLocation = this.getParent().getLocationOnScreen();
        this.setLocation(new Point(mouseLocation.x - windowLocation.x  - mouseWBox.x, mouseLocation.y - windowLocation.y - mouseWBox.y));
        
    }
    
    /**
     * Event handler for Mouse Pressed
     * @param evt 
     */
    private void myMousePressed(java.awt.event.MouseEvent evt) {
        //this.moveToFront(this);
        mouseWBox = evt.getPoint();
    }
    
    /**
     * Event handler for Mouse Entered
     * @param evt 
     */
    private void myMouseEntered(java.awt.event.MouseEvent evt) {
        //this.moveToFront(this);
        Color currentColor = this.getBackground();
        this.setBackground(new Color((int) (currentColor.getRed() * 0.75), (int) (currentColor.getGreen() * 0.50), (int) (currentColor.getBlue() * 0.5)));
    }
    
    /**
     * Event handler for Mouse Exited
     * @param evt 
     */
    private void myMouseExited(java.awt.event.MouseEvent evt) {
        this.setBackground(initialBoxColor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
