package database;

import model.Movie;
import model.Timeline;
import model.User;

import java.util.*;

public class DB {
    public static Map<String, User> userMap = new HashMap<>();
    public static Map<String, List<Timeline>> timelineMap = new HashMap<>();
    public static Map<String, Movie> movieMap = new HashMap<>();
    public static List<String> names = new ArrayList<>(); // for declaring and initializing String list object
    public static int adult = 12000; // make the price of movie ticket static
    public static int teen = 10000;
    public static int kid = 8000;

  
    public static void init() {
        names = new ArrayList<String>() {
            {
                add("Crime City2");
                add("Doctor Strange2");
                add("Fantastic Beast3");
                add("Broker");
                add("Jurassic Park");
                add("Shut in");
            }
        };
        
     // put information about the movie name, pg, img(relative path), genre, cast, summary
        movieMap.put("Crime City2", new Movie(
                "Crime City2",
                15,
                "src/images/Crime City2.jpeg",
                "action",
                "Ma Dong Suk",
                "Action Movie"
        ));
        movieMap.put("Doctor Strange2", new Movie("Doctor Strange2",
                19,
                "src/images/Doctor Strange2.jpeg",
                "Fantasy",
                "Benedict Cumberbatch",
                "Dotor Strange tries to find the stone"
        ));
        movieMap.put("Fantastic Beast3", new Movie("Fantastic Beast3",
                15,
                "src/images/Fantastic Beast3.jpeg",
                "Fantasy",
                "Eddie Redmayne",
                "Adventure with Fantastic Beasts"
        ));
        movieMap.put("Shut in", new Movie("Shut in",
                19,
                "src/images/Shut in.jpeg",
                "Horror",
                "Naomi Watts",
                "It happens after breaking into a house"
        ));
        movieMap.put("Broker", new Movie("Broker",
                15,
                "src/images/Broker.jpeg",
                "Drama",
                "Kang Dong won, IU",
                "Looking for a kid"
        ));
        movieMap.put("Jurassic Park", new Movie("Jurassic Park",
                15,
                "src/images/Jurassic Park.jpeg",
                "SF",
                "Chris Prat",
                "Looking for a dianosour"
        ));
        //put data
    }

    // put information about users
    public static void putUser(String id, User user) {
        userMap.put(id, user);
    }

    public static User getUser(String id) {
        return userMap.get(id);
    }

    public static void setUser(Map<String, User> param) {
        userMap.putAll(param);
    }

    public static List<Timeline> getTimeline(String id) {
        List<Timeline> timelineList = timelineMap.get(id);
        if (timelineList == null) { // if timelineList is null
            return Collections.emptyList(); 
        }
        return timelineMap.get(id); // if there is purchased record get id
    }

    public static void putTimeline(String id, Timeline timeline) {
        if (!timelineMap.containsKey(id)) { // if timelineMap doesn't contain id value
            timelineMap.put(id, new ArrayList<>()); // put it into the list
        }
        timelineMap.get(id).add(timeline);
    }

    public static Movie getMovie(String name) {
        return movieMap.get(name);
    }

    public static int getAdult() {
        return adult;
    }

    public static int getTeen() {
        return teen;
    }

    public static int getKid() {
        return kid;
    }
}
