package Fita1;

import Fita1.Clock;
import Fita1.Project;
import Fita1.Task;
import Fita2.Search;

import java.util.Arrays;

public class Client { //APENDIX A

  public static void main(String[] args) throws InterruptedException {


/*
    Fita1.Project root = new Fita1.Project("root", null);
    Fita1.Project swDesign = new Fita1.Project("software design", root);
    Fita1.Project swTesting = new Fita1.Project("Software testing", root);
    Fita1.Project db = new Fita1.Project("databases", root);
    Fita1.Task transportation = new Fita1.Task("transportation", root);
    Fita1.Project problems = new Fita1.Project("problems", swDesign);
    Fita1.Project timeTracker = new Fita1.Project("TimeTracker", swDesign);
    Fita1.Task firstList = new Fita1.Task("First List", problems);
    Fita1.Task secondList = new Fita1.Task("Second List", problems);
    Fita1.Task read = new Fita1.Task("Read Handout", timeTracker);
    Fita1.Task firstMilestone = new Fita1.Task("First Milestone", timeTracker);
*/
    Project root = new Project("root", null, null);
    Project swDesign = new Project("software design", root, Arrays.asList("java","flutter"));
    Project swTesting = new Project("Software testing", root, Arrays.asList("c++","Java","python"));
    Project db = new Project("databases", root,Arrays.asList("SQL","python","C++"));
    Task transportation = new Task("transportation", root, null);
    Project problems = new Project("problems", swDesign, null);
    Project timeTracker = new Project("TimeTracker", swDesign, null);
    Task read = new Task("Read Handout", timeTracker, null);
    Task firstMilestone = new Task("First Milestone", timeTracker, Arrays.asList("Java","IntelliJ"));
    final Task firstList = new Task("First List", problems,Arrays.asList("java"));
    final Task secondList = new Task("Second List", problems,Arrays.asList("Dart"));


    Search search = Search.getInstance(root, "java");
    Clock clock = Clock.getInstance();

    //Fita1.Print printer = Fita1.Print.getInstance(root);

    clock.stop();


  }




}
