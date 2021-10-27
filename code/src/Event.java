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
      this.name = n;
      this.father = f;
  }

  public void setName(String n){
    this.name = n;
  }

  public String getName(){
    return name;
  }


  public Event getFather(Event e) {return father;}
  public Duration getDuration(){return event_duration;}
  public abstract void calculateDuration();
  public abstract void acceptVisitor(Visitor visitor);

}
