package service;

import database.DB;
import model.Movie;

public class MovieService {
    public static Movie getMovie(String name) {
        return DB.getMovie(name);
    }
}
