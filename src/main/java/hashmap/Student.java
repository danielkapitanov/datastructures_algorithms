package main.java.hashmap;


/**
 * Created by tanerali on 01/08/2017.
 */
class Student {

    String key;

    String first_name;
    String last_name;

    Student nextStudent;


    public Student(String key, String first_name, String last_name) {
        this.key = key;
        this.first_name = first_name;
        this.last_name = last_name;
    }




    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Student getNextStudent() {
        return nextStudent;
    }

    public void setNextStudent(Student nextStudent) {
        this.nextStudent = nextStudent;
    }
}
