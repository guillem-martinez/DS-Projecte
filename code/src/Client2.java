public class Client2 {

  public static void main(String[] args) throws InterruptedException { //APENDIX B
    Clock clock = Clock.getInstance();

    Project root = new Project("root", null);
    Project SWdesign = new Project("software design", root);
    Project SWtesting = new Project("Software testing", root);
    Project DB = new Project("databases", root);
    Task transportation = new Task("transportation", root);
    Project problems = new Project("problems", SWdesign);
    Project TimeTracker = new Project ("TimeTracker", SWdesign);
    Task FirstList = new Task("First List", problems);
    Task SecondList = new Task("Second List", problems);
    Task Read = new Task("Read Handout", TimeTracker);
    Task FirstMilestone = new Task("First Milestone", TimeTracker);


    Print treePrinter = Print.getInstance(root);

    
    transportation.startTask();
    Thread.sleep(4000);
    transportation.stopTask();
    ///////////////////////
    Thread.sleep(2000);
    ///////////////////////
    FirstList.startTask();
    Thread.sleep(6000);
    ///////////////////////
    SecondList.startTask();
    Thread.sleep(4000);
    ///////////////////////
    FirstList.stopTask();
    ///////////////////////
    Thread.sleep(2000);
    SecondList.stopTask();
    Thread.sleep(2000);
    ///////////////////////
    transportation.startTask();
    Thread.sleep(4000);
    transportation.stopTask();


    clock.stop();



  }
}
