package Fita1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
  protected Logger logger = LoggerFactory.getLogger(Event.class);

  public Event(String n, Event f, List<String> l) {
    name = n;
    father = f;
    eventDuration = Duration.ZERO;
    if (father != null) {
      father.addEvent(this);
    }
    tags = l;
  }

  //Getters
  public String getName() {
    return name;
  }

  public List<String> getTags(){return tags; }

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
    assert invariant();

    logger.debug("The start time of the Event has been set to NOW");
  }

  public void setEndTime(LocalDateTime dateTime) {

    endTime = dateTime;
    if (father != null) {
      father.setEndTime(endTime);
    }
    assert invariant();

    logger.debug("The end time of the Event has been set to NOW");
  }

  public void setDuration(Duration childrenDuration) {
    eventDuration = childrenDuration;
    if (father != null) {
      father.calculateDuration();
    }
    assert invariant();

  }

  protected abstract void addEvent(Event event);

  protected abstract void calculateDuration();

  public abstract void acceptVisitor(Visitor visitor);

  protected boolean invariant(){
    return (this.getDuration().getSeconds() >= 0);
  }

  //Shows Durations in an understanding way
  protected String humanReadableFormat(Duration duration) {
    duration = duration.truncatedTo(ChronoUnit.SECONDS);
    return duration.toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase();
  }

}
