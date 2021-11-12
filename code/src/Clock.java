import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;



//This Clock is the object Observable that the observers (intervals) will look at it.
//It is implemented as Singleton for use the same instance of a Clock for the entire program.

public class Clock extends Observable {

  private static LocalDateTime dateTime;
  private static Timer timer;
  private static Clock instance = null;

  //Getters
  //Method for getting the Singleton Clock
  public static Clock getInstance() {
    if (instance == null) {
      instance = new Clock();
    }
    return instance;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  private Clock() {
    timer = new Timer("Reloj");
    TimerTask repeatTask = new TimerTask() {
      @Override
      public void run() {
        // System.out.println("COMENZAMOS EL RUN DEL RELOJ");
        tick();
        //System.out.println(dateTime);
      }
    };
    //We set the period to 2 seconds
    //Executes a task again and again every <period> time
    timer.scheduleAtFixedRate(repeatTask, 0, 2000);
  }

  protected void stop() {
    timer.cancel();
    instance.deleteObservers();
  }

  private void tick() {
    dateTime = LocalDateTime.now();
    setChanged();
    //System.out.println("DESPUES DE SETCHANGED");
    notifyObservers(dateTime);
    //System.out.println("DESPUES DE NOTIFY OBSERVERS");
  }

  @Override
  public void notifyObservers(Object arg) {
    super.notifyObservers(arg);
  }

}
