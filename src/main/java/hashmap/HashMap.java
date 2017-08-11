package main.java.hashmap;


/**
 * Created by tanerali on 01/08/2017.
 */



//TODO: nodes have to be linked lists
    //can just use the Student LinkedList
public class HashMap {

    private int arraySize = 256;
    private Student[] studentArray = new Student[arraySize];



    public HashMap() {
    }

    public HashMap(int arraySize) {
        this.arraySize = arraySize;
    }



    public void insertIntoHashMap(String key, String value) {

        // get the hash code
        int hash = Math.abs(key.hashCode() % arraySize);

        //object to be inserted into hashmap
        Student newStudent = new Student(key,value);

        //if array at index[hash] is empty insert new student
        if (studentArray[hash] == null) {
            studentArray[hash] = newStudent;

        }
        //collision. have to put object at the end of linked list at index[hash]
        else {

            Student current = studentArray[hash];

            while (current.nextStudent != null){
                //check if the key already exists
                if (current.getFirst_name().equals(newStudent.getFirst_name()) ){
                    //replace the key's value with the new one
                    current.setLast_name(newStudent.getLast_name());
                    return;
                }

                current = current.nextStudent;
            }
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
