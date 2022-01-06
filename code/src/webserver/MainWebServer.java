package webserver;

import firstmilestone.Clock;
import firstmilestone.Event;
import firstmilestone.Project;
import firstmilestone.Task;

import java.util.Arrays;

public class MainWebServer {
  public static void main(String[] args) {
    webServer();
  }

  public static void webServer() {
    final Event root = makeTreeCourses();
    // implement this method that returns the tree of
    // appendix A in the practicum handout

    // start your clock

    Clock.getInstance();

    new WebServer(root);
  }

  public static Event makeTreeCourses(){
    Project root = new Project(0,"root", null, null);
    Project swDesign = new Project(1,"software design", root, Arrays.asList("java", "flutter"));
    Project swTesting = new Project(2,"Software testing", root, Arrays.asList("c++",
        "Java", "python"));
    Project db = new Project(3,"databases", root, Arrays.asList("SQL", "python", "C++"));
    Task transportation = new Task(4,"transportation", root, null);
    Project problems = new Project(5,"problems", swDesign, null);
    Project timeTracker = new Project(6,"TimeTracker", swDesign, null);
    Task read = new Task(7,"Read Handout", timeTracker, null);
    Task firstMilestone = new Task(8,"First Milestone",
        timeTracker, Arrays.asList("Java", "IntelliJ"));
    final Task firstList = new Task(9,"First List", problems, Arrays.asList("java"));
    final Task secondList = new Task(10,"Second List", problems, Arrays.asList("Dart"));

    return root;
  }
}
