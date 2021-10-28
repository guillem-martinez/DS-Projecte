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
    if(task.getInitTime() == null){
      task.setInitTime(task.initTime);
    }
    Clock.getInstance().addObserver(this);
  }


  //The update() method it is called whenever the observable (clock) changes state.
  @Override
  public void update(Observable o, Object arg) {

     LocalDateTime now = (LocalDateTime) arg;

    if(initTime == null ){
      initTime = now;

      task.setInitTime(initTime);

    }

    //System.out.println("initTime " + initTime + "\nendTime " + endTime);
    endTime = now;
    duration = Duration.between(initTime, endTime);
    //System.out.println("duration");
    //System.out.println("AFTER BETWEEN");
    task.calculateDuration();


    Print.getInstance(null).printerInterval();


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
    duration = Duration.between(initTime,endTime);
    Clock.getInstance().deleteObserver(this);
  }

  public void acceptVisitor(Visitor visitor){
    visitor.visitInterval(this);
  }

}
