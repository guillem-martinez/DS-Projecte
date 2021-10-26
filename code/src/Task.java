import java.time.Duration;
import java.util.List;

public class Task extends Event {

  List<Interval> task_intervals;
  private Duration task_duration;

  public Task(String n, Event f, List<Interval> intervals) {
    super(n,f);
    task_intervals = intervals;
  }

  public void setTaskName(String name){
    this.name = name;
  }
  
  public Duration getDuration(){
    //recorrer els intervals i cridar a la funció que calculi l'interval
    return task_duration;
  }

  @Override
  public Duration calculateDuration() {
    return null;
  }
}
