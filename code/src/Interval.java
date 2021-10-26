import java.time.LocalDateTime;
import java.util.Observer;
import java.time.Duration;
import java.util.Observable;

public class Interval implements Observer {

  private LocalDateTime initTime;
  private LocalDateTime endTime;
  private Duration duration;
  private Task task;



  public Interval(Task t){
    task = t;
  }


  //The update() method it is called whenever the observable (clock) changes state.
  @Override
  public void update(Observable o, Object arg) {
    endTime = (LocalDateTime) arg;
    duration = Duration.between(initTime, endTime);
    task.calculateDuration();

  }

  public LocalDateTime getInitTime(){
    return initTime;
  }
  public LocalDateTime getEndTime(){
    return endTime;
  }
  public Duration getDuration() { return duration;}

  public void endInterval(){
    endTime = LocalDateTime.now();

    Clock.getInstance().deleteObserver(this);
  }

}
