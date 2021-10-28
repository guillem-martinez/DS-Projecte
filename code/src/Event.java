import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Duration;

public abstract class Event{

  protected String name;
  private Event father;
  protected LocalDateTime initTime;
  protected LocalDateTime endTime;
  protected Duration event_duration;

  public Event(String n, Event f){
      name = n;
      father = f;
      event_duration = Duration.ZERO;
      if (father != null) {
        father.addEvent(this);
      }
  }

  public void setName(String n){
    this.name = n;
  }

  public String getName(){
    return name;
  }
  public abstract void addEvent(Event event);


  public LocalDateTime getInitTime(){ return initTime;}
  public LocalDateTime getEndTime(){ return endTime;}
  public void setInitTime(LocalDateTime dateTime) {
    if (initTime == null) {
      initTime = dateTime;
      if(father !=null){
        father.setInitTime(dateTime);

      }
    }
  }
  public void setEndTime(LocalDateTime dateTime){
    endTime = dateTime;
  }
  public void setDuration(Duration childrenDuration){
    event_duration = childrenDuration;
    if (father != null) {
      father.calculateDuration();
    }

  }
  public Event getFather() {return father;}
  public Duration getDuration(){return event_duration;}

  public abstract void calculateDuration();
  public abstract void acceptVisitor(Visitor visitor);

}
