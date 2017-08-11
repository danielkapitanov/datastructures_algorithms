package main.java.linked_lists;

/**
 * Created by tanerali on 31/07/2017.
 */
class LinkedList {

    //Reference to frist Student in list
    //The last Student added to the LinkedList

    public Student latestStudent;

    LinkedList (){
        //Here to show the first Student always starts as null
        latestStudent = null;
    }

    //Returns true if LinkedList is empty
    public boolean isEmpty (){
        return  (latestStudent == null);
    }

    public void insertStudent (String first_name, String last_name, int age) {

        Student student = new Student(first_name, last_name, age);

        //Connects the latestStudent field to the new Student
        student.nextStudent = latestStudent;

        //Latest student now points to most recently added student
        latestStudent = student;

    }

    //remove latest student and return it
    public Student removeLatestStudent(){

        Student studentRef = latestStudent;

        if (!isEmpty() ) {
            latestStudent = latestStudent.nextStudent;

        } else {
            System.out.println("Empty LinkedList");
        }

        return  studentRef;
    }

    //remove student from anywhere in the list and return it
    public Student removeStudent(String firstName) {

        Student currentStudent = latestStudent;
        Student previousStudent = latestStudent;

        while (!currentStudent.getFirst_name().equalsIgnoreCase(firstName) ) {

            if (currentStudent == null) {
                //student not found
                return null;
            } else {
                //we checked the current student so lets look in the
                //next student on the list
                previousStudent = currentStudent;
                currentStudent = currentStudent.nextStudent;
            }

        }

        if (currentStudent == latestStudent){
            //
            latestStudent = latestStudent.nextStudent;
        } else {
            //
            System.out.println();
            System.out.println();
            System.out.println();

            previousStudent.nextStudent = currentStudent.nextStudent;
        }
        return currentStudent;
    }


    public void display(){

        Student student = latestStudent;

        //Start at the refernece stored in latest student
        //keep getting references stored in next_student for
        //every Student until next returns null

        while (student != null) {

            System.out.println(student.toString() );

            student = student.nextStudent;

            System.out.println("---------");
        }
    }

    public Student findStudent(String firstName){
        Student student = latestStudent;

        //execute loop if list not empty; else sout "empty list"
        if (!isEmpty() ) {

            //iterate through list until name equals first_name
            while ( !student.getFirst_name().equalsIgnoreCase(firstName) ) {

                if (student.nextStudent == null) {
                    return null;
                } else {
                    student = student.nextStudent;
                }

            }
            return student;

        } else {
            System.out.println("Empty LinkedList");
        }

        return null;
    }
}
