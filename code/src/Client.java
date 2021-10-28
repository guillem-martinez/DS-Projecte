import java.time.LocalDateTime;
import java.util.ArrayList;

public class Client {

  public static void main(String[] args) throws InterruptedException {

    Clock clock = Clock.getInstance();
    Clock.initializeClock();

    Project master = new Project("Padre", null);
    Task t1 = new Task("Tasca1", master);
    Project p1 = new Project("Project1", master);
    Task t2 = new Task("Tasca2", p1);
    Project p2 = new Project("Project2", p1);
    Task t3 = new Task("Tasca3", p2);
    Task t4 = new Task("Tasca4", p2);

    t1.startTask();
    Thread.sleep(4000);

    //System.out.println();
    t2.startTask();
    Thread.sleep(2000);
    //t1.getIntervals. get(i).endInterval();


    Print treePrinter = new Print(master);
    //treePrinter

    /*ArrayList<Event> list = (ArrayList) p1.getEvents();

    for (int i=0; i<list.size(); i++)
    {
      System.out.println(list.get(i).getName());
    }
    */




    //clock.stop();





  }


}
