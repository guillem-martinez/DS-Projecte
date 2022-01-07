package webserver;


import firstmilestone.Event;
import firstmilestone.Print;
import firstmilestone.Project;
import firstmilestone.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class WebServer {
  private static final int PORT = 8080; // port to listen to

  private Event currentEvent;
  private final Event root;
  private int placeholderId = 20;
  private Logger logger = LoggerFactory.getLogger(WebServer.class);

  public WebServer(Event root) {
    this.root = root;
    System.out.println(root);
    currentEvent = root;
    try {
      ServerSocket serverConnect = new ServerSocket(PORT);
      System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
      // we listen until user halts server execution
      while (true) {
        // each client connection will be managed in a dedicated Thread
        new SocketThread(serverConnect.accept());
        // create dedicated thread to manage the client connection
      }
    } catch (IOException e) {
      System.err.println("Server Connection error : " + e.getMessage());
    }
  }

  private Event findActivityById(int id) {
    logger.debug("FINDING ACTIVITY WITH ID: "+id);
    return root.findActivityById(id);
  }

  private class SocketThread extends Thread {
    // SocketThread sees WebServer attributes
    private final Socket insocked;
    // Client Connection via Socket Class

    SocketThread(Socket insocket) {
      this.insocked = insocket;
      this.start();
    }

    @Override
    public void run() {
      // we manage our particular client connection
      BufferedReader in;
      PrintWriter out;
      String resource;

      try {
        // we read characters from the client via input stream on the socket
        in = new BufferedReader(new InputStreamReader(insocked.getInputStream()));
        // we get character output stream to client
        out = new PrintWriter(insocked.getOutputStream());
        // get first line of the request from the client
        String input = in.readLine();
        // we parse the request with a string tokenizer

        System.out.println("sockedthread : " + input);

        StringTokenizer parse = new StringTokenizer(input);
        String method = parse.nextToken().toUpperCase();
        // we get the HTTP method of the client
        if (!method.equals("GET")) {
          System.out.println("501 Not Implemented : " + method + " method.");
        } else {
          // what comes after "localhost:8080"
          resource = parse.nextToken();
          System.out.println("input " + input);
          System.out.println("method " + method);
          System.out.println("resource " + resource);

          parse = new StringTokenizer(resource, "/[?]=&");
          int i = 0;
          String[] tokens = new String[20];
          // more than the actual number of parameters
          while (parse.hasMoreTokens()) {
            tokens[i] = parse.nextToken();
            System.out.println("token " + i + "=" + tokens[i]);
            i++;
          }

          // Make the answer as a JSON string, to be sent to the Javascript client
          String answer = makeHeaderAnswer() + makeBodyAnswer(tokens);
          System.out.println("answer\n" + answer);
          // Here we send the response to the client
          out.println(answer);
          out.flush(); // flush character output stream buffer
        }

        in.close();
        out.close();
        insocked.close(); // we close socket connection
      } catch (Exception e) {
        System.err.println("Exception : " + e);
      }
    }


    private String makeBodyAnswer(String[] tokens) throws UnsupportedEncodingException {
      String body = "";
      switch (tokens[0]) {
        case "get_tree": {
          logger.debug("GETTING TREE...");
          int id = Integer.parseInt(tokens[1]);
          Event event = findActivityById(id);
          assert (event != null);
          logger.debug("EVENTS CONVERTING TO JSON");
          body = event.toJson(1).toString();
          break;
        }
        case "start": {
          logger.debug("STARTING TASK...");
          int id = Integer.parseInt(tokens[1]);
          Event event = findActivityById(id);
          assert (event != null);
          Task task = (Task) event;
          task.startTask();
          body = "{}";
          break;
        }
        case "stop": {
          logger.debug("STOPPING TASK...");
          int id = Integer.parseInt(tokens[1]);
          Event event = findActivityById(id);
          assert (event != null);
          Task task = (Task) event;
          task.stopTask();
          body = "{}";
          break;
        }
        case "addEvent": {
          logger.debug("ADDING EVENT...");
          int id = Integer.parseInt(tokens[1]);
          Project father = (Project) findActivityById(id);
          Boolean isProject = Boolean.parseBoolean(tokens[2]);
          String name = tokens[3];
          String tagsObtained = tokens[4];
          List<String> tags = Arrays.asList(tagsObtained.split("\\s*,\\s*"));

          logger.debug("CREATING NEITHER A PROJECT OR A TASK");
          if (isProject == true) {
            Project project = new Project(placeholderId + 1, name, father, tags);
            logger.debug("PROJECT CREATED");
          } else {
            Task task = new Task(placeholderId + 1, name, father, tags);
            logger.debug("TASK CREATED");
            //father.addEvent(task);
          }
          placeholderId++;
          break;
        }
        // TODO: edit task, project properties
        default:
          assert false;
      }
      System.out.println(body);
      return body;
    }

    private String makeHeaderAnswer() {
      String answer = "";
      answer += "HTTP/1.0 200 OK\r\n";
      answer += "Content-type: application/json\r\n";
      answer += "Access-Control-Allow-Origin: *\r\n";
      answer += "\r\n";
      // blank line between headers and content, very important !
      return answer;
    }
  }
}
