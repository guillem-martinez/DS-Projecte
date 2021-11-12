import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;



//Component Class of the Composite pattern
public abstract class Event {


  protected static final int delay = 2;
  protected String name;
  private Event father;
  protected LocalDateTime initTime;
  protected LocalDateTime endTime;
  protected Duration eventDuration;
  protected List<String> tags;

  public Event(String n, Event f) {
    name = n;
    father = f;
    eventDuration = Duration.ZERO;
    if (father != null) {
      father.addEvent(this);
    }
  }

  //Getters
  public String getName() {
    return name;
  }

  public LocalDateTime getInitTime() {
    return initTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public Event getFather() {
    return father;
  }

  public Duration getDuration() {
    return eventDuration;
  }

  //Setters
  public void setName(String n) {
    name = n;
  }

  public void setInitTime(LocalDateTime dateTime) {
    if (initTime == null) {
      initTime = dateTime;
      if (father != null) {
        father.setInitTime(dateTime);

      }
    }
  }

  public void setEndTime(LocalDateTime dateTime) {

    endTime = dateTime;
    if (father != null) {
      father.setEndTime(endTime);
    }
  }

  public void setDuration(Duration childrenDuration) {
    eventDuration = childrenDuration;
    if (father != null) {
      father.calculateDuration();
    }
  }

  protected abstract void addEvent(Event event);

  protected abstract void calculateDuration();

  public abstract void acceptVisitor(Visitor visitor);

  //Shows Durations in an understanding way
  protected String humanReadableFormat(Duration duration) {
    duration = duration.truncatedTo(ChronoUnit.SECONDS);
    return duration.toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase();
  }

}
