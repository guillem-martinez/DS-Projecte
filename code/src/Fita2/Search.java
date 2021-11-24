package Fita2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Fita1.*;

public class Search implements Visitor {


  private Event root;
  private static Search instance; //Singleton Printer
  private String found;
  private Logger logger = LoggerFactory.getLogger(Search.class);



  public Search(Event rootF, String required) {
    root = rootF; //We save the father of the tree in the printer for recursive printer
    found = required;
    rootF.acceptVisitor(this); //To start printing the tree by the root
  }

  public static Search getInstance(Event rootF, String required) {
    if (instance == null) {

      instance = new Search(rootF,required);
    }
    return instance;
  }

  @Override
  public void visitProject(Project p) {
    //if (p.getTag().contains(Tag a buscar)-->found.add(add p.getName())
    if(p.getTags()!= null){
      for(String iterator : p.getTags()) {
        if(iterator == this.found) {
          logger.info("Fita1.Project " + p.getName() + " has Tag: " + this.found);
          //System.out.println("Fita1.Project " + p.getName() + " has Tag: " + this.found);
        }

      }
    }




  }

  @Override
  public void visitTask(Task t) {
    if(t.getTags() != null){
      for (String iterator : t.getTags()) {
        if (iterator == this.found) {
          logger.info("Fita1.Task " + t.getName() + " has Tag: " + this.found);
          //System.out.println("Fita1.Task " + t.getName() + " has Tag: " + this.found);
        }
      }
    }



  }

  @Override
  public void visitInterval(Interval i) {

  }
}
