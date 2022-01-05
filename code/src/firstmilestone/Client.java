package firstmilestone;

import java.io.IOException;
import java.util.Arrays;
import secondmilestone.Search;


public class Client { //APENDIX A

  public static void main(String[] args) throws InterruptedException, IOException {


    //Creating the tree of tasks and projects with the information of Apendix A

    Project root = new Project(1,"root", null, null);
    Project swDesign = new Project(2,"software design", root, Arrays.asList("java", "flutter"));
    Project swTesting = new Project(3,"Software testing", root, Arrays.asList("c++",
        "Java", "python"));
    Project db = new Project(4,"databases", root, Arrays.asList("SQL", "python", "C++"));
    Task transportation = new Task(5,"transportation", root, null);
    Project problems = new Project(6,"problems", swDesign, null);
    Project timeTracker = new Project(7,"TimeTracker", swDesign, null);
    Task read = new Task(8,"Read Handout", timeTracker, null);
    Task firstMilestone = new Task(9,"First Milestone",
        timeTracker, Arrays.asList("Java", "IntelliJ"));
    final Task firstList = new Task(10,"First List", problems, Arrays.asList("java"));
    final Task secondList = new Task(11,"Second List", problems, Arrays.asList("Dart"));

    Json saver = new Json();
    saver.storeInfo(root,"test");
    //Searching the tag <example> in the Tree and showing it in Console
    //Search search = Search.getInstance(root, "dart"); DESCOMENTAAAAAR
    Clock clock = Clock.getInstance();



    clock.stop();


  }




}
