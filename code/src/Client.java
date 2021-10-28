import java.time.LocalDateTime;
import java.util.ArrayList;

public class Client {

  public static void main(String[] args) throws InterruptedException {


    Clock clock = Clock.getInstance();

    Project root = new Project("root", null);
    Project p1 = new Project("P1", root);
    Project p2 = new Project("P2", root);
    Task t1 = new Task("T1", root);
    Task t2 = new Task("T2", p1);
    Task t3 = new Task("T3", p2);

    Print Printer = Print.getInstance(root);

    Thread.sleep(4000);
    t1.startTask();
    Thread.sleep(4000);
    t2.startTask();
    Thread.sleep(2000);

    clock.stop();










  }




}
