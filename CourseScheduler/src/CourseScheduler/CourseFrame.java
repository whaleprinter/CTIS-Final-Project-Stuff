// https://stackoverflow.com/questions/4749725/jpanel-inside-another
// https://docs.oracle.com/javase/tutorial/uiswing/layout/using.html
package CourseScheduler;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Roshan
 */
public class CourseFrame extends javax.swing.JFrame {
    // Declaring the container to put other GUI elements in
    private Container container; 
    
    // Declaring a new CourseWindow object to be used as the main interactive element
    private CourseWindow courseWindowPanel;

    /**
     * Constructor for the CourseFrame object
     * @param coursesList 
     */
    public CourseFrame(ArrayList<Course> coursesList) {
        initComponents();
        container = getContentPane();
        container.setLayout(new FlowLayout());
        
        // New CourseWindow
        courseWindowPanel = new CourseWindow(coursesList);
        
        // Setting this CourseFrame object as the parent of the courseWindowPanel instantiated aboves
        courseWindowPanel.setMyParent(this);
        
        container.add(courseWindowPanel);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public CourseWindow getCourseWindowPanel() {
        return courseWindowPanel;
    }

    public void setCourseWindowPanel(CourseWindow courseWindowPanel) {
        this.courseWindowPanel = courseWindowPanel;
    }
    
    /**
     * Method called within the CourseWindow class in order to get the parent (this CourseFrame object) to display the Course objects selected within the CourseWindow
     * @param coursePanelsToDisplay 
     */
    public void showCoursePanels(ArrayList<Course> coursePanelsToDisplay) {
        
        // Creating a new MultiCoursePanel for each Course object selected
        for (Course courseInInputList : coursePanelsToDisplay) {
            MultiCoursePanel multiCoursePanelToDisplay = new MultiCoursePanel(courseInInputList);
            // Adding each MultiCoursePanel to the container to be displayed
            container.add(multiCoursePanelToDisplay);        
        }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1191, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
