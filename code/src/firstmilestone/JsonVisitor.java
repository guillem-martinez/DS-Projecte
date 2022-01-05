package firstmilestone;

import org.json.*;

import java.util.ArrayList;

public class JsonVisitor implements Visitor {

  private JSONObject father;
  private JSONArray childs, intervals;


  public JsonVisitor(){
    this.father = new JSONObject();
    this.childs = new JSONArray();
    this.intervals = new JSONArray();
  }

  public JSONObject getFather(){
    return this.father;
  }

  public JSONArray getChildren(){
    return this.childs;
  }

  @Override
  public void visitInterval(Interval i) {
    i.getJsonInterval().put("initTime", i.getInitTime());
    i.getJsonInterval().put("endTime", i.getEndTime());
    i.getJsonInterval().put("duration", i.getDuration().toSeconds());
    i.getJsonInterval().put("task", i.getTask().getName());

    this.intervals.put(i.getJsonInterval());

  }

  @Override
  public void visitTask(Task t) {
    t.getJson().put("name", t.getName());
    t.getJson().put("id", t.getId());
    t.getJson().put("initTime", t.getInitTime());
    t.getJson().put("endTime", t.getEndTime());
    t.getJson().put("duration", t.humanReadableFormat(t.getDuration()).substring(0,
        t.humanReadableFormat(t.getDuration()).length() - 1));
    t.getJson().put("parent", t.getFather().getName());
    t.getJson().put("tags", t.getTags());
    //hacer el write

    /*
    if (!t.getTaskIntervals().isEmpty()) {
      for (int i = 0; i < t.getTaskIntervals().size(); i++) {
        intervals.put(t.getTaskIntervals().get(i).getName());
      }
    }
    */
    JSONArray intervals = new JSONArray();
    ArrayList<Integer> iWithParent = new ArrayList<>();
    //if (!this.intervals.isEmpty()) {
      for (int i = 0; i < this.intervals.length(); i++) {
        JSONObject IntervalsJSONObject = (JSONObject) this.intervals.get(i);
        if(IntervalsJSONObject.getString("parent").equals(t.getName()))
        {
          iWithParent.add(i);
          intervals.put(IntervalsJSONObject);

        }
      }
    //}

    for(Integer it : iWithParent){
      this.intervals.remove(it);
    }
    t.getJson().put("intervals", intervals);

    this.childs.put(t.getJson());


  }

  @Override
  public void visitProject(Project p) {

    p.getJson().put("name", p.getName());
    p.getJson().put("id", p.getId());
    p.getJson().put("initTime", p.getInitTime());
    p.getJson().put("endTime", p.getEndTime());
    p.getJson().put("duration", p.humanReadableFormat(p.getDuration()).substring(0,
        p.humanReadableFormat(p.getDuration()).length() - 1));
    if(p.getFather() !=null){
      p.getJson().put("parent", p.getFather().getName());
      p.getJson().put("tags", p.getTags());
    }

    JSONArray children = new JSONArray();
    /*
    if (!p.getEvents().isEmpty()) {
      for (int i = 0; i < p.getEvents().size(); i++) {
        children.put(p.getEvents().get(i).getName());
      }
    }
    */
    ArrayList<Integer> iWithParent = new ArrayList<>();
    //if (!this.childs.isEmpty()) {
      for (int i = 0; i < this.childs.length(); i++) {
        JSONObject ChildJSONObject = (JSONObject) this.childs.get(i);
        if(ChildJSONObject.getString("parent").equals(p.getName()))
        {
          iWithParent.add(i);
          children.put(ChildJSONObject);

        }
      }
    //}

    p.getJson().put("children", children);
    for(Integer it : iWithParent){
      this.childs.remove(it);
    }



    if(p.getFather() == null){
      this.father = p.getJson();
    }else{
      this.childs.put(p.getJson());

    }

  }

}
