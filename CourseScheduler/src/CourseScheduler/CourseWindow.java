/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseScheduler;

import java.util.ArrayList;

import javax.swing.JComboBox;



/**
 *
 * @author Roshan
 */
public class CourseWindow extends javax.swing.JLayeredPane {
    // Declaraing and Instantiating variables
    private ArrayList<String> courseNames = new ArrayList<String>();
    private ArrayList<String> selectedCourses = new ArrayList<>();
    private ArrayList<Course> finalSelectedCourses = new ArrayList<>();
    private ArrayList<Course> coursesListDuplicate;
    private ArrayList<String> coursesInDropDownList = new ArrayList<>();
    private boolean allCoursesConfirmed = false;
    private int coursesSelected = 0;
    CourseFrame myParent = null;
    
    /**
     * Constructor for the CourseWindow object, which is the main interactive element of this program
     * @param coursesList 
     */
    public CourseWindow(ArrayList<Course> coursesList) {
        initComponents();
        
        
        daysPanel.setVisible(false);
        finalizeCourses.setVisible(false);
        addToAdditionalTimes.setVisible(false);
        coursesListDuplicate = new ArrayList<Course>(coursesList);

        // Populating the drop-down menu with all the courses in the "courses.txt" file
        for (Course courseName : coursesList) {
            String courseTitle = courseName.getCourseTitle();
            courseNames.add(courseTitle);
            int courseCRN = courseName.getCrn();
            String days = courseName.getDays();
            int startTime = courseName.getStartTime();
            int endTime = courseName.getEndTime();
            String courseDropDownInfo = courseCRN + " " + courseTitle + ", Days: " + days + ". Time: " + startTime + "--" + endTime;
            coursesInDropDownList.add(courseDropDownInfo);
            courseSelector.addItem(courseDropDownInfo);
        }
    }

    /**
     * Method that takes the name of a course and returns the actual object of that course
     * @param input
     * @return 
     */
    private Course courseComparer(String input) {
        int indexOfInputCourse = coursesInDropDownList.indexOf(input);
        return (coursesListDuplicate.get(indexOfInputCourse));
    }
    
    /**
     * Method that systematically removes chosen items from the drop-down menu while also adding those selected items to an ArrayList
     * https://stackoverflow.com/questions/16700963/disable-combo-box-list
     * I referenced this page to learn how to disable JComboBox elements
     */
    private void dropDownChecker() {
        coursesSelected++;
        
        // Detecting if the course is a three-week course
        if ((courseComparer("" + courseSelector.getSelectedItem()).getDays()).equals("MTWRF")) {
            selectedCourses.clear();
            selectedCourses.add("" + courseSelector.getSelectedItem());
            courseSelector.removeItemAt(courseSelector.getSelectedIndex());
            selectedCoursesLabel.setText("<html>Three-Week Course: " + selectedCourses.get(0) + "<br></html>");
            allCoursesConfirmed = true;
            finalizeCourses.setVisible(true);
            additionalCourseTimes.setVisible(false);
            confirmCourses.setVisible(false);
            addToAdditionalTimes.setVisible(false);
            courseSelector.setVisible(false);
        }
        // If not a three-week course, the program continues to take inputs
        else {
           
            switch (coursesSelected) {
                case 1 : 
                    addToAdditionalTimes.setVisible(true);
                    selectedCourses.add("" + courseSelector.getSelectedItem());
                    courseSelector.removeItemAt(courseSelector.getSelectedIndex());
                    selectedCoursesLabel.setText("<html>Course 1: " + selectedCourses.get(0) + "<br></html>");
                    break;
                case 2: 
                    selectedCourses.add("" + courseSelector.getSelectedItem());
                    courseSelector.removeItemAt(courseSelector.getSelectedIndex());
                    selectedCoursesLabel.setText("<html>Course 1: " + selectedCourses.get(0) + "<br>Course 2: " + selectedCourses.get(1) + "<br></html>");
                    break;
                case 3: 
                    selectedCourses.add("" + courseSelector.getSelectedItem());
                    courseSelector.removeItemAt(courseSelector.getSelectedIndex());
                    selectedCoursesLabel.setText("<html>Course 1: " + selectedCourses.get(0) + "<br>Course 2: " + selectedCourses.get(1) + "<br>Course 3: " + selectedCourses.get(2) + "<br></html>");
                    allCoursesConfirmed = true;
                    break;
            }
        }
        if (allCoursesConfirmed) {
            finalizeCourses.setVisible(true);
            confirmCourses.setVisible(false);
        }
    }
    
