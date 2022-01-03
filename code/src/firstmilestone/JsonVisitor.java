package firstmilestone;

import org.json.*;

public class JsonVisitor implements Visitor{
  @Override
  public void visitInterval(Interval i) {
    i.getJsonInterval().put("initTime", i.getInitTime());
    i.getJsonInterval().put("endTime", i.getEndTime());
  }

  @Override
  public void visitTask(Task t) {
    t.getJson().put("id", t.getName());
    t.getJson().put("id", t.getId());
    t.getJson().put("initTime", t.getInitTime());
    t.getJson().put("endTime", t.getEndTime());
    t.getJson().put("duration", t.getDuration());
  }

  @Override
  public void visitProject(Project p) {
    p.getJson().put("name", p.getName());
    p.getJson().put("id", p.getId());
    p.getJson().put("initTime", p.getInitTime());
    p.getJson().put("endTime", p.getEndTime());
    p.getJson().put("duration", p.getDuration());
  }

}
