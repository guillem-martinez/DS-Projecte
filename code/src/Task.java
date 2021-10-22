import java.util.List;

public class Task extends Event {

  List<Interval> task_duration;

  public void setTaskName(String name){
    this.name = name;
  };
}