    /**
     * Process the additional time for a course and add that additional course to another ArrayList
     */
    private void additionalCourseAdder() {
        if ((courseComparer("" + courseSelector.getSelectedItem()).getDays()).equals("MTWRF")) {
            selectedCourses.clear();
            selectedCourses.add("" + courseSelector.getSelectedItem());
            courseSelector.removeItemAt(courseSelector.getSelectedIndex());
            selectedCoursesLabel.setText("<html>Three-Week Course: " + selectedCourses.get(0) + "<br></html>");
            allCoursesConfirmed = true;
            finalizeCourses.setVisible(true);
            additionalCourseTimes.setVisible(false);
            confirmCourses.setVisible(false);
            addToAdditionalTimes.setVisible(false);
            courseSelector.setVisible(false);
        }
        else {
            selectedCourses.add("" + courseSelector.getSelectedItem());
            String mostRecentlySelectedCourse = "" + courseSelector.getSelectedItem();
            courseSelector.removeItemAt(courseSelector.getSelectedIndex());
            String currentText = additionalCourseTimes.getText();
            additionalCourseTimes.setText("<html>" + currentText + "<br><html>" + mostRecentlySelectedCourse + "<br></html>");
        }
        
    }
    
    public ArrayList<Course> getFinalSelectedCourses() {
        return finalSelectedCourses;
    }

    public boolean isAllCoursesConfirmed() {
        return allCoursesConfirmed;
    }
    
