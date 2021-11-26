package firstmilestone;

import java.util.Arrays;
import secondmilestone.Search;

public class Client2 {

  public static void main(String[] args) throws InterruptedException { //APENDIX B

    //Creating the tree of tasks and projects with the information of Apendix B
    Project root = new Project("root", null, null);
    Project swDesign = new Project("software design", root, Arrays.asList("java", "flutter"));
    Project swTesting = new Project("Software testing", root, Arrays.asList("c++",
        "Java", "python"));
    Project db = new Project("databases", root, Arrays.asList("SQL", "python", "C++"));
    Task transportation = new Task("transportation", root, null);
    Project problems = new Project("problems", swDesign, null);
    Project timeTracker = new Project("TimeTracker", swDesign, null);
    Task read = new Task("Read Handout", timeTracker, null);
    Task firstMilestone = new Task("First Milestone", timeTracker, Arrays.asList("Java",
        "IntelliJ"));
    final Task firstList = new Task("First List", problems, Arrays.asList("java"));
    final Task secondList = new Task("Second List", problems, Arrays.asList("Dart"));

    //Creating the Printer for showing the information of the tree (Milestone1)
    Search search = Search.getInstance(root, "java");
    Print treePrinter = Print.getInstance(root);
    final Clock clock = Clock.getInstance();

    //Sequence of instructions following the Apendix B

    transportation.startTask();
    Thread.sleep(4000);
    transportation.stopTask();
    ///////////////////////
    Thread.sleep(2000);
    ///////////////////////
    firstList.startTask();
    Thread.sleep(6000);
    ///////////////////////
    secondList.startTask();
    Thread.sleep(4000);
    ///////////////////////
    firstList.stopTask();
    ///////////////////////
    Thread.sleep(2000);
    secondList.stopTask();
    Thread.sleep(2000);
    ///////////////////////
    transportation.startTask();
    Thread.sleep(4000);
    transportation.stopTask();

    clock.stop();



  }
}
