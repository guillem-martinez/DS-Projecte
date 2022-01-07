package firstmilestone;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//Observer that is looking to the Observable (clock) and updates for every tick in clock

public class Interval implements Observer {

  private LocalDateTime initTime;
  private LocalDateTime endTime;
  private Duration duration;
  private Task task;
  private Logger logger = LoggerFactory.getLogger(Interval.class);
  private JSONObject jsonInterval;
  private boolean active;

  public Interval(Task t) {
    task = t;
    jsonInterval = new JSONObject();
    active = true;

    if (task.getInitTime() == null) {
      task.setInitTime(task.initTime);
    }
    Clock.getInstance().addObserver(this);
    logger.debug("Interval created. Observes the clock. It's compulsory assigned to a task");
  }

  //The update() method it is called whenever the observable (clock) changes state.
  @Override
  public void update(Observable o, Object arg) {


    LocalDateTime now = (LocalDateTime) arg;
    if (initTime == null) {
      initTime = now;
      task.setInitTime(initTime);
    }

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

  public JSONObject getJsonInterval() { return jsonInterval; }


  //If his Father task stops, the interval also stop.
  protected void endInterval() {
    endTime = LocalDateTime.now();
    duration = Duration.between(initTime, endTime);
    active = false;
    Clock.getInstance().deleteObserver(this);

    logger.debug("End Time of the interval set to NOW and removes him as an observer");
  }

  public void acceptVisitor(Visitor visitor) {
    visitor.visitInterval(this);
  }

  public JSONObject toJson(int i){
    JSONObject j = new JSONObject();

    j.put("initTime", initTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    j.put("endTime", endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    j.put("duration", duration.getSeconds());
    j.put("active", active);
    j.put("class", this.getClass().getName().substring(15));

    return j;

  }

}
