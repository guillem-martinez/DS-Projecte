package firstmilestone;


import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//This Fita1.Clock is the object Observable that the observers (intervals) will look at it.
//It is implemented as Singleton for use the same instance of a Fita1.Clock for the entire program.

public class Clock extends Observable {

  private static LocalDateTime dateTime;
  private static Timer timer;
  private static Clock instance = null;
  private Logger logger = LoggerFactory.getLogger(Clock.class);


  //Getters
  //Method for getting the Singleton Fita1.Clock
  public static Clock getInstance() {
    if (instance == null) {

      instance = new Clock();
    }
    return instance;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }


  //Private clock constructor
  //Creates a TimerTask object that calls the tick() function inside.
  private Clock() {
    logger.trace("Instantiating a Clock ");
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
    long period = 2000;
    logger.trace("Setting the period to " + period / 1000 + " seconds.");
    //Executes a task again and again every <period> time
    timer.scheduleAtFixedRate(repeatTask, 0, period);
  }

  protected void stop() {
    logger.debug("Stopping the clock");

    timer.cancel();
    instance.deleteObservers();
  }

  private void tick() {
    dateTime = LocalDateTime.now();
    setChanged();
    notifyObservers(dateTime);
    logger.debug("Clock notify his observers for changing it's own state");
  }

  @Override
  public void notifyObservers(Object arg) {
    super.notifyObservers(arg);
  }

}
