import java.time.LocalDateTime;
import java.util.ArrayList;

public class Client {

  public static void main(String[] args) throws InterruptedException {

    Clock clock = Clock.getInstance();
    //Clock.initializeClock();

    Project master = new Project("Padre", null);
    Task t1 = new Task("Tasca1", master);
    Project p1 = new Project("Project1", master);
    Task t2 = new Task("Tasca2", p1);
    Project p2 = new Project("Project2", p1);
    Task t3 = new Task("Tasca3", p2);
    Task t4 = new Task("Tasca4", p2);


    Print treePrinter = Print.getInstance(master);

    //Print treePrinter = new Print(master);


    t1.startTask();
    //Thread.sleep(1000);
    t2.startTask();
    //Thread.sleep(1000);
    t3.startTask();
    //Thread.sleep(1000);
    t4.startTask();
    //Thread.sleep(1000);
    //t1.calculateDuration();
    //System.out.println(t1.getDuration());


    //clock.stop();





  }


}
