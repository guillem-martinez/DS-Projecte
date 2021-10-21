import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {

  private static LocalDateTime dateTime;
  private static Timer timer;
  private static Clock instance = null;

  private Clock(){
    timer = new Timer();
  }

  public static void initializeClock(){
    timer = new Timer();
    TimerTask repeatTask = new TimerTask() {
      @Override
      public void run() {
        dateTime = LocalDateTime.now();
        System.out.println(dateTime);
      }
    };
  }

  public void stop(){
    timer.cancel();
  }

  public LocalDateTime getDateTime(){
    return dateTime;
  }

}
