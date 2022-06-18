package model.common;

import model.Movie;

public interface UserModule {
    String reserve(Movie movie, int adult, int teen, int kid);
}
