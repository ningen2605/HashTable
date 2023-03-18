package com.example.hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Course Database Manager
 * @author Ricardo Abuabara
 */
public class CourseDBManager implements CourseDBManagerInterface {
    CourseDBStructure cdsStructure = new CourseDBStructure(20);
    /**
     * adds the course elements into the hashtable
     * @param id course id
     * @param crn course crn
     * @param credits number of credits
     * @param roomNum course room number
     * @param instructor name of the instructor
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement cde = new CourseDBElement(id,crn,credits,roomNum,instructor);
        cdsStructure.add(cde);
    }

    /**
     * uses the CDS get method to return course with the passed crn
     * @param crn course crn (key)
     * @return
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return cdsStructure.get(crn);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * reads the courses information from a file
     * @param input input file
     * @throws FileNotFoundException
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner in = new Scanner(input);
        int credits,crn;
        CourseDBElement cde;
        String courses;
        String[] course;
        while (in.hasNextLine()) {
            courses=in.nextLine();
            course=courses.split(" ",5);
            crn=Integer.parseInt(course[1]);
            credits=Integer.parseInt(course[2]);
            cde=new CourseDBElement(course[0],crn,credits,course[3],course[4]);
            cdsStructure.add(cde);
        }
    }

    /**
     * returns all the courses in the database
     * @return all courses in the database
     */
    @Override
    public ArrayList<String> showAll() {
        return cdsStructure.showAll();
    }
}
