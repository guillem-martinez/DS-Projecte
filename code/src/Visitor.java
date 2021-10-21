public interface Visitor {

  default void visitTask(Task t){}
  default void visitProject(Project p){}
}
