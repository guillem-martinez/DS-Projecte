package firstmilestone;

import java.util.Arrays;
import secondmilestone.Search;


public class Client { //APENDIX A

  public static void main(String[] args) throws InterruptedException {


    //Creating the tree of tasks and projects with the information of Apendix A

    Project root = new Project("root", null, null);
    Project swDesign = new Project("software design", root, Arrays.asList("java", "flutter"));
    Project swTesting = new Project("Software testing", root, Arrays.asList("c++",
        "Java", "python"));
    Project db = new Project("databases", root, Arrays.asList("SQL", "python", "C++"));
    Task transportation = new Task("transportation", root, null);
    Project problems = new Project("problems", swDesign, null);
    Project timeTracker = new Project("TimeTracker", swDesign, null);
    Task read = new Task("Read Handout", timeTracker, null);
    Task firstMilestone = new Task("First Milestone",
        timeTracker, Arrays.asList("Java", "IntelliJ"));
    final Task firstList = new Task("First List", problems, Arrays.asList("java"));
    final Task secondList = new Task("Second List", problems, Arrays.asList("Dart"));

    //Searching the tag <example> in the Tree and showing it in Console
    Search search = Search.getInstance(root, "java");
    Clock clock = Clock.getInstance();



    clock.stop();


  }




}
