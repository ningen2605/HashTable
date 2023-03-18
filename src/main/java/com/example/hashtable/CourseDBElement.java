package com.example.hashtable;
/** Course Database Element class
 * @author Ricardo Abuabara
 */
public class CourseDBElement implements Comparable{
    protected String ID;
    protected int crn;
    protected int credits;
    protected String room;
    protected String instructorName;
    /**
     * constructor to assign values to fields
     * @param cID course ID
     * @param crn Course number
     * @param credits number of credits
     * @param room classroom for the course
     * @param instructor name of instructor for course
     */
    public CourseDBElement(String cID, int crn, int credits, String room, String instructor) {
        ID = cID;
        this.crn = crn;
        this.credits = credits;
        this.room = room;
        instructorName = instructor;
    }
    /**
     * default constructor to assign values to fields
     */
    public CourseDBElement() {
        this(null,00000,0,null,null); //default
    }

    /**
     *returns value of id
     * @return id
     */
    public String getID() {
        return ID;
    }
    /**
     *sets value of crn
     */
    public void setCRN(int crn) {
        this.crn = crn;
    }
    /** returns the value of the room
     * @return value of room
     */

    public String getRoomNum() {
        return room;
    }
    /** returns the value of crn
     * @return value of crn
     */
    public int getCRN() {
        return crn;
    }


    /**
     * parse crn to string then return its hashcode
     * @return hashcode of crn
     */
    public int hashCode() {
        String crn1=Integer.toString(crn);
        return crn1.hashCode();
    }

    /**
     * @return string format of course
     */
    public String toString() {
        String course = "Course:"+ID+" CRN:"+crn+" Credits:"+credits+" Instructor:"+instructorName+" Room:"+room;
        return course;
    }
    /**
     * compares crn of 2 different objects(courses)
     * @returns either -1  if crn of element is smaller, or 1 if it is greater and 0 if they are equal
     * @param element course to be compared
     */
    public int compareTo(Object element) {
        CourseDBElement newE = (CourseDBElement) element;
        return 0;
    }


}
