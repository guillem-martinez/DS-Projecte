import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task extends Event {

  public ArrayList<Interval> task_intervals;

  public Task(String name, Event father) {
    super(name,father);
    task_intervals = new ArrayList<Interval>();
    System.out.println(name+" SUCCESSFUL");
  }

  @Override
  public void addEvent(Event event){}

  public void setTaskName(String name){
    this.name = name;
  }
  
  public Duration getDuration(){
    return event_duration;
  }

  public void startTask(){
    task_intervals.add(new Interval(this));
  }

  @Override
  public void calculateDuration() {
    event_duration = Duration.ZERO;
    for(int i=0; i<task_intervals.size(); i++){
      event_duration = event_duration.plus(task_intervals.get(i).getDuration());
    }
  }

  public void acceptVisitor(Visitor visitor){
    visitor.visitTask(this);
  }
}
