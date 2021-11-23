import java.util.Arrays;

public class Client { //APENDIX A

  public static void main(String[] args) throws InterruptedException {


/*
    Project root = new Project("root", null);
    Project swDesign = new Project("software design", root);
    Project swTesting = new Project("Software testing", root);
    Project db = new Project("databases", root);
    Task transportation = new Task("transportation", root);
    Project problems = new Project("problems", swDesign);
    Project timeTracker = new Project("TimeTracker", swDesign);
    Task firstList = new Task("First List", problems);
    Task secondList = new Task("Second List", problems);
    Task read = new Task("Read Handout", timeTracker);
    Task firstMilestone = new Task("First Milestone", timeTracker);
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

    //Print printer = Print.getInstance(root);

    clock.stop();


  }




}
