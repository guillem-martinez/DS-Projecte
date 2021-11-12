import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;


//Observer that is looking to the Observable (clock) and updates for every tick in clock

public class Interval implements Observer {

  private LocalDateTime initTime;
  private LocalDateTime endTime;
  private Duration duration;
  private Task task;

  public Interval(Task t) {
    task = t;
    if (task.getInitTime() == null) {
      task.setInitTime(task.initTime);
    }
    Clock.getInstance().addObserver(this);
  }

  //The update() method it is called whenever the observable (clock) changes state.
  @Override
  public void update(Observable o, Object arg) {

    LocalDateTime now = (LocalDateTime) arg;

    if (initTime == null) {
      initTime = now;

      task.setInitTime(initTime);
    }
    //System.out.println("initTime " + initTime + "\nendTime " + endTime);
    endTime = now;
    duration = Duration.between(initTime, endTime);


    task.calculateDuration();

    Print.getInstance(null).printInterval();
  }

  //Getters
  public LocalDateTime getInitTime() {
    return initTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public Duration getDuration() {
    return duration;
  }

  public Task getTask() {
    return task;
  }

  protected void endInterval() {
    endTime = LocalDateTime.now();
    duration = Duration.between(initTime, endTime);
    Clock.getInstance().deleteObserver(this);
  }

  public void acceptVisitor(Visitor visitor) {
    visitor.visitInterval(this);
  }

}