    /**
     * Set the parent of a CourseWindow
     * @param parent 
     */
    public void setMyParent(CourseFrame parent) {
        this.myParent = parent;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        daysPanel = new javax.swing.JPanel();
        mondayLabel = new javax.swing.JLabel();
        tuesdayLabel = new javax.swing.JLabel();
        wednesdayLabel = new javax.swing.JLabel();
        thursdayLabel = new javax.swing.JLabel();
        fridayLabel = new javax.swing.JLabel();
        courseSelectionPanel = new javax.swing.JPanel();
        selectedCoursesLabel = new javax.swing.JLabel();
        additionalCourseTimes = new javax.swing.JLabel();
        courseSelector = new javax.swing.JComboBox<>();
        addToAdditionalTimes = new javax.swing.JButton();
        finalizeCourses = new javax.swing.JButton();
        courseLabel = new javax.swing.JLabel();
        confirmCourses = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        daysPanel.setBackground(new java.awt.Color(200, 200, 255));

        mondayLabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        mondayLabel.setText("Monday");

        tuesdayLabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        tuesdayLabel.setText("Tuesday");

        wednesdayLabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        wednesdayLabel.setText("Wednesday");

        thursdayLabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        thursdayLabel.setText("Thursday");

        fridayLabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 18)); // NOI18N
        fridayLabel.setText("Friday");

        javax.swing.GroupLayout daysPanelLayout = new javax.swing.GroupLayout(daysPanel);
        daysPanel.setLayout(daysPanelLayout);
        daysPanelLayout.setHorizontalGroup(
            daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daysPanelLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(mondayLabel)
                .addGap(164, 164, 164)
                .addComponent(tuesdayLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(wednesdayLabel)
                .addGap(162, 162, 162)
                .addComponent(thursdayLabel)
                .addGap(162, 162, 162)
                .addComponent(fridayLabel)
                .addGap(143, 143, 143))
        );
        daysPanelLayout.setVerticalGroup(
            daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daysPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(daysPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mondayLabel)
                    .addComponent(tuesdayLabel)
                    .addComponent(wednesdayLabel)
                    .addComponent(thursdayLabel)
                    .addComponent(fridayLabel)))
        );

        selectedCoursesLabel.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        selectedCoursesLabel.setText("Selected Courses Appear Here!");
        selectedCoursesLabel.setInheritsPopupMenu(false);

        additionalCourseTimes.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        additionalCourseTimes.setText("Additional Courses:");
        additionalCourseTimes.setInheritsPopupMenu(false);

        courseSelector.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N

        addToAdditionalTimes.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        addToAdditionalTimes.setText("Confirm as Additional Time");
        addToAdditionalTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToAdditionalTimesActionPerformed(evt);
            }
        });

        finalizeCourses.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        finalizeCourses.setText("Finalize Courses");
        finalizeCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizeCoursesActionPerformed(evt);
            }
        });

        courseLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        courseLabel.setText("Select your Courses");

        confirmCourses.setFont(new java.awt.Font("Microsoft YaHei", 0, 11)); // NOI18N
        confirmCourses.setText("Confirm");
        confirmCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmCoursesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout courseSelectionPanelLayout = new javax.swing.GroupLayout(courseSelectionPanel);
        courseSelectionPanel.setLayout(courseSelectionPanelLayout);
        courseSelectionPanelLayout.setHorizontalGroup(
            courseSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(courseSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseLabel)
                    .addGroup(courseSelectionPanelLayout.createSequentialGroup()
                        .addComponent(confirmCourses)
                        .addGap(18, 18, 18)
                        .addComponent(addToAdditionalTimes)
                        .addGap(18, 18, 18)
                        .addComponent(finalizeCourses))
                    .addGroup(courseSelectionPanelLayout.createSequentialGroup()
                        .addGroup(courseSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(selectedCoursesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addComponent(courseSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addComponent(additionalCourseTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        courseSelectionPanelLayout.setVerticalGroup(
            courseSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(courseLabel)
                .addGap(18, 18, 18)
                .addComponent(courseSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(courseSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmCourses)
                    .addComponent(addToAdditionalTimes)
                    .addComponent(finalizeCourses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(courseSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectedCoursesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(additionalCourseTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(daysPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(courseSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(courseSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(daysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Event Handlers
    private void confirmCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmCoursesActionPerformed
        dropDownChecker();
        repaint();
    }//GEN-LAST:event_confirmCoursesActionPerformed

    private void addToAdditionalTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToAdditionalTimesActionPerformed
        additionalCourseAdder();
        repaint();
    }//GEN-LAST:event_addToAdditionalTimesActionPerformed

    
    /**
     * Event handler for the "Finalize Courses" button
     * This method automatically
     * @param evt 
     */
    private void finalizeCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizeCoursesActionPerformed
        // TODO add your handling code here:
        if (allCoursesConfirmed) {
            
            courseLabel.setText("Your Selected Courses have been Generated Below");

            // Converting each course name into an actual object
            for (String selectedCourseInList : selectedCourses) {
                int indexOfCourse = coursesInDropDownList.indexOf(selectedCourseInList);
                finalSelectedCourses.add(coursesListDuplicate.get(indexOfCourse));
            }

            courseSelectionPanel.setVisible(false);
            daysPanel.setVisible(true);
            myParent.showCoursePanels(finalSelectedCourses);
            
        }
    }//GEN-LAST:event_finalizeCoursesActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToAdditionalTimes;
    private javax.swing.JLabel additionalCourseTimes;
    private javax.swing.JButton confirmCourses;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JPanel courseSelectionPanel;
    private javax.swing.JComboBox<String> courseSelector;
    private javax.swing.JPanel daysPanel;
    private javax.swing.JButton finalizeCourses;
    private javax.swing.JLabel fridayLabel;
    private javax.swing.JLabel mondayLabel;
    private javax.swing.JLabel selectedCoursesLabel;
    private javax.swing.JLabel thursdayLabel;
    private javax.swing.JLabel tuesdayLabel;
    private javax.swing.JLabel wednesdayLabel;
    // End of variables declaration//GEN-END:variables
}
