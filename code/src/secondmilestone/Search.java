package secondmilestone;

import firstmilestone.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Search implements Visitor {


  private Event root;
  private static Search instance; //Singleton Printer
  private String found;
  private Logger logger = LoggerFactory.getLogger(Search.class);



  public Search(Event rootF, String required) {
    logger.trace("Instantiating a Search");
    root = rootF; //We save the father of the tree in the printer for recursive printer
    found = required;
    rootF.acceptVisitor(this); //To start printing the tree by the root
    logger.debug("Searching Tasks or Projects with tag: " + found);
  }

  public static Search getInstance(Event rootF, String required) {
    if (instance == null) {

      instance = new Search(rootF, required);
    }
    return instance;
  }

  @Override
  public void visitProject(Project p) {

    if (p.getTags() != null) {
      for (String iterator : p.getTags()) {
        if (iterator == this.found) {
          logger.info("Project " + p.getName() + " has Tag: " + this.found);
        }

      }
    }

  }

  @Override
  public void visitTask(Task t) {

    if (t.getTags() != null) {
      for (String iterator : t.getTags()) {
        if (iterator == this.found) {
          logger.info("Task " + t.getName() + " has Tag: " + this.found);
        }
      }
    }

  }

  @Override
  public void visitInterval(Interval i) {}
}
