import java.util.ArrayList;
import java.util.List;

public class Search implements Visitor {


  private Event root;
  private static Search instance; //Singleton Printer
  private List<String> found;

  public Search(Event rootF) {
    root = rootF; //We save the father of the tree in the printer for recursive printer
    rootF.acceptVisitor(this); //To start printing the tree by the root
    found = new ArrayList<String>();
  }

  public static Search getInstance(Event rootF) {
    if (instance == null) {
      instance = new Search(rootF);
    }
    return instance;
  }

  @Override
  public void visitProject(Project p) {
    //if (p.getTag().contains(Tag a buscar)-->found.add(add p.getName())
  }

  @Override
  public void visitTask(Task t) {

  }

  @Override
  public void visitInterval(Interval i) {

  }
}
