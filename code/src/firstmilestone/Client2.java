package firstmilestone;

import java.util.Arrays;

public class Client2 {

  public static void main(String[] args) throws InterruptedException { //APENDIX B

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

    Print treePrinter = Print.getInstance(root);
    final Clock clock = Clock.getInstance();

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
