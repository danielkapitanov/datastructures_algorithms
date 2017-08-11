package main.java.linked_lists;

/**
 * Created by tanerali on 31/07/2017.
 */
public class StudentListController {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertStudent("Taner", "Ali",22);
        linkedList.insertStudent("Dani", "Kapitanov",22);
        linkedList.insertStudent("Nicola", "Pilcher",25);
        linkedList.insertStudent("Aaron", "Bigelow",36);
        linkedList.insertStudent("Ryan", "Desmond",35);

        linkedList.display();

        System.out.println(
                "Value of first Student in LinkedList " + linkedList.latestStudent+ "\n");

        //removes the last student entered
        linkedList.removeLatestStudent();

        //show list contents
        linkedList.display();

        //demonstrate that Aaron object was found
        System.out.println(
                linkedList.findStudent("Aaron ").getFirst_name() + "was found.");

        //remove Dani object
        linkedList.removeStudent("Dani");

        System.out.println("Dani is out the door!");

        //show list contents
        linkedList.display();


    }

}