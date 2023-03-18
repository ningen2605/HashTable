package com.example.hashtable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**Course Database Structure class
 * @author Ricardo Abuabara
 */
public class CourseDBStructure implements CourseDBStructureInterface{
    public LinkedList<CourseDBElement>[] hashTable;

    /**
     * Constructor
     * @param testing
     * @param size
     */
    public CourseDBStructure(String testing, int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<CourseDBElement>();
        }
    }

    /**
     * default constructor
     * @param size
     */
    public CourseDBStructure(int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<CourseDBElement>();
        }
    }

    /**
     * adding of course element into the hashtable if the element isn't in the hashtable
     * @param element the CourseDBElement to be added to CourseDBStructure
     */
    @Override
    public void add(CourseDBElement element) {
        int code;
        code = Math.abs(element.hashCode())% hashTable.length;
        LinkedList <CourseDBElement>current=hashTable[code];
        if(current==null) {
            hashTable[code]=new LinkedList<CourseDBElement>();
        }
        hashTable[code].add(element);
    }

    /**
     * returns course from the database
     * @param crn crn (key) whose associated courseDatabaseElement is to be returned
     * @return course with the passed crn
     * @throws IOException
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        String crn1 = Integer.toString(crn);
        int Hcode = Math.abs(crn1.hashCode())% hashTable.length;
        if(hashTable[Hcode]==null) {
            throw new IOException();
        }
        else{
            return (CourseDBElement) hashTable[Hcode].get(0);
        }
    }

    /**
     * shows all the courses in the database as a string
     * @return list of courses
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> courses = new ArrayList<>();
        for(int i = 0; i < hashTable.length; i++) {
            while(hashTable[i] != null) {
                for(int j = 0; j < hashTable[i].size(); j++) {
                    CourseDBElement element = (CourseDBElement) hashTable[i].get(j);
                    courses.add("\n"+element.toString());
                }
                break;
            }
        }
        return courses;
    }
    /**
     * @return size of hashTable
     */
    @Override
    public int getTableSize() {
        return hashTable.length;
    }
}
