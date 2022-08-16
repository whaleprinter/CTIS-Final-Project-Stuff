/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseScheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JFrame;
import java.util.HashMap;

/**
 *
 * @author Roshan
 */
public class dataManager {
    static String delimiter = "~";
    public static ArrayList<Course> courses = new ArrayList<>();
    private static HashMap<String, ArrayList<Course>> courseMap = new HashMap<>(); 
    
    
    /**
     * Main method actually reads the "courses.txt" file
     * @param args 
     */
    public static void main(String[] args) {
        // Declaring variables 
        int crn;
        String subject;
        String courseName;
        int courseNumber;
        int section;
        String classDays;
        int startTime;
        int endTime;
        String location;
        
        // Try-Catch to catch a file not found error
        try {
            
            // Instantiating a new Scanner object
            Scanner courseReader = new Scanner(new File("courses.txt"));
            
            // As long as there are courses to read, the program will read the file
            while (courseReader.hasNext()) {
                ArrayList<Course> courseTimes;
                String currentLine = courseReader.nextLine();
                
                // Using split() method to break up each new line at the delimiter, which is specified in the variable above
                String[] splitString = currentLine.split(delimiter);
                crn = Integer.parseInt(splitString[0]);
                subject = splitString[1];
                courseName = splitString[2];
                courseNumber = Integer.parseInt(splitString[3]);
                section = Integer.parseInt(splitString[4]);
                classDays = splitString[5];
                startTime = Integer.parseInt(splitString[6]);
                endTime = Integer.parseInt(splitString[7]);
                location = splitString[8];
                
                // Instantiating a new Course object for each course in the input file and adding it to an ArrayList of courses that the program will reference
                Course inputCourse = new Course(crn, subject, courseName, courseNumber, section, classDays, startTime, endTime, location);
                courses.add(inputCourse);
                
                /*
                Trying to use some HashMap stuff here. This part of the program isn't functional
                if (courseMap.containsKey(courseName)) {
                    courseTimes = courseMap.get(courseName);
                    courseTimes.add(inputCourse);
                } else {

                    courseTimes = new ArrayList<>();
                    courseTimes.add(inputCourse);
                    
                }
                courseMap.put(courseName, courseTimes);
                courseTimes = null;
                */
            }
            
            //System.out.println(courseMap.keySet());
            //System.out.println(courseMap.values());
            
        }
        // Catching the errors
        catch (FileNotFoundException ex) {
            System.out.println("File is missing!");
        }
        
        // Instantiating a new CourseFrame object and passing it the ArrayList of courses
        CourseFrame courseSchedulerWindow = new CourseFrame(courses);
  
    }
    
    
    public static ArrayList<Course> getCourses() {
        return courses;
    }
        
        
    }
   

