package firstmilestone;


import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//This Clock is the object Observable that the observers (intervals) will look at it.
//It is implemented as Singleton for use the same instance of a Clock for the entire program.

public class Clock extends Observable {

  private static LocalDateTime dateTime;
  private static Timer timer;
  private static Clock instance = null;
  private Logger logger = LoggerFactory.getLogger(Clock.class);


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


  //Creates a TimerTask object (repeatTask) that calls the tick() function inside.
  //Object repeatTask defines the action that is going to be executed in his run() method.
  //The run method is executed every time repeatTask is called
  //RepeatTask is called every time scheduleAtFixedRate is executed
  private Clock() {
    logger.trace("Instantiating a Clock ");
    timer = new Timer("Reloj");
    TimerTask repeatTask = new TimerTask() {
      @Override
      public void run() {

        tick();
      }
    };
    //We set the period to 2 seconds
    long period = 2000;
    logger.trace("Setting the period to " + period / 1000 + " seconds.");
    //Executes a task again and again every <period> time.
    //Delay can be added to the first execution.
    timer.scheduleAtFixedRate(repeatTask, 0, period);
  }

  protected void stop() {
    logger.debug("Stopping the clock");

    timer.cancel();
    instance.deleteObservers();
  }

  //Simulates the tick of a real clock
  //It changes the time to now and notify the observers.
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
