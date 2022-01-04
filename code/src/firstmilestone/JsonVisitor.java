package firstmilestone;

import org.json.*;

public class JsonVisitor implements Visitor {
  @Override
  public void visitInterval(Interval i) {
    i.getJsonInterval().put("initTime", i.getInitTime());
    i.getJsonInterval().put("endTime", i.getEndTime());
  }

  @Override
  public void visitTask(Task t) {
    t.getJson().put("name", t.getName());
    t.getJson().put("id", t.getId());
    t.getJson().put("initTime", t.getInitTime());
    t.getJson().put("endTime", t.getEndTime());
    t.getJson().put("duration", t.humanReadableFormat(t.getDuration()).substring(0,
        t.humanReadableFormat(t.getDuration()).length() - 1));
  }

  @Override
  public void visitProject(Project p) {

    p.getJson().put("name", p.getName());
    p.getJson().put("id", p.getId());
    p.getJson().put("initTime", p.getInitTime());
    p.getJson().put("endTime", p.getEndTime());
    p.getJson().put("duration", p.humanReadableFormat(p.getDuration()).substring(0,
        p.humanReadableFormat(p.getDuration()).length() - 1));

    JSONArray children = new JSONArray();
    if (!p.getEvents().isEmpty()) {
      for (int i = 0; i < p.getEvents().size(); i++) {
        children.put(p.getEvents().get(i).getName());
      }
    }

    p.getJson().put("children", children);
  }

}
