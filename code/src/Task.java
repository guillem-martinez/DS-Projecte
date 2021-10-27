import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task extends Event {

  private ArrayList<Interval> task_intervals;

  public Task(String n, Event f) {
    super(n,f);
    task_intervals = new ArrayList<Interval>();
  }

  public void setTaskName(String name){
    this.name = name;
  }
  
  public Duration getDuration(){
    return event_duration;
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
