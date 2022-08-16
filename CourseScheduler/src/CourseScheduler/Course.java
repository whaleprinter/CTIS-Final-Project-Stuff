/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseScheduler;

import java.util.ArrayList;

/**
 *
 * @author Roshan
 */

/**
 * This Course object doesn't really have much functionality on its own. It's mainly an easy way to store the data related to each course
 * @author Roshan
 */
public class Course {
    private int crn;
    private String subject;
    private String courseTitle;
    private int courseNumber;
    private int period;
    private String days;
    private int startTime;
    private int endTime;
    private String location;
    private ArrayList<Course> additionalTimes;
    
    public Course(int crn, String subject, String courseTitle, int courseNumber, int period, String days, int startTime, int endTime, String location) {
            this.crn = crn;
            this.subject = subject;
            this.courseTitle = courseTitle;
            this.courseNumber = courseNumber;
            this.period = period;
            this.days = days;
            this.startTime = startTime;
            this.endTime = endTime;
            this.location = location;
            this.additionalTimes = additionalTimes;
        }
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">        
    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Course> getAdditionalTimes() {
        return additionalTimes;
    }

    public void setAdditionalTimes(ArrayList<Course> additionalTimes) {
        this.additionalTimes = additionalTimes;
    }
    
    
    // </editor-fold>    

    @Override
    public String toString() {
        return "course{" + "crn=" + crn + ", subject=" + subject + ", courseTitle=" + courseTitle + ", courseNumber=" + courseNumber + ", period=" + period + ", days=" + days + ", startTime=" + startTime + ", endTime=" + endTime + ", location=" + location + '}';
    }

  
}
