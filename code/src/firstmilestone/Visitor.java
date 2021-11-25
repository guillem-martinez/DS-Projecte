package firstmilestone;

public interface Visitor {
  void visitTask(Task t);

  void visitProject(Project p);

  void visitInterval(Interval i);
}
