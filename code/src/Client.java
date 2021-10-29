import java.time.LocalDateTime;
import java.util.ArrayList;

public class Client { //APENDIX A

  public static void main(String[] args) throws InterruptedException {


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


    Print Printer = Print.getInstance(root);

    clock.stop();
  }




}
