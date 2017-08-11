package main.java.linked_lists;

/**
 * Created by tanerali on 31/07/2017.
 */
class Student {

    String first_name;
    String last_name;
    int age;

    Student nextStudent;


    @Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                '}';
    }

    //CONSTRUCTOR No1 No Link
    public Student(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    //CONSTRUCTOR No2 All Fields
    public Student(String first_name, String last_name, int age, Student nextStudent) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.nextStudent = nextStudent;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getNextStudent() {
        return nextStudent;
    }

    public void setNextStudent(Student nextStudent) {
        this.nextStudent = nextStudent;
    }
}
