package main.java.hashmap;


/**
 * Created by tanerali on 01/08/2017.
 */


public class HashMap {

    private int arraySize = 256;
    private Student[] studentArray = new Student[arraySize];


    public HashMap() {
    }


    public HashMap(int arraySize) {
        this.arraySize = arraySize;
    }



    public void insertIntoHashMap(String key, Student student) {

        // get the hash code by hashing the first name of the student that
        //is passed to this method as key
        int hash = Math.abs(key.hashCode() % arraySize);

        //object to be inserted into hashmap
        Student newStudent = new Student(key, student.getFirst_name(), student.getLast_name());

        //if array at index[hash] is empty insert new student
        if (studentArray[hash] == null) {
            studentArray[hash] = newStudent;
        }

        //collision - this can happen because the array has a limited number of indexes,
        //and even if the key is different, the hash number can turn out the same;
        //in this case have to put object at the end of linked list at index[hash]
        else {

            //the student object that caused the collision at index[hash]
            Student current = studentArray[hash];

            //loop through the currentStudent linked list until reaching end
            while (current.nextStudent != null){

                //check if the key already exists; this is because it is assumed
                //that the key will never be duplicated
                if (current.getKey().equals(newStudent.getKey()) ) {
                    //replace the key's value with the new one if the key
                    //is duplicated
                    current.setFirst_name(newStudent.getFirst_name());
                    current.setLast_name(newStudent.getLast_name());
                    return;
                }

                //go on to next link in linked list
                current = current.nextStudent;
            }

            //when reached end of linked list, the next link in the
            //list becomes the newly created object
            current.nextStudent = newStudent;
        }

    }

    /**
     * Returns the value that is mapped to the given key.
     * @param key The key string which is used to search for the value it
     *            is mapped to.
     * @return The value string
     */
    public String get(String key){
        /* Get the hash */
        int hash = Math.abs(key.hashCode() % arraySize);
        // Search for key in linked list
        Student student = studentArray[hash];
        // Traverse linked list
        while(student != null){
            if(student.getFirst_name().equals(key)){
                return student.getLast_name();
            }
            student = student.getNextStudent();
        }
        // Not found? then return null
        return null;
    }

}
