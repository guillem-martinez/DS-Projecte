public class Client { //APENDIX A

  public static void main(String[] args) throws InterruptedException {


    Clock clock = Clock.getInstance();

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


    Print printer = Print.getInstance(root);

    clock.stop();
  }




}
