public class Client2 {

  public static void main(String[] args) throws InterruptedException { //APENDIX B

    Project root = new Project("root", null);
    Project swDesign = new Project("software design", root);
    Project swTesting = new Project("Software testing", root);
    Project db = new Project("databases", root);
    Task transportation = new Task("transportation", root);
    Project problems = new Project("problems", swDesign);
    Project timeTracker = new Project("TimeTracker", swDesign);
    Task read = new Task("Read Handout", timeTracker);
    Task firstMilestone = new Task("First Milestone", timeTracker);
    final Task firstList = new Task("First List", problems);
    final Task secondList = new Task("Second List", problems);

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
