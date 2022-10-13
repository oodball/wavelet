import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
// import java.util.*;
class Handler implements URLHandler {

    int num = 0;
    ArrayList<String> listRequest = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("This is the Search Engine Homepage");
        } else if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            listRequest.add(parameters[1]);
                if (parameters[0].equals("s")) {
                    return String.format("Adding... ", listRequest.get(listRequest.size() - 1 ));
                }
            }else if (url.getPath().equals("/search")) {
                String[] parameters = url.getQuery().split("=");
                    if (parameters[0].equals("s")) {
                        for(String s: listRequest){
                            if(s.contains(parameters[1])){
                                return s;
                            }
                            return String.format("Searching for: ", parameters[1]);
                        }
                    }
                }
            return String.format("We couldn't quite find what you were looking for.");
        } 
        // else {
        //     System.out.println("Path: " + url.getPath());
        // }
        //     return "404 Not Found!";
    }

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

